package com.zzw.order.controller;

import com.zzw.order.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
@RestController
@RequestMapping("/order")
@Api("家教订单管理")
@CrossOrigin
public class Order {
    @Autowired
    IOrderService iOrderService;

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
    @ApiOperation("发布信息")
    @GetMapping("/saveOrder")
    public String saveOrder (String user, String name, String tel, String qq, String gender,
                         String city, String address, String grade, String subject, Integer times,
                         Double number, String stuInformation, String pay) {
        return iOrderService.saveOrder(user, name, tel, qq, gender, city, address,
                grade, subject, times, number, stuInformation, pay);
    }

    @ApiOperation("发布信息")
    @GetMapping("/getOrderByPage")
    public Map<String, Object> getOrderByPage (long page, long limit) {
        return iOrderService.getOrderByPage(page, limit);
    }

    @ApiOperation("获取订单状态")
    @GetMapping("/getState")
    public String getState (String id) {
        return iOrderService.getState(id);
    }

    @ApiOperation("修改订单状态")
    @GetMapping("/setState")
    public String setState (String id) {
        return iOrderService.setState(id);
    }
}