package com.example.clocksystem.service.impl;

import com.example.clocksystem.dao.DepartmentMapper;
import com.example.clocksystem.pojo.Department;
import com.example.clocksystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartmentById(long id) {
        return departmentMapper.getDepartmentById(id);
    }

    @Override
    public List<Department> listDepartments() {
        return departmentMapper.listDepartments();
    }

    @Override
    public void insertDepartment(Department department) {
        if (department != null) {
            departmentMapper.insertDepartment(department);
        }
    }

    @Override
    public void updateDepartment(Department department) {
        if (department != null) {
            departmentMapper.updateDepartment(department);
        }
    }

    @Override
    public void deleteDepartmentById(long id) {
        departmentMapper.deleteDepartmentById(id);
    }
}
