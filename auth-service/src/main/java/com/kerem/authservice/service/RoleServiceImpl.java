package com.kerem.authservice.service;

import com.kerem.authservice.dao.RoleRepository;

import com.kerem.authservice.exception.abstracts.CommonErrorCodes;
import com.kerem.authservice.exception.specific.GenericException;
import com.kerem.authservice.service.abstracts.RoleService;
import com.kerem.authservice.entity.Role;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(UUID id) {
        return roleRepository.findById(id).orElseThrow(() -> new GenericException(CommonErrorCodes.ROLE_NOT_FOUND));
    }

    @Override
    public Role addRole(Role role) {
        if (roleRepository.existsByName(role.getName())) {
            throw new GenericException(CommonErrorCodes.ROLE_ALREADY_EXISTS);
        }
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByName(name).orElseThrow(() -> new GenericException(CommonErrorCodes.ROLE_NOT_FOUND));
    }


}
