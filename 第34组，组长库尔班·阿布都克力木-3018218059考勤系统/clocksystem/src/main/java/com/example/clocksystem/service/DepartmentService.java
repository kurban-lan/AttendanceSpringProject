package com.example.clocksystem.service;



import com.example.clocksystem.pojo.Department;

import java.util.List;


public interface DepartmentService {

    Department getDepartmentById(long id);

    List<Department> listDepartments();

    void insertDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartmentById(long id);
}
