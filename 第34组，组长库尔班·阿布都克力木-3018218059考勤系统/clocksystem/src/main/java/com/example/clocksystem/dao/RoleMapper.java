package com.example.clocksystem.dao;

import com.example.clocksystem.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RoleMapper {

    Role getRoleById(long id);

    List<Role> listRoles();
}
