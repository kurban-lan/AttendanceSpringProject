package com.example.clocksystem.service.impl;

import com.example.clocksystem.dao.RoleMapper;
import com.example.clocksystem.pojo.Role;
import com.example.clocksystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleById(long id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public List<Role> listRoles() {
        return roleMapper.listRoles();
    }
}
