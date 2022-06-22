package com.xavier.domian;

import lombok.Data;

/**
 * @ClassName: Permission
 * @Author: Xavier
 * @CreateTime: 2022-06-22  14:43
 * @Description: 数据库实体类
 */
@Data
public class Permission {

    private Integer id;
    private String name;
    private String keyword;
    private String description;
    private String type;
    private Integer parent_id;

}
