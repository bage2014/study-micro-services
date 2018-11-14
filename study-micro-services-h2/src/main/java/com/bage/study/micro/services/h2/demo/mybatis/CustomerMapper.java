package com.bage.study.micro.services.h2.demo.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bage.study.micro.services.h2.domain.Customer;

@Mapper
public interface CustomerMapper {

    @Select("SELECT id, first_name, last_name FROM customers WHERE id = #{id}")
    Customer queryById(String id);

}
