package com.LesAmisDeLEscalade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LesAmisDeLEscalade.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}