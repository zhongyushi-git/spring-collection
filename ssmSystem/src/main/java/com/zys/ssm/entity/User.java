package com.zys.ssm.entity;

import lombok.*;


@Getter
@Setter
@ToString
public class User {
    private String id;
    private String name;
    private String password;
    private String phone;
}
