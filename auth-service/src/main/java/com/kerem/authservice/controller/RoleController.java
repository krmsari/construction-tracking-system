package com.kerem.authservice.controller;

import com.kerem.authservice.service.abstracts.RoleService;
import com.kerem.authservice.entity.Role;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/add")
    public void addRole(@RequestBody Role role) {
        roleService.addRole(role);
    }
        @GetMapping("/getByName/{name}")
    public Role getRoleByName(@PathVariable String name) {
        return roleService.getRoleByName(name);
    }
}
