package com.misaka.Domain;

import java.io.Serializable;

public class Pay implements Serializable {
    public String id;
    public String Detail;

    public Pay(String id, String detail) {
        this.id = id;
        Detail = detail;
    }

    public Pay() {
    }


}
