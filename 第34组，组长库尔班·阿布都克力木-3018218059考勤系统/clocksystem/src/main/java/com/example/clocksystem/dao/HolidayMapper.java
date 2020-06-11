package com.example.clocksystem.dao;

import com.example.clocksystem.pojo.Holiday;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface HolidayMapper {

    List<Holiday> listHolidays();

    Holiday getHolidayById(long id);

    int insertHoliday(Holiday holiday);

    int deleteHolidayById(long id);
}
