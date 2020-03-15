package com.zzw.teacher.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
@Data
@TableName("teacher")
@EqualsAndHashCode(callSuper = false)
public class TeacherEntity extends Model<TeacherEntity> {

    private static final long serialVersionUID = 1L;

    /**
     *主键
     */
    @TableId("id")
    private String id;

    /**
     *all_user的外键
     */
    @TableId("all_user_id")
    private String allUserId;

    /**
     *出生年月，长度10
     */
    @TableField("birth")
    private String birth;

    /**
     *学位，长度4
     */
    @TableField("degree")
    private String degree;

    /**
     *就读最高学历所在大学，长度20
     */
    @TableField("university")
    private String university;

    /**
     *所读专业，长度20
     */
    @TableField("major")
    private String major;

    /**
     *所教科目，长度20
     */
    @TableField("subject")
    private String subject;

    /**
     *是否毕业，1为是，0为否
     */
    @TableField("graduate")
    private String graduate;

    /**
     *教授方式，长度10
     */
    @TableField("tutor_mode")
    private String tutorMode;

    /**
     *信誉分，长度3，百分制
     */
    @TableField("credit_score")
    private Integer creditScore;

    /**
     *自我评价，长度200
     */
    @TableField("self_assessment")
    private String selfAssessment;

    /**
     *教学优秀案例，长度400
     */
    @TableField("cases")
    private String cases;

    /**
     *收费标准，长度20
     */
    @TableField("charge")
    private String charge;

    /**
     * 下列属性均为all_user表中属性
     */
    @TableField(exist = false)
    private String trueName;

    @TableField(exist = false)
    private String number;

    @TableField(exist = false)
    private String certification;

    @TableField(exist = false)
    private String qq;

    @TableField(exist = false)
    private String tel;

    @TableField(exist = false)
    private String city;

    @TableField(exist = false)
    private String gender;
}
