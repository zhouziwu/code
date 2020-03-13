package com.zzw.loginAndRegister.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
@Data
@TableName("all_user")
@EqualsAndHashCode(callSuper = false)
public class AllUserEntity extends Model<AllUserEntity> {

    private static final long serialVersionUID = 1L;

    /**
     *主键
     */
    @TableId("id")
    private String id;

    /**
     *用户编号
     */
    @TableId("number")
    private String number;

    /**
     *真实姓名，长度10
     */
    @TableField("true_name")
    private String trueName;

    /**
     *用户名，长度10
     */
    @TableField("username")
    private String username;

    /**
     *用户密码，6到16位
     */
    @TableField("password")
    private String password;

    /**
     *用户级别，1为超级管理员，2为管理员，3为老师，4为学生，5为家长
     */
    @TableField("level")
    private String level;

    /**
     *身份证，18位
     */
    @TableField("id_card")
    private String idCard;

    /**
     *注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT + 8")
    @TableField("regtime")
    private Date regtime;

    /**
     *最后一次登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT + 8")
    @TableField("last_login_time")
    private Date lastLoginTime;

    /**
     *是否实名，1为是，2为否
     */
    @TableField("certification")
    private String certification;

    /**
     *qq
     */
    @TableField("qq")
    private String qq;

    /**
     *联系电话
     */
    @TableField("tel")
    private String tel;

    /**
     *所在城市
     */
    @TableField("city")
    private String city;

    /**
     *性别
     */
    @TableField("gender")
    private String gender;

    /**
     *当前住所
     */
    @TableField("address")
    private String address;

    /**
     * 我的兴趣
     */
    @TableField("security_question_interest")
    private String interest;

    /**
     * 我的特长
     */
    @TableField("security_question_speciality")
    private String speciality;

    /**
     * 头像存储路径
     */
    @TableField("img")
    private String img;
}
