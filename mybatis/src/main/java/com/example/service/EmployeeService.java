package com.example.service;

import com.example.dao.EmployeeMapper;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: xijie
 * @description: 雇员
 * @dte: 2022/1/19
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    public Employee queryEmp(String id){
        return mapper.selectByPrimaryKey(id);
    }
}
