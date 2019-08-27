package com.wjhwjh.asset.service.impl;

import com.wjhwjh.asset.entity.Stu;
import com.wjhwjh.asset.repository.StuRepository;
import com.wjhwjh.asset.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    StuRepository stuRepository;

    @Override
    public void addOne(Stu stu) {
        stuRepository.save(stu);
    }

    @Override
    public Stu findStuById(Long id) {
        return stuRepository.getOne(id);
    }
}
