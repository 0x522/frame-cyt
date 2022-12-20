package com.cyt.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private Result() {

    }

    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static Result ok() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        result.setSuccess(true);
        return result;
    }

    public static Result ok(Integer resultCode, String resultMessage) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        result.setSuccess(true);
        return result;
    }

    public static <T> Result ok(T data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultMessage.SUCCESS);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static <T> Result ok(T data, Integer resultCode, String resultMessage) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    //ERROR
    public static Result fail() {
        Result result = new Result();
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        result.setSuccess(false);
        return result;
    }

    public static Result fail(Integer resultCode, String resultMessage) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        result.setSuccess(false);
        return result;
    }

    public static <T> Result fail(T data) {
        Result result = new Result();
        result.setCode(ResultCode.ERROR);
        result.setMessage(ResultMessage.ERROR);
        result.setSuccess(false);
        result.setData(data);
        return result;
    }

    public static <T> Result fail(T data, Integer resultCode, String resultMessage) {
        Result result = new Result();
        result.setCode(resultCode);
        result.setMessage(resultMessage);
        result.setSuccess(false);
        result.setData(data);
        return result;
    }

}
