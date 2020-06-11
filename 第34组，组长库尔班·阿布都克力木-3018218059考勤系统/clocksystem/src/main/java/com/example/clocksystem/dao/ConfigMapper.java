package com.example.clocksystem.dao;


import com.example.clocksystem.pojo.Config;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ConfigMapper {

    Config getConfig();

    int deleteConfig();

    int insertConfig(Config config);
}
