package com.imooc.service.impl;

import com.immoc.mapper.StuMapper;
import com.immoc.pojo.Stu;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Override
    public Stu getStuInfo(int id) {
        return null;
    }
}
