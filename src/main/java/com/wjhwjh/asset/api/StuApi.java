package com.wjhwjh.asset.api;

import com.alibaba.fastjson.JSON;
import com.wjhwjh.asset.common.annotation.TestAnnotation;
import com.wjhwjh.asset.entity.Stu;
import com.wjhwjh.asset.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class StuApi {

    @Autowired
    StuService stuService;

    @TestAnnotation()
    @GetMapping(value = "")
    public String findStu() {
//        return stuService.findStuById(id);
        return JSON.toJSONString("阿松大");
    }

    @PostMapping(value = "", produces = "text/plain;charset=UTF-8")
    public String saveStu(@RequestBody Stu stu) {
        stuService.addOne(stu);
        return "添加成功";
    }
}
