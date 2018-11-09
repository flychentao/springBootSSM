package com.chen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chen.bean.User;

@Mapper
public interface UserMapper {
    
    public List<User> findAll();

}