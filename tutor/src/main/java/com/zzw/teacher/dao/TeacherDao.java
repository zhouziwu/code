package com.zzw.teacher.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzw.teacher.entity.TeacherEntity;
import org.apache.ibatis.annotations.Param;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
public interface TeacherDao extends BaseMapper<TeacherEntity> {

    IPage<TeacherEntity> getTeacherByPage(Page<TeacherEntity> page, @Param("subject") String subject,
                                          @Param("gender") String gender, @Param("degree") String degree,
                                          @Param("graduate") String graduate);

    IPage<TeacherEntity> getGoodTeacher(Page<TeacherEntity> page);
}
