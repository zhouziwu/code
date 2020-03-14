package com.zzw.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzw.loginAndRegister.entity.AllUserEntity;
import com.zzw.loginAndRegister.service.IAllUserService;
import com.zzw.teacher.dao.TeacherDao;
import com.zzw.teacher.entity.TeacherEntity;
import com.zzw.teacher.service.ITeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
@Service
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements ITeacherService {

    final IAllUserService iAllUserService;
    public TeacherServiceImpl(IAllUserService iAllUserService) {
        this.iAllUserService = iAllUserService;
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
    @Override
    public String modifyInformation(String user, String birth, String degree, String university,
                                    String major, String subject, String graduate, String tutorMode,
                                    String selfAssessment, String charge) {
        String allUserId = iAllUserService.getOne(new QueryWrapper<AllUserEntity>()
                .eq("username", user)).getId();
        if (allUserId == null) {
            return "false";
        }
        TeacherEntity entity = new TeacherEntity();
        entity.setBirth(birth);
        entity.setDegree(degree);
        entity.setUniversity(university);
        entity.setMajor(major);
        entity.setSubject(subject);
        entity.setGraduate(graduate);
        entity.setTutorMode(tutorMode);
        entity.setSelfAssessment(selfAssessment);
        entity.setCharge(charge);
        baseMapper.update(entity, new LambdaUpdateWrapper<TeacherEntity>()
                .eq(TeacherEntity::getAllUserId, allUserId));
        return "success";
    }

    @Override
    public TeacherEntity test() {
        return this.baseMapper.test();
    }
}
