package com.example.demo.util.jwt;

import com.example.demo.annotation.Value;

public class JWTConst {

    @Value("JWTCode")
    public static final class Code {
        @Value("success")
        public static final int SUCCESS = 200;
        @Value("timeout")
        public static final int TIMEOUT = 201;
        @Value("error")
        public static final int ERROR = 299;
    }

}
