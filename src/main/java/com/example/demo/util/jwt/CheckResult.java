package com.example.demo.util.jwt;

import io.jsonwebtoken.Claims;

class CheckResult {
    private Claims body;
    private Integer code;
    private String checkMsg;

    public void success(Claims body) {
        this.body = body;

    }

}