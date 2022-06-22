package com.xavier.controller;

import com.xavier.annotation.DataSource;
import com.xavier.domian.Permission;
import com.xavier.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: PermissionController
 * @Author: Xavier
 * @CreateTime: 2022-06-22  14:43
 * @Description: 控制层, 不同的请求访问不同的数据源
 */
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

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
