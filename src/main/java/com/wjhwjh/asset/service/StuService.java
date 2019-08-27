package com.wjhwjh.asset.service;

import com.wjhwjh.asset.entity.Stu;

public interface StuService {
    Stu findStuById(Long id);

    void addOne(Stu stu);
}
