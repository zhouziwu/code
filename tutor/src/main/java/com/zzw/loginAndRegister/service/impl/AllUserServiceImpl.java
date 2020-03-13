package com.zzw.loginAndRegister.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzw.loginAndRegister.dao.AllUserDao;
import com.zzw.loginAndRegister.entity.AllUserEntity;
import com.zzw.loginAndRegister.service.IAllUserService;
import com.zzw.parent.entity.ParentEntity;
import com.zzw.parent.service.IParentService;
import com.zzw.student.entity.StudentEntity;
import com.zzw.student.service.IStudentService;
import com.zzw.teacher.entity.TeacherEntity;
import com.zzw.teacher.service.ITeacherService;
import com.zzw.utils.MD5Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
@Service
@Transactional
public class AllUserServiceImpl extends ServiceImpl<AllUserDao, AllUserEntity> implements IAllUserService {

    private final IStudentService iStudentService;
    private final ITeacherService iTeacherService;
    private final IParentService iParentService;

    public AllUserServiceImpl(IStudentService iStudentService, ITeacherService iTeacherService, IParentService iParentService) {
        this.iStudentService = iStudentService;
        this.iTeacherService = iTeacherService;
        this.iParentService = iParentService;
    }

    //设置用户编号的策略
    private static final Map<String, String> cityMap = new HashMap<>();

    static {
        cityMap.put("北京", "BJ");
        cityMap.put("上海", "SH");
        cityMap.put("广州", "GZ");
        cityMap.put("深圳", "SZ");
        cityMap.put("杭州", "HZ");
        cityMap.put("天津", "TJ");
    }

    /**
     * 登录验证
     *
     * @param uname 用户名
     * @param upwd  用户登录密码
     * @return String
     * @author 周梓武
     * @date 2020/2/17 12:53
     */
    @Override
    public String login(String uname, String upwd) {
        AllUserEntity entity = new LambdaQueryChainWrapper<>(baseMapper)
                .select(AllUserEntity::getPassword).eq(AllUserEntity::getUsername, uname).one();
        if (entity != null && Objects.equals(MD5Tools.getMD5(upwd), entity.getPassword())) {
            return "success";
        } else {
            return "false";
        }
    }

    /**
     * 学员注册
     *
     * @param sname   用户名
     * @param spwd    用户密码
     * @param scity   所在城市
     * @param grade   所读年级
     * @param sgender 性别
     * @return String
     */
    @Override
    public String studentRegister(String sname, String spwd, String scity, String grade, String sgender) {
        if (new LambdaQueryChainWrapper<>(baseMapper).select(AllUserEntity::getUsername)
                .eq(AllUserEntity::getUsername, sname).one() == null) {
            //主键
            String id = UUID.randomUUID().toString();
            //用于生成number的注册学生总数
            int stuCount = iStudentService.count() + 1;
            //number编号，所在城市的首字母大写加第几个注册
            String number = cityMap.get(scity) + "S" + stuCount;
            //设置用户基础信息
            AllUserEntity stuUser = new AllUserEntity();
            stuUser.setId(id);
            stuUser.setNumber(number);
            stuUser.setUsername(sname);
            stuUser.setPassword(MD5Tools.getMD5(spwd));
            stuUser.setLevel("4");
            stuUser.setRegtime(new Date());
            stuUser.setLastLoginTime(new Date());
            stuUser.setCertification("0");
            stuUser.setCity(scity);
            stuUser.setGender(sgender);
            stuUser.setImg("img/lili.jpg");
            //设置学员信息
            StudentEntity stu = new StudentEntity();
            stu.setId(UUID.randomUUID().toString());
            stu.setAllUserId(id);
            stu.setGrade(grade);

            if ((this.baseMapper.insert(stuUser) == 1) && iStudentService.save(stu)) {
                return "success";
            } else {
                return "false";
            }
        } else {
            return "用户名已存在";
        }
    }

