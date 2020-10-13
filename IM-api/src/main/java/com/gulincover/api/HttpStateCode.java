package com.gulincover.api;

public enum  HttpStateCode {

    OK(200, "成功"),
    BAD_REQUEST(400, "坏的请求"),
    UNAUTHORIZED(401, "未授权"),
    Forbidden(403, "权限不足"),
    NOT_FOUND(404, "页面未找到"),
    METHOD_NOT_ALLOWED(405, "方法不被允许"),
    SERVER_ERROR(500, "服务器错误"),
    BAD_GATEWAY(502, "坏的网关"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时");

    Integer coder;
    String msg;

    HttpStateCode(Integer s, String msg) {
        this.coder = s;
        this.msg = msg;
    }
}