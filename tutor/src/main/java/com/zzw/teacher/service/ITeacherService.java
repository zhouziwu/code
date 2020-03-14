package com.zzw.teacher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzw.teacher.entity.TeacherEntity;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
public interface ITeacherService extends IService<TeacherEntity> {

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
    String modifyInformation (String user, String birth, String degree, String university,
                              String major, String subject, String graduate, String tutorMode,
                              String selfAssessment, String charge);

    TeacherEntity test();
}
