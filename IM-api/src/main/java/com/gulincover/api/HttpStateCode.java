package com.gulincover.api;

public enum HttpStateCode {

    UNKNOWN_EXCEPTION(-1, "未知异常"),

    /*
    customize code
     */
    CUSTOMIZE_REGISTER_SUCCESS(-2000, "注册成功"),
    CUSTOMIZE_USERINFO_ERROR(-2001, "用户信息错误"),
    CUSTOMIZE_REGISTER_NICKNAME_REPEAT(-2002, "昵称已存在"),
    CUSTOMIZE_REGISTER_EMAIL_REPEAT(-2003,"邮箱已存在"),
    CUSTOMIZE_REGISTER_PHONE_REPEAT(-2004,"电话已存在"),
    CUSTOMIZE_REGISTER_NICKNAME_NOT_REPEAT(-2005,"昵称未注册"),
    CUSTOMIZE_REGISTER_EMAIL_NOT_REPEAT(-2006,"邮箱未注册"),
    CUSTOMIZE_REGISTER_PHONE_NOT_REPEAT(-2007,"电话未注册"),
    CUSTOMIZE_REGISTER_PHONE_FAILURE(-2008,"注册失败"),
    CUSTOMIZE_REGISTER_EMAIL_FAILURE(-2009,"注册失败"),


    CUSTOMIZE_OPERATION_FAILURE(-3000,"操作失败"),
    CUSTOMIZE_USE_FAILURE(-3001,"使用失败"),
    CUSTOMIZE_SETTLEMENT_FAILURE(-3002,"结算失败"),
    CUSTOMIZE_LOGIN_FAILURE(-3003,"登录失败"),
    CUSTOMIZE_FILE_UPLOAD_FAILURE(-3004,"文件上传失败"),
    CUSTOMIZE_SELECT_FAILURE(-3005,"查询失败"),

    CUSTOMIZE_NOT_REGISTER(-4000,"未注册"),
    CUSTOMIZE_RESP_IS_EMPTY(-5000,"结果不存在"),

    /*
    sentinel exception
     */
    SENTINEL_FLOW(-1001, "限流异常"),
    SENTINEL_DEGRADE(-1002, "降级异常"),
    SENTINEL_PARAM_FLOW(-1003, "参数限流异常"),
    SENTINEL_AUTHORITY(-1004, "授权异常"),
    SENTINEL_SYSTEM_BLOCK(-1005, "系统负载异常"),
    /*
    200
     */
    OK(200, "成功"),
    /*
    300
     */

    /*
    400
     */
    BAD_REQUEST(400, "坏的请求"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "权限不足"),
    NOT_FOUND(404, "页面未找到"),
    METHOD_NOT_ALLOWED(405, "方法不被允许"),

    RANGE_NOT_SATISFIABLE(416,"请求范围无效"),

    PARAMETER_NOT_INTACT(481,"请求参数不完整"),
    /*
    500
     */
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


    @Override
    public String toString() {
        return "{code: "+this.coder + ",msg: "+this.msg+"}";
    }
}