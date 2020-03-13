package com.zzw.loginAndRegister.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzw.loginAndRegister.entity.AllUserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
public interface IAllUserService extends IService<AllUserEntity> {
    /**
     * 登录验证
     * @param uname 用户名
     * @param upwd 用户登录密码
     * @return String
     * @author 周梓武
     * @date 2020/2/17 12:53
     */
    String login(String uname, String upwd);

    /**
     * 学员注册
     * @param sname 用户名
     * @param spwd 用户密码
     * @param scity 所在城市
     * @param grade 所读年级
     * @param sgender 性别
     * @return String
     */
    String studentRegister (String sname, String spwd, String scity, String grade, String sgender);

    /**
     * 老师注册
     * @param tname 用户名
     * @param tpwd 密码
     * @param tcity 所在城市
     * @param degree 最高学位
     * @param university 所读学校
     * @param graduate 是否毕业
     * @param tgender 性别
     * @return String
     */
    String teacherRegister (String tname, String tpwd, String tcity, String degree,
                            String university, String graduate, String tgender);

    /**
     * 家长注册
     * @param pname 用户名
     * @param ppwd 用户密码
     * @param pcity 所在城市
     * @param pgender 性别
     * @return String
     */
    String parentRegister (String pname, String ppwd, String pcity, String pgender);

    /**
     * 密保问题回答
     * @param qname 用户名
     * @param interest 我的兴趣
     * @param speciality 我的特长
     * @return String
     */
    String question (String qname, String interest, String speciality);

    /**
     * 修改密码
     * @param fname 用户名
     * @param fpwd 新密码
     * @return String
     */
    String modifyPwd (String fname, String fpwd);

    /**
     * 查询用户头像显示
     * @param username 用户名
     * @return 路径
     */
    String getImg (String username);

    /**
     * 上传新头像
     * @param username 用户名
     * @param file 新头像
     * @return 新头像路径
     */
    Map<String, Object> modifyImg (String username, MultipartFile file);

    /**
     * 按用户名查询用户信息
     * @param username 用户名
     * @return 用户实体
     */
    Map<String, Map<String, Object>> getUser (String username);

    /**
     * 用户信息修改
     * @param user 用户名
     * @return String
     */
    String modifyInformation (String user, String address, String qq, String tel, String gender,
                              String city, String interest, String speciality);
}
