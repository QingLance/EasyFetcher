package com.easy.fetcher.biz;

/**
 * Created by guoqingliang on 2019/7/29.
 */

public class Response<T> {
    private String returnCode;
    private boolean success;
    private T data;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
