package com.misaka.Domain;

public class ReturnJsON {
//    JSON类
    public int code;

    public ReturnJsON(int code, String detail) {
        this.code = code;
        Detail = detail;
    }

    public ReturnJsON() {
    }

    public String Detail;

}
