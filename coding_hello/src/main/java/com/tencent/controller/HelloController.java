package com.tencent.controller;

import com.tencent.entity.Student;
import com.tencent.service.IHelloService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private IHelloService helloService;

//    /**
//     * 基本测试
//     * @return
//     */
//    @RequestMapping("/test")
//    @ResponseBody
//    public String test(){
//        return "hello,boy";
//    }

//    /**
//     * 查询所有学生
//     * @return
//     */
//    @RequestMapping("/queryAll")
//    public String queryStudent(Model model){
//        List<Student> studentList = helloService.queryAllStudent();
//        model.addAttribute("studentList",studentList);
//        return "list";
//    }

    /**
     * 根据id查询学生信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询单个student对象",notes = "学生id")
    @ApiImplicitParam(name = "id", value = "学生id", defaultValue = "1", required = true)
    @GetMapping("/getById")
    @ResponseBody
    public Student queryById(Integer id){
        Student student = helloService.queryById(id);
        System.out.println("查询到学生为："+ student);
        return student;
    }

    /**
     * 查询所有学生信息
     * @return
     */
    @ApiOperation(value = "查询所有的学生信息")
    @GetMapping("/queryAll")
    @ResponseBody
    public List<Student> queryAll(){
        return helloService.queryAllStudent();
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @ApiOperation(value = "添加学生")
    @ApiImplicitParam(name = "student", value = "学生实体类Student", required = true, paramType = "body", dataType = "Student")
    @PostMapping("/insert")
    @ResponseBody
    public Integer insert(@RequestBody Student student){
        return helloService.insertStu(student);
    }

    /**
     * 根据id修改学生信息
     * @param student
     * @return
     */
    @ApiOperation(value = "根据id修改学生")
    @ApiImplicitParam(name = "student", value = "学生实体类Student", required = true, paramType = "body", dataType = "Student")
    @PutMapping("/update")
    @ResponseBody
    public Integer update(@RequestBody Student student){
        return helloService.updateById(student);
    }

    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除学生")
    @ApiImplicitParam(name = "id",value = "学生id",required = true)
    @ResponseBody
    @DeleteMapping("/delete")
    public Integer deleteStu(Integer id){
        return helloService.deleteById(id);
    }

    /**
     * 分库同表的测试
     * @return
     */
    @RequestMapping("/dbTest1")
    @ResponseBody
    public List<Student> dbTest1(){
        return helloService.query();
    }

    /**
     * 分库分表的测试
     * @param student
     * @return
     */
    @RequestMapping("/dbTest2")
    @ResponseBody
    public int dbTest2(Student student){
        int stuId = (int)(Math.random() * 100) + 1;
        student.setId(stuId);
        int result = helloService.dbInsert(student);
        return stuId;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            int stuId = (int)(Math.random() * 100) + 1;
            arr[i] = stuId;
        }
        System.out.println(Arrays.toString(arr));
    }

}