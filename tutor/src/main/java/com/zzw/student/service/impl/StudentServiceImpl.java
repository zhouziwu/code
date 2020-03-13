package com.zzw.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzw.student.dao.StudentDao;
import com.zzw.student.entity.StudentEntity;
import com.zzw.student.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 功能描述：TODO
 *
 * @author by 周梓武
 * @package com.zzw.student.service.impl
 * @since 2020/2/28
 */
@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements IStudentService {
}
