package com.yday72__7.reviewCodes.enumClass;

public enum HttpStatus implements StatusCode {
    SUCCESS(200, "请求成功"),
    BAD_REQUEST(400, "参数错误"),
    NOT_FOUND(404, "资源不存在"),
    SERVER_ERROR(500, "服务器内部错误");

    // 成员变量
    private final int code;
    private final String msg;

    // 构造方法
    HttpStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // 统一实现接口，也可以每个枚举常量单独实现
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
