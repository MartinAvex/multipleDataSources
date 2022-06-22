package com.xavier.controller;

import com.xavier.annotation.DataSource;
import com.xavier.dao.Permission;
import com.xavier.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService<Permission> permissionService;

    @GetMapping("/master")
    public List<Permission> findAllFromMasterSource() {
        return permissionService.findAll();
    }

    @GetMapping("/slave")
    @DataSource(name = "slave")
    public List<Permission> findAllFromSlaveSource() {
        return permissionService.findAll();
    }

}
