package com.example.clocksystem.service;



import com.example.clocksystem.pojo.Role;

import java.util.List;


public interface RoleService {

    Role getRoleById(long id);

    List<Role> listRoles();
}
