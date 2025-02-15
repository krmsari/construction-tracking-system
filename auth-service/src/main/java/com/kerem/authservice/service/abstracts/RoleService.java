package com.kerem.authservice.service.abstracts;



import com.kerem.authservice.entity.Role;

import java.util.UUID;

public interface RoleService {

    Role getRoleById(UUID id);

    void addRole(Role role);

    Role getRoleByName(String name);
}
