package com.linilq.dbconn.guava;

public class PushException extends RuntimeException {
    Throwable e;
    public PushException(String message,Throwable e){

        super(message,e);
        this.e = e;
    }
}
