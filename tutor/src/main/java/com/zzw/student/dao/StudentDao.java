package com.zzw.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzw.loginAndRegister.entity.AllUserEntity;
import com.zzw.student.entity.StudentEntity;

/**
 * 功能描述：TODO
 *
 * @author by 周梓武
 * @package com.zzw.student.dao
 * @since 2020/2/28
 */
public interface StudentDao extends BaseMapper<StudentEntity> {

    IPage<AllUserEntity> getStudentByPage(Page<AllUserEntity> page);

}
