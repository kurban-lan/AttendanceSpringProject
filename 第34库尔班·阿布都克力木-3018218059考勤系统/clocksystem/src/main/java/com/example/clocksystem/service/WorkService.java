package com.example.clocksystem.service;



import com.example.clocksystem.pojo.Config;
import com.example.clocksystem.pojo.Holiday;
import com.example.clocksystem.pojo.WorkCheck;

import java.util.List;

public interface WorkService {

    Holiday getHolidayById(long id);

    List<Holiday> listHolidays();

    void insertHoliday(Holiday holiday);

    void deleteHolidayById(long id);

    void insertConfig(Config config);

    Config getConfig();

    boolean insertWorkCheck(WorkCheck workCheck);

    boolean updateEndCheck(long userId);

    List<WorkCheck> listWorkChecksByUserId(long userId);

    List<WorkCheck> listWorkChecks();
}
