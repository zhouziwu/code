package com.zzw.teacher.controller;

import com.zzw.teacher.entity.TeacherEntity;
import com.zzw.teacher.service.ITeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    /**
     * 修改老师的信息
     * @param user 用户名
     * @param birth 出生年月
     * @param degree 最高学位
     * @param university 所读大学
     * @param major 主修专业
     * @param subject 授课科目
     * @param graduate 是否毕业
     * @param tutorMode 授课模式
     * @param selfAssessment 自我评价
     * @param charge 收费标准
     * @return String
     */
    @ApiOperation("用户信息修改")
    @GetMapping("/modifyInformation")
    public String modifyInformation (String user, String birth, String degree, String university,
                                     String major, String subject, String graduate, String tutorMode,
                                     String selfAssessment, String charge) {
        return iTeacherService.modifyInformation(user, birth, degree, university, major, subject,
                graduate, tutorMode, selfAssessment, charge);
    }

    /*测试*/
    @GetMapping("/test")
    public TeacherEntity test () {
        return iTeacherService.test();
    }
}
