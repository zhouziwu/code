package com.zzw.teacher.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzw.teacher.entity.TeacherEntity;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
public interface TeacherDao extends BaseMapper<TeacherEntity> {
    public TeacherEntity test();
}
