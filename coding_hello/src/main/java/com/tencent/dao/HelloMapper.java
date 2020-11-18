package com.tencent.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tencent.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HelloMapper extends BaseMapper<Student> {
    List<Student> query();

    void dbInsert(@Param("student") Student student,@Param("tableIndex") int tableIndex);
}
