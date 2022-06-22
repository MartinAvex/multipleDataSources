package com.xavier.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface PermissionService<T> {

    List<T> findAll();

}
