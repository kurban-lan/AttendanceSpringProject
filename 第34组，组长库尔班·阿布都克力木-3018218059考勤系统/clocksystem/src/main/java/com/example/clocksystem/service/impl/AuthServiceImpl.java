package com.example.clocksystem.service.impl;


import com.example.clocksystem.dao.UserMapper;
import com.example.clocksystem.pojo.User;
import com.example.clocksystem.service.AuthService;
import com.example.clocksystem.utils.EncryptUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String password, HttpServletResponse response) throws Exception {
        User user = userMapper.getUserByEmail(username);
        if (user != null) {
            if (EncryptUtil.getMD5(password).equals(user.getPassword())) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", user.getId());
                jsonObject.put("username", user.getEmail());
                jsonObject.put("password", user.getPassword());
                jsonObject.put("roleId", user.getRoleId());
                jsonObject.put("timestamp", System.currentTimeMillis() / 1000);
                EncryptUtil encryptUtil = new EncryptUtil("token");
                Cookie cookie = new Cookie("token", encryptUtil.encrypt(jsonObject.toString()));
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 2);
                response.addCookie(cookie);
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
    }

    @Override
    public User checkAuth(HttpServletRequest request) throws Exception {
        User user = new User();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    if (token != null && !"".equals(token)) {
                        EncryptUtil encryptUtil = new EncryptUtil("token");
                        String str = encryptUtil.decrypt(token);
                        JSONObject jsonObject = new JSONObject(str);
                        user.setId(jsonObject.getLong("id"));
                        user.setEmail(jsonObject.getString("username"));
                        user.setPassword(jsonObject.getString("password"));
                        user.setRoleId(jsonObject.getLong("roleId"));
                        return user;
                    }
                }
            }
        }
        return null;
    }

}
