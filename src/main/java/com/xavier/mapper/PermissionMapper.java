package com.xavier.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface PermissionMapper<T> {

    List<T> findAll();

}
