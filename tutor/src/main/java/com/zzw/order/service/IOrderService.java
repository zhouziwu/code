package com.zzw.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzw.order.entity.OrderEntity;

import java.util.Map;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
public interface IOrderService extends IService<OrderEntity> {

    /**
     * 发布信息上传
     * @param user 用户名
     * @param name 联系姓名
     * @param tel 联系电话
     * @param qq qq
     * @param gender 性别
     * @param city 城市
     * @param address 住址
     * @param grade 年级
     * @param subject 辅导科目
     * @param times 每周辅导次数
     * @param number 每次辅导时长
     * @param stuInformation 学员情况
     * @param pay 支付报酬
     * @return String
     */
    String saveOrder (String user, String name, String tel, String qq, String gender,
                  String city, String address, String grade, String subject, Integer times,
                  Double number, String stuInformation, String pay);

    Map<String, Object> getOrderByPage (long page, long limit);

    String getState (String id);

    String setState (String id);
}