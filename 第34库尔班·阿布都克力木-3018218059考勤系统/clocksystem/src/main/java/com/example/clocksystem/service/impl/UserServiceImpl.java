package com.example.clocksystem.service.impl;


import com.example.clocksystem.dao.UserMapper;
import com.example.clocksystem.pojo.User;
import com.example.clocksystem.service.UserService;
import com.example.clocksystem.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public long countUserByDepartmentId(long id) {
        return userMapper.countUserByDepartmentId(id);
    }

    @Override
    public User getUserById(long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @Override
    public List<User> listUsersByDepartmentId(long departmentId) {
        return userMapper.listUsersByDepartmentId(departmentId);
    }

    @Override
    public List<String> listUserNamesByRoleIdAndDepartmentId(long roleId, long departmentId) {
        return userMapper.listUserNamesByRoleIdAndDepartmentId(roleId, departmentId);
    }

    @Override
    public void insertUser(User user) throws Exception {
        if (user.getPassword() != null) {
            user.setPassword(EncryptUtil.getMD5(user.getPassword()));
        }
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        if (user.getPassword() != null) {
            user.setPassword(EncryptUtil.getMD5(user.getPassword()));
        }
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userMapper.deleteUserById(id);
    }
}
