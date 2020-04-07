package com.zzw.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzw.order.dao.OrderDao;
import com.zzw.order.entity.OrderEntity;
import com.zzw.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * //功能描述： 添加类/接口功能描述
 *
 * @author 周梓武
 * @since 2020-02-07
 */
@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements IOrderService {
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
    @Override
    public String saveOrder(String user, String name, String tel, String qq, String gender,
                            String city, String address, String grade, String subject,
                            Integer times, Double number, String stuInformation, String pay) {
        OrderEntity entity = new OrderEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setAllUserUsername(user);
        entity.setName(name);
        entity.setTel(tel);
        entity.setQq(qq);
        entity.setGender(gender);
        entity.setCity(city);
        entity.setAddress(address);
        entity.setGrade(grade);
        entity.setSubject(subject);
        entity.setTimes(times);
        entity.setNumber(number);
        entity.setStuInformation(stuInformation);
        entity.setPay(pay);
        entity.setState("未完成");
        if (baseMapper.insert(entity) > 0) {
            return "success";
        } else {
            return "false";
        }
    }

    @Override
    public Map<String, Object> getOrderByPage(long page, long limit) {
        IPage<OrderEntity> iPage = baseMapper.selectPage(new Page<>(page, limit), new QueryWrapper<>());
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", iPage.getTotal());
        map.put("data", iPage.getRecords());
        return map;
    }

    @Override
    public String getState(String id) {
        OrderEntity entity = baseMapper.selectOne(new QueryWrapper<OrderEntity>().eq("id", id));
        return entity.getState();
    }

    @Override
    public String setState(String id) {
        OrderEntity entity = new OrderEntity();
        entity.setState("已受理");
        baseMapper.update(entity, new UpdateWrapper<OrderEntity>().eq("id", id));
        return "success";
    }
}