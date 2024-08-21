package com.hqyj.pojo;

import lombok.Data;

@Data
public class ResultVo {

    // 状态码
    private Integer code;
    // 提示信息
    private String msg;
    // 数据集
    private Object data;

    public ResultVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //成功01(默认)
    public static ResultVo success() {
        return new ResultVo(200, "success", null);
    }
    //成功02
    public static ResultVo success(String msg) {
        return new ResultVo(200, msg, null);
    }
    //成功03
    public static ResultVo success(Object data) {
        return new ResultVo(200, "success", data);
    }

    //错误01(默认)
    public static ResultVo error() {
        return new ResultVo(500, "error", null);
    }
    //错误02
    public static ResultVo error(String msg) { return new ResultVo(500, msg, null); }
    //错误03
    public static ResultVo error(Object data) {
        return new ResultVo(500, "error", data);
    }

}