    /**
     * 老师注册
     *
     * @param tname      用户名
     * @param tpwd       密码
     * @param tcity      所在城市
     * @param degree     最高学位
     * @param university 所读学校
     * @param graduate   是否毕业
     * @param tgender    性别
     * @return String
     */
    @Override
    public String teacherRegister(String tname, String tpwd, String tcity, String degree,
                                  String university, String graduate, String tgender) {
        if (new LambdaQueryChainWrapper<>(baseMapper).select(AllUserEntity::getUsername)
                .eq(AllUserEntity::getUsername, tname).one() == null) {
            //主键
            String id = UUID.randomUUID().toString();
            //用于生成number的注册老师总数
            int teaCount = iTeacherService.count() + 1;
            //number编号，所在城市的首字母大写加第几个注册
            String number = cityMap.get(tcity) + "T" + teaCount;
            //设置用户基础信息
            AllUserEntity teaUser = new AllUserEntity();
            teaUser.setId(id);
            teaUser.setNumber(number);
            teaUser.setUsername(tname);
            teaUser.setPassword(MD5Tools.getMD5(tpwd));
            teaUser.setLevel("3");
            teaUser.setRegtime(new Date());
            teaUser.setLastLoginTime(new Date());
            teaUser.setCertification("0");
            teaUser.setCity(tcity);
            teaUser.setGender(tgender);
            teaUser.setImg("img/lili.jpg");
            //设置老师信息
            TeacherEntity tea = new TeacherEntity();
            tea.setId(UUID.randomUUID().toString());
            tea.setAllUserId(id);
            tea.setDegree(degree);
            tea.setUniversity(university);
            tea.setGraduate(graduate);
            tea.setCreditScore(100);

            if ((this.baseMapper.insert(teaUser) == 1) && iTeacherService.save(tea)) {
                return "success";
            } else {
                return "false";
            }
        } else {
            return "用户名已存在";
        }
    }

    /**
     * 家长注册
     *
     * @param pname   用户名
     * @param ppwd    用户密码
     * @param pcity   所在城市
     * @param pgender 性别
     * @return String
     */
    @Override
    public String parentRegister(String pname, String ppwd, String pcity, String pgender) {
        if (new LambdaQueryChainWrapper<>(baseMapper).select(AllUserEntity::getUsername)
                .eq(AllUserEntity::getUsername, pname).one() == null) {
            //主键
            String id = UUID.randomUUID().toString();
            //用于生成number的注册家长总数
            int stuCount = iParentService.count() + 1;
            //number编号，所在城市的首字母大写加第几个注册
            String number = cityMap.get(pcity) + "P" + stuCount;
            //设置用户基础信息
            AllUserEntity paUser = new AllUserEntity();
            paUser.setId(id);
            paUser.setNumber(number);
            paUser.setUsername(pname);
            paUser.setPassword(MD5Tools.getMD5(ppwd));
            paUser.setLevel("5");
            paUser.setRegtime(new Date());
            paUser.setLastLoginTime(new Date());
            paUser.setCertification("0");
            paUser.setCity(pcity);
            paUser.setGender(pgender);
            paUser.setImg("img/lili.jpg");
            //设置家长信息
            ParentEntity par = new ParentEntity();
            par.setId(UUID.randomUUID().toString());
            par.setAllUserId(id);

            if ((this.baseMapper.insert(paUser) == 1) && iParentService.save(par)) {
                return "success";
            } else {
                return "false";
            }
        } else {
            return "用户名已存在";
        }
    }

    /**
     * 密保问题回答
     *
     * @param qname      用户名
     * @param interest   我的兴趣
     * @param speciality 我的特长
     * @return String
     */
    @Override
    public String question(String qname, String interest, String speciality) {
        AllUserEntity entity = new LambdaQueryChainWrapper<>(baseMapper)
                .select(AllUserEntity::getInterest, AllUserEntity::getSpeciality)
                .eq(AllUserEntity::getUsername, qname).one();
        if (entity != null && interest.equals(entity.getInterest())
                && speciality.equals(entity.getSpeciality())) {
            return "success";
        } else if (entity == null) {
            return "用户名不存在";
        } else {
            return "false";
        }
    }

    /**
     * 修改密码
     *
     * @param fname 用户名
     * @param fpwd  新密码
     * @return String
     */
    @Override
    public String modifyPwd(String fname, String fpwd) {
        AllUserEntity entity = new LambdaQueryChainWrapper<>(baseMapper)
                .select(AllUserEntity::getPassword).eq(AllUserEntity::getUsername, fname).one();
        if (entity != null) {
            entity.setPassword(MD5Tools.getMD5(fpwd));
            baseMapper.update(entity, new UpdateWrapper<AllUserEntity>().eq("username", fname));
            return "success";
        } else {
            return "用户名不存在";
        }
    }

