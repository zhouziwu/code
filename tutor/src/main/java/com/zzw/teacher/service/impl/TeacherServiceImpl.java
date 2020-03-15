package com.zzw.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzw.loginAndRegister.entity.AllUserEntity;
import com.zzw.loginAndRegister.service.IAllUserService;
import com.zzw.teacher.dao.TeacherDao;
import com.zzw.teacher.entity.TeacherEntity;
import com.zzw.teacher.service.ITeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 查询老师信息分页
     * @param subject 科目
     * @param gender 性别
     * @param degree 学位
     * @param page 当前页
     * @param limit 每页多少条
     * @return map
     */
    @Override
    public Map<String, Object> getTeacherByPage(String subject, String gender, String degree,
                                                long page, long limit) {
        Page<TeacherEntity> pages = new Page<>(page, limit);
        String degree1, graduate;
        if (degree != null && degree != "") {
            degree1 = degree.substring(0, 2);
            String tem = degree.substring(2);
            if ("在读".equals(tem)) {
                graduate = "0";
            } else {
                graduate = "1";
            }
        } else {
            degree1 = "";
            graduate = "";
        }
        IPage<TeacherEntity> iPage = baseMapper.getTeacherByPage(pages, subject, gender, degree1, graduate);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    /**
     * 查询优质老师信息分页
     * @param page 当前页
     * @param limit 每页多少条
     * @return map
     */
    @Override
    public Map<String, Object> getGoodTeacher(long page, long limit) {
        Page<TeacherEntity> pages = new Page<>(page, limit);
        IPage<TeacherEntity> iPage = baseMapper.getGoodTeacher(pages);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

}
