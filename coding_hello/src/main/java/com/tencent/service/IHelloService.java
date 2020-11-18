package com.tencent.service;

import com.tencent.entity.Student;

import java.util.List;

public interface IHelloService {
    List<Student> queryAllStudent();

    Student queryById(Integer id);

    Integer insertStu(Student student);

    Integer updateById(Student student);

    Integer deleteById(Integer id);

    List<Student> query();

    int dbInsert(Student student);
}
