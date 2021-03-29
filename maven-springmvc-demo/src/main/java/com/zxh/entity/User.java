package com.zxh.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


@Data
public class User {
    @NotBlank
    private String username;

    private String password;
}
