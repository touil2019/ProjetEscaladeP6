package com.LesAmisDeLEscalade.entities;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.LesAmisDeLEscalade.security.BCryptManagerUtil;
import com.LesAmisDeLEscalade.security.RoleEnum;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@Column(name = "username", nullable = false, unique = true)
	@NotEmpty(message = "votre pseudo doit contenir au minimum 2 caractères")
	@Size(min = 2)
	private String username;

	@NotNull
	@Column(name = "password", nullable = false)
	@Size(min = 4)
	private String password;

	@NotNull
	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Veuillez saisir une adresse mail valide")
	private String email;

	@NotNull
	@Size(min = 2)
	@Column(name = "firstname", nullable = false)
	private String firstname;

	@NotNull
	@Size(min = 2)
	@Column(name = "lastname", nullable = false)
	private String lastname;

	@ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
	
	@JoinTable(indexes = {
	@Index(name = "INDEX_USER_ROLE", columnList = "id_utilisateur") }, name = "roles", joinColumns = @JoinColumn(name = "id_utilisateur"))
	@Enumerated(EnumType.STRING)
	private Set<RoleEnum> roles;

	@Column(name = "account_non_expired")
	private boolean accountNonExpired;

	@Column(name = "account_non_locked")
	private boolean accountNonLocked;

	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired;

	@Column(name = "enabled")
	private boolean enabled;

	@OneToMany
	(mappedBy = "utilisateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Topo> topos;
	
	public Utilisateur() {
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
		this.enabled = true;
		this.roles = new HashSet<>();
		this.roles.add(RoleEnum.ROLE_USER);
	}

	public Utilisateur(String username, String password, String firstname, String lastname, String email,
			Set<RoleEnum> roles) {
		this.username = username;
		this.password = BCryptManagerUtil.passwordencoder().encode(password);
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.accountNonExpired = true;
		this.accountNonLocked = true;
		this.credentialsNonExpired = true;
		this.enabled = true;
		this.roles = roles;
	}

		public Collection<Topo> getTopos() {
		return topos;
	}

	public void setTopos(Collection<Topo> topos) {
		this.topos = topos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<RoleEnum> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEnum> roles) {
		this.roles = roles;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils
				.collectionToCommaDelimitedString(getRoles().stream().map(Enum::name).collect(Collectors.toList()));
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setPassword(String password) {
		if (!password.isEmpty()) {
			this.password = BCryptManagerUtil.passwordencoder().encode(password);
		}
	}
}