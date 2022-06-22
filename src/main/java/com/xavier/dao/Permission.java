package com.xavier.dao;

import lombok.Data;

@Data
public class Permission {

    private Integer id;
    private String name;
    private String keyword;
    private String description;
    private String type;
    private Integer parent_id;

}
