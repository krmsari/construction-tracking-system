package com.kerem.authservice.dao;

import com.kerem.authservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Boolean existsByName(String name);

    Optional<Role> findRoleByName(String name);
}
