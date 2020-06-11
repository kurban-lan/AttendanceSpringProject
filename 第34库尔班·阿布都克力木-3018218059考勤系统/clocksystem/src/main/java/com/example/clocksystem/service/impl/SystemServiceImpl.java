package com.example.clocksystem.service.impl;

import com.example.clocksystem.dao.SystemMapper;
import com.example.clocksystem.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private SystemMapper systemMapper;

    @Override
    public void initialization() {
        systemMapper.initialization();
        //systemMapper.deleteDepartment();
        //systemMapper.deleteHoliday();
        systemMapper.deleteSchedule();
        systemMapper.deleteUser();
        systemMapper.deleteWorkCheck();

    }

    @Override
    public void backup() {

    }
}
