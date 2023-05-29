package com.skytech.e_store.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class CustomException extends  Exception{
    public  CustomException (String msg){
        super(msg);
    }
}
