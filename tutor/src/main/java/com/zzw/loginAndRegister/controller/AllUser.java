package com.zzw.loginAndRegister.controller;

import com.zzw.loginAndRegister.service.IAllUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
@RestController
@RequestMapping("/user")
@Api("用户登录和注册管理")
@CrossOrigin
public class AllUser {
    /*构造函数注入*/
    private final IAllUserService iAllUserService;
    public AllUser(IAllUserService iAllUserService) {
        this.iAllUserService = iAllUserService;
    }

    /**
     * 登录验证
     * @param uname 用户名
     * @param upwd 用户登录密码
     * @return String
     * @author 周梓武
     * @date 2020/2/17 12:53
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public String login (String uname, String upwd) {
        return iAllUserService.login(uname, upwd);
    }

    /**
     * 学员注册
     * @param sname 用户名
     * @param spwd 用户密码
     * @param scity 所在城市
     * @param grade 所读年级
     * @param sgender 性别
     * @return String
     */
    @ApiOperation("学员注册（我是学生）")
    @GetMapping("/studentRegister")
    public String studentRegister (String sname, String spwd, String scity, String grade, String sgender) {
        return iAllUserService.studentRegister(sname, spwd, scity, grade, sgender);
    }

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
    @ApiOperation("教员注册（我是老师）")
    @GetMapping("/teacherRegister")
    public String registerTeacher (String tname, String tpwd, String tcity, String degree,
                                   String university, String graduate, String tgender) {
        return iAllUserService.teacherRegister(tname, tpwd, tcity, degree, university, graduate, tgender);
    }

    /**
     * 家长注册
     * @param pname 用户名
     * @param ppwd 用户密码
     * @param pcity 所在城市
     * @param pgender 性别
     * @return String
     */
    @ApiOperation("家长注册（我是家长）")
    @GetMapping("/parentRegister")
    public String parentTeacher (String pname, String ppwd, String pcity, String pgender) {
        return iAllUserService.parentRegister(pname, ppwd, pcity, pgender);
    }

    /**
     * 密保问题回答
     * @param qname 用户名
     * @param interest 我的兴趣
     * @param speciality 我的特长
     * @return String
     */
    @ApiOperation("密保问题回答")
    @GetMapping("/question")
    public String question (String qname, String interest, String speciality) {
        return iAllUserService.question(qname, interest, speciality);
    }

    /**
     * 修改密码
     * @param fname 用户名
     * @param fpwd 新密码
     * @return String
     */
    @ApiOperation("修改密码")
    @GetMapping("/modifyPwd")
    public String modifyPwd (String fname, String fpwd) {
        return iAllUserService.modifyPwd(fname, fpwd);
    }

    /**
     * 查询用户头像显示
     * @param username 用户名
     * @return 路径
     */
    @ApiOperation("查询头像路径显示")
    @GetMapping("/getImg")
    public String getImg (String username) {
        return iAllUserService.getImg(username);
    }

    /**
     * 上传新头像
     * @param username 用户名
     * @param file 新头像
     * @return 新头像路径
     */
    @ApiOperation("上传新图片")
    @PostMapping("/modifyImg")
    public Map<String, Object> modifyImg (String username, MultipartFile file) {
        return iAllUserService.modifyImg(username, file);
    }

    /**
     * 按用户名查询用户信息
     * @param username 用户名
     * @return 用户实体
     */
    @ApiOperation("按用户名查询用户信息")
    @GetMapping("/getUserByUsername")
    public Map<String, Map<String, Object>> getUser (String username) {
        return iAllUserService.getUser(username);
    }

    /**
     * 用户信息修改
     * @param user 用户名
     * @return String
     * user: $("#user").val(),
     * 						address: $("#address").val(),
     * 						qq: $("#qq").val(),
     * 						tel: $("#tel").val(),
     * 						gender: $("#gender").val(),
     * 						city: $("#city").val(),
     * 						interest: $("#interest").val(),
     * 						speciality: $("#speciality").val(),
     */
    @ApiOperation("用户信息修改")
    @GetMapping("/modifyInformation")
    public String modifyInformation (String user, String address, String qq, String tel, String gender,
                                     String city, String interest, String speciality) {
        return iAllUserService.modifyInformation(user, address, qq, tel, gender, city
                , interest, speciality);
    }
}
