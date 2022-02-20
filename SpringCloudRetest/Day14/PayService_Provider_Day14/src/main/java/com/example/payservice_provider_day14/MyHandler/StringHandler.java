package com.example.payservice_provider_day14.MyHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class StringHandler {
    public static String s(BlockException blockException){
        return "string back";
    }
}
