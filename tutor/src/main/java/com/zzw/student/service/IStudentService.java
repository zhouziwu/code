package com.zzw.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzw.student.entity.StudentEntity;

/**
 * 功能描述：TODO
 *
 * @author by 周梓武
 * @package com.zzw.student.service
 * @since 2020/2/28
 */
public interface IStudentService extends IService<StudentEntity> {

    /**
     * 修改老师的信息
     * @param user 用户名
     * @param grade 年级
     * @return String
     */
    String modifyInformation (String user, String grade);
}
