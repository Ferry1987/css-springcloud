package com.css.model.user;

import java.io.Serializable;

public class CssResultVO<T> implements Serializable {
    private String code;
    private String message;
    private T data;
    public CssResultVO(T t){

    }
    public CssResultVO(){

    }
    public CssResultVO(T t, String code, String message){
        this.code = code;
        this.message = message;
        this.data = t;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public static CssResultVO success(Object t){
         return new CssResultVO(t,"00","操作成功！") ;
    }
}
