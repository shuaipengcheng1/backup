package com.day2.pro1.Domain;

import java.io.Serializable;

public class Payment implements Serializable {
    public String id;
    public String Detail;

    public Payment(String id, String detail) {
        this.id = id;
        Detail = detail;
    }

    public Payment() {
    }
}
