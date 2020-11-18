package com.tencent.service.impl;

import com.tencent.dao.HelloMapper;
import com.tencent.datasource_config.DynamicDatasource;
import com.tencent.entity.Student;
import com.tencent.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@Service
@ControllerAdvice(basePackages = "com.tencent.controller")
public class HelloServiceImpl implements IHelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Override
    public List<Student> queryAllStudent() {
        return helloMapper.selectList(null);
    }

    @Override
    public Student queryById(Integer id) {
        return helloMapper.selectById(id);
    }

    @Override
    public Integer insertStu(Student student) {
        return helloMapper.insert(student);
    }

    @Override
    public Integer updateById(Student student) {
        return helloMapper.updateById(student);
    }

    @Override
    public Integer deleteById(Integer id) {
        return helloMapper.deleteById(id);
    }

    @Override
    public List<Student> query() {
        return helloMapper.query();
    }

    /**
     * 分库分表的测试
     * @param student
     * @return
     */
    @Override
    public int dbInsert(Student student) {
        int stuId = student.getId();
        //确定库
        int dbIndex = stuId % 2 + 1;
        DynamicDatasource.setLocal("studb" + dbIndex);
        System.out.println("定位到库：" + dbIndex);

        //确定表
        int tableIndex = stuId / 2 % 2 +1;
        System.out.println("定位到表：" + tableIndex);

        helloMapper.dbInsert(student,tableIndex);


        return 1;
    }

}
