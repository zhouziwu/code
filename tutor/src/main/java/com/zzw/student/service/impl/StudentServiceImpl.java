package com.zzw.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzw.loginAndRegister.entity.AllUserEntity;
import com.zzw.loginAndRegister.service.IAllUserService;
import com.zzw.student.dao.StudentDao;
import com.zzw.student.entity.StudentEntity;
import com.zzw.student.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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

    final IAllUserService iAllUserService;
    public StudentServiceImpl(IAllUserService iAllUserService) {
        this.iAllUserService = iAllUserService;
    }

    /**
     * 修改学员的信息
     * @param user 用户名
     * @param grade 年级
     * @return String
     */
    @Override
    public String modifyInformation(String user, String grade) {
        String allUserId = iAllUserService.getOne(new QueryWrapper<AllUserEntity>()
                .eq("username", user)).getId();
        if (allUserId == null) {
            return "false";
        }
        StudentEntity entity = new StudentEntity();
        entity.setGrade(grade);
        baseMapper.update(entity, new LambdaUpdateWrapper<StudentEntity>()
                .eq(StudentEntity::getAllUserId, allUserId));
        return "success";
    }

    /**
     * 查询学员信息分页
     * @param page 当前页
     * @param limit 每页多少条
     * @return map
     */
    @Override
    public Map<String, Object> getStudentByPage(long page, long limit) {
        Page<AllUserEntity> pages = new Page<>(page, limit);
        IPage<AllUserEntity> iPage = baseMapper.getStudentByPage(pages);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }
}
