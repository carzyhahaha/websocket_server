package com.example.demo.util.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    private static final String JWT_EXPIRE = "token过期";

    private static final String JWT_ERROR = "token不合法";

    private static final String SECRET = "THISISSECRET^201911182310BY^^SY!";

    private static final String ISSUSER = "SY";

    private static final Map<String, Object> JWT_HEADER = new HashMap<>();

    static {
        JWT_HEADER.put("type", "jwt");
    }

    public static String create(String payload) {
        return  Jwts.builder()
                .setHeader(JWT_HEADER)
                .setPayload(payload)
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

    public static CheckResult validate(String token)  {
        CheckResult checkResult = new CheckResult();

        return checkResult;
    }

    public static Claims parse(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }
}


