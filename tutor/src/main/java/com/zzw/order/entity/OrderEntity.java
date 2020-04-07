package com.zzw.order.entity;

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
@TableName("tutor_order")
@EqualsAndHashCode(callSuper = false)
public class OrderEntity extends Model<OrderEntity> {

    private static final long serialVersionUID = 1L;

    /**
     *主键
     */
    @TableId("id")
    private String id;

    /**
     *all_user外键，长度10
     */
    @TableId("all_user_username")
    private String allUserUsername;

    /**
     *联系人姓名，长度10
     */
    @TableField("name")
    private String name;

    /**
     *联系电话 11
     */
    @TableField("tel")
    private String tel;

    /**
     *qq 11
     */
    @TableField("qq")
    private String qq;

    /**
     *性别 2
     */
    @TableField("gender")
    private String gender;

    /**
     *城市 10
     */
    @TableField("city")
    private String city;

    /**
     *当前住所 50
     */
    @TableField("address")
    private String address;

    /**
     *年级 3
     */
    @TableField("grade")
    private String grade;

    /**
     *辅导科目 3
     */
    @TableField("subject")
    private String subject;

    /**
     *每周辅导次数 3
     */
    @TableField("times")
    private Integer times;

    /**
     *每次辅导时长 3
     */
    @TableField("number")
    private Double number;

    /**
     *学员情况 400
     */
    @TableField("stu_information")
    private String stuInformation;

    /**
     *支付报酬 5
     */
    @TableField("pay")
    private String pay;

    /**
     *状态 三种状态：“未完成”，“已受理”，“已完成”
     */
    @TableField("state")
    private String state;
}