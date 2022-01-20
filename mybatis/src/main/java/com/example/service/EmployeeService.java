package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.EmployeeMapper;
import com.example.dao.UserMapper;
import com.example.entity.Employee;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: xijie
 * @description: 雇员
 * @dte: 2022/1/19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {
    /**
     * mybatis
     */
    @Autowired
    private EmployeeMapper mapper;
    /**
     * mybatis-plus
     */
    @Autowired
    private UserMapper userMapper;

    public Employee queryEmp(String id){
        return mapper.selectByPrimaryKey(id);
    }

    public User queryUser(String id){
        return userMapper.selectById(id);
    }

    /**
     * 条件构造器
     * @return
     */
    public List<User> queryUserIsNot1(){
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.ne(User::getId,1);
        userLambdaQueryWrapper.orderBy(true,true,User::getAge);
        return userMapper.selectList(userLambdaQueryWrapper);
    }

    public List<User> queryPage(Integer start,Integer limit){
        Page<User> page = new Page<>();
        page.setCurrent(start);
        page.setSize(limit);
        return userMapper.selectPage(page).getRecords();
    }
}
