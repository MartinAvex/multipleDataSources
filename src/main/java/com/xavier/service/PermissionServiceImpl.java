package com.xavier.service;

import com.xavier.dao.Permission;
import com.xavier.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService<Permission> {

    @Autowired
    private PermissionMapper<Permission> permissionMapper;

    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }

}
