package com.bage.study.micro.services.multi.datasources;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerMapper {

    @Select("SELECT id, first_name, last_name FROM customers WHERE id = #{id}")
    Customer queryById(String id);

    List<Customer> queryAll();

}