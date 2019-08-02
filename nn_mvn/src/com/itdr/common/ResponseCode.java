package com.itdr.common;

public class ResponseCode<T> {
    private Integer Status;
    private T data;
    private String mag;

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "Status=" + Status +
                ", data=" + data +
                ", mag='" + mag + '\'' +
                '}';
    }
    //成功的时候只要返回状态码和成功获取的数据就可以了
    //失败的时候只要返回状态码和失败的信息就可以了
}
