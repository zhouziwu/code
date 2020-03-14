package com.zzw.student.controller;

import com.zzw.student.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：TODO
 *
 * @author by 周梓武
 * @package com.zzw.student.controller
 * @since 2020/2/28
 */
@RestController
@RequestMapping("/student")
@Api("用户基础信息管理")
@CrossOrigin
public class Student {

    final IStudentService iStudentService;
    public Student(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    /**
     * 修改老师的信息
     * @param user 用户名
     * @param grade 年级
     * @return String
     */
    @ApiOperation("修改老师的信息")
    @GetMapping("/modifyInformation")
    public String modifyInformation (String user, String grade) {
        return iStudentService.modifyInformation(user, grade);
    }
}
