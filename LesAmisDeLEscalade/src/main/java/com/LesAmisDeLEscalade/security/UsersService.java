package com.LesAmisDeLEscalade.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LesAmisDeLEscalade.dao.UsersRepository;
import com.LesAmisDeLEscalade.entities.Users;

@Service("userService")
public class UsersService implements UserDetailsService {

	private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = UsersRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("No user present with username : " + username);
        }
        else {
            return users;
        }
    }
}
