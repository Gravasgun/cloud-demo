package cn.itcast.order.service;

import cn.itcast.feign.bean.User;
import cn.itcast.feign.client.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.利用feign发送http请求
        User user = userClient.findById(order.getUserId());
        // 3.封装user对象到order对象中
        order.setUser(user);
        // 4.返回
        return order;
    }

//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        String url = "http://userservice/user/" + order.getUserId();
//        // 2.利用restTemplate发送http请求
//        User user = restTemplate.getForObject(url, User.class);
//        // 3.封装user对象到order对象中
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}
