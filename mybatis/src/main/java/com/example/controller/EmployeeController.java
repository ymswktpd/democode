package com.example.controller;

import com.example.entity.Employee;
import com.example.entity.User;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xijie
 * @description:
 * @dte: 2022/1/19
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public Employee queryEmp(@RequestParam String id){
        return service.queryEmp(id);
    }
    @GetMapping("/user")
    public User queryUser(@RequestParam String id){
        return service.queryUser(id);
    }
    @GetMapping("/queryUserIsNot1")
    public List<User> queryUserIsNot1(){
        return service.queryUserIsNot1();
    }
    @GetMapping("/queryPage")
    public List<User> queryPage(@RequestParam Integer start,Integer limit){
        return service.queryPage(start,limit);
    }
}
