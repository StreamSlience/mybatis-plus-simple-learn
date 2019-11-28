package com.streamslience.simples.page.mpslpage.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApiModel("统一返回结果BO")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 109447904817524981L;
    @ApiModelProperty("查询结果")
    private T datas;
    @ApiModelProperty("状态码")
    private String code = ApiResponseCode.SUCCESS.get();
    @ApiModelProperty("接口信息")
    private String msg;
    @ApiModelProperty("服务请求时间")
    private String serverTime;
    @ApiModelProperty(value = "接口状态；成功:success;失败:failed。该属性已废弃，都会返回success。")
    @Deprecated
    private String flag = "success";

    public String getFlag() {
        return flag;
    }

    public String getServerTime() {
        return this.serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }


    public Result() {
        super();
        setServerTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public Result(ApiResponseCode code) {
        this(code.get(), code.getName());
    }

    public Result(String code, String message) {
        this(code, message, null);
        setServerTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public Result(ApiResponseCode code, T data) {
        this(code.get(), code.getName(), data);
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.msg = message;
        this.datas = data;
        setServerTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public static <T> Result<T> createSuccess() {
        return createSuccess(null);
    }

    public static <T> Result<T> createSuccess(T t) {
        return createSuccess(null, t);
    }

    public static <T> Result<T> createSuccess(String msg, T t) {
        return new Result<T>(ApiResponseCode.SUCCESS.get(), msg, t);
    }

    public static <T> Result<T> createUnknowFail(String code, String msg) {
        return new Result<T>(code, msg);
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "datas=" + datas +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", serverTime='" + serverTime + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}