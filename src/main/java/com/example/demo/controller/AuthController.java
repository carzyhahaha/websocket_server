package com.example.demo.controller;

import com.example.demo.component.TmpUserTable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public Object login(HttpServletRequest request, String username, String password) {
        String passwd = TmpUserTable.getUserInfo(username);

        if (password.equals(passwd)) {
            request.getSession().setAttribute("username", username);
        } else {

        }
        Map<String, String> rs = new LinkedHashMap<>();
        rs.put("code", "200");
        return rs;
    }
}
