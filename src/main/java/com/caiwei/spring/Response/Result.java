package com.caiwei.spring.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private String code;
    private String message;
    private T data;

    public static <T> Result success(){
        Result<T> result = new Result<>("200","success",null);
        return result;
    }
    public static <T> Result success(T data){
        Result<T> result = new Result<>("200","success",data);
        return result;
    }
    public static <T> Result error(){
        Result<T> result = new Result<>("500","failure",null);
        return result;
    }
    public static <T> Result error(T data){
        Result<T> result = new Result<>("200","success",data);
        return result;
    }
}
