package com.example.clocksystem.service;



import com.example.clocksystem.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AuthService {

    boolean login(String username, String password, HttpServletResponse response) throws Exception;

    void logout(HttpServletRequest request,HttpServletResponse response);

    User checkAuth(HttpServletRequest request) throws Exception;
}
