package com.example.clocksystem.dao;

import com.example.clocksystem.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface DepartmentMapper {

    int insertDepartment(Department department);

    int updateDepartment(Department department);

    Department getDepartmentById(long id);

    List<Department> listDepartments();

    int deleteDepartmentById(long id);
}
