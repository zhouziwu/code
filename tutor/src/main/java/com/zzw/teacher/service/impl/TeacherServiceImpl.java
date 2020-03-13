package com.zzw.teacher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public TeacherEntity test() {
        return this.baseMapper.test();
    }
}
