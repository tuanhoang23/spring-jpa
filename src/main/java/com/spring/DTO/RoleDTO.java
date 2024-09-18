package com.spring.DTO;

import java.sql.Timestamp;

public class RoleDTO  extends AbstractDTO{
    private String name;

    private String code;


    public RoleDTO() {
    }

    public RoleDTO(long id, Timestamp createAt, Timestamp modifileAt, String createBy, String modifileBy, String name, String code) {
        super(id, createAt, modifileAt, createBy, modifileBy);
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