    /**
     * 查询用户头像显示
     *
     * @param username 用户名
     * @return 路径
     */
    @Override
    public String getImg(String username) {
        AllUserEntity entity = new LambdaQueryChainWrapper<>(baseMapper)
                .select(AllUserEntity::getImg).eq(AllUserEntity::getUsername, username).one();
        if (entity != null) {
            return entity.getImg();
        } else {
            return null;
        }
    }

    /**
     * 上传新头像
     * @param username 用户名
     * @param file 新头像
     * @return 新头像路径
     */
    @Override
    public Map<String, Object> modifyImg(String username, MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", false);
        map.put("data", null);
        AllUserEntity entity = new LambdaQueryChainWrapper<>(baseMapper)
                .select(AllUserEntity::getImg).eq(AllUserEntity::getUsername, username).one();
        if (entity == null) {
            return map;
        }
        //保存上传
        try {
            if (file == null) {
                return map;
            }
            String originalName = file.getOriginalFilename();
            if (originalName == null) {
                return map;
            }
            //获取上传图片的后缀名
            String suffixName = originalName.substring(originalName.lastIndexOf("."));
            //设置时间戳为图片名称，防止重名
            long date = System.currentTimeMillis();
            String filepath = "D:/codeRepository/graduationProject/code/tutorWeb/img/"
                    + date + suffixName;
            File files = new File(filepath);
            //创建文件夹及文件
            if (!files.getParentFile().exists()) {
                try {
                    files.getParentFile().mkdirs();
                    files.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //上传图片
            file.transferTo(files);
            //删除旧头像
            File oldImg = new File("D:/codeRepository/graduationProject/code/tutorWeb/"
                    + entity.getImg());
            if (oldImg.exists()) {
                oldImg.delete();
            }
            //保存新路径
            String newPath = "img/" + date + suffixName;
            entity.setImg(newPath);
            if (baseMapper.update(entity, new LambdaUpdateWrapper<AllUserEntity>()
                    .eq(AllUserEntity::getUsername, username)) > 0) {
                map.put("code", 200);
                map.put("msg", true);
                map.put("data", newPath);
                return map;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            return map;
        }
    }

    /**
     * 按用户名查询用户信息
     * @param username 用户名
     * @return 用户实体
     */
    @Override
    public Map<String, Map<String, Object>> getUser(String username) {
        Map<String, Map<String, Object>> majorMap = new HashMap<>();
        List<Map<String, Object>> allList = baseMapper.selectMaps(new QueryWrapper<AllUserEntity>()
                .eq("username", username));
        majorMap.put("all", allList.get(0));

        if ("3".equals(allList.get(0).get("level"))) {
            Map<String, Object> teaMap = iTeacherService.getMap(new QueryWrapper<TeacherEntity>()
                    .eq("all_user_id", allList.get(0).get("id")));
            majorMap.put("teacher", teaMap);
        }
        if ("4".equals(allList.get(0).get("level"))) {
            Map<String, Object> stuMap = iStudentService.getMap(new QueryWrapper<StudentEntity>()
                    .eq("all_user_id", allList.get(0).get("id")));
            majorMap.put("student", stuMap);
        }
        if ("5".equals(allList.get(0).get("level"))) {
            Map<String, Object> parMap = iParentService.getMap(new QueryWrapper<ParentEntity>()
                    .eq("all_user_id", allList.get(0).get("id")));
            majorMap.put("parent", parMap);
        }
        return majorMap;
    }

    /**
     * 用户信息修改
     * @param user 用户名
     * @return String
     */
    @Override
    public String modifyInformation(String user, String address, String qq, String tel, String gender,
                                    String city, String interest, String speciality) {
        AllUserEntity entity = new LambdaQueryChainWrapper<>(baseMapper)
                .eq(AllUserEntity::getUsername, user).one();
        if (entity == null) {
            return "false";
        }
        entity.setAddress(address);
        entity.setQq(qq);
        entity.setTel(tel);
        entity.setGender(gender);
        entity.setCity(city);
        entity.setInterest(interest);
        entity.setSpeciality(speciality);
        baseMapper.update(entity, new LambdaUpdateWrapper<AllUserEntity>().eq(AllUserEntity::getUsername, user));
        return "success";
    }

}