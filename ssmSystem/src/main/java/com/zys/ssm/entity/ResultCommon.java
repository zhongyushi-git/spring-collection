package com.zys.ssm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResultCommon {
    private int code;//操作的状态
    private String msg;//操作的结果
    private Object rows;//数据
    private long total;//数据条数

    public ResultCommon() {
    }

    public ResultCommon(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultCommon(int code, String msg, Object rows) {
        this.code = code;
        this.msg = msg;
        this.rows = rows;
    }

    public ResultCommon(int code, String msg, Object rows,long total) {
        this.code = code;
        this.msg = msg;
        this.rows = rows;
        this.total = total;
    }
}
