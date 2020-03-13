package com.zzw.teacher.controller;

import com.zzw.teacher.entity.TeacherEntity;
import com.zzw.teacher.service.ITeacherService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
@RestController
@RequestMapping("/teacher")
@Api("用户基础信息管理")
@CrossOrigin
public class Teacher {
    /*构造函数注入*/
    private final ITeacherService iTeacherService;
    public Teacher(ITeacherService iTeacherService) {
        this.iTeacherService = iTeacherService;
    }

    /*测试*/
    @GetMapping("/test")
    public TeacherEntity test () {
        return iTeacherService.test();
    }
}
