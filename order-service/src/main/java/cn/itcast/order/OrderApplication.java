package cn.itcast.order;

import cn.itcast.feign.client.UserClient;
import cn.itcast.feign.config.FeignClientConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
@EnableFeignClients(clients = UserClient.class, defaultConfiguration = FeignClientConfiguration.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

//    /**
//     * 创建RestTemplate对象并注入Spring容器
//     *
//     * @return
//     */
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

//    /**
//     * 修改负载均衡规则
//     *
//     * @return
//     */
//    @Bean
//    public IRule randomRule() {
//        return new RandomRule();
//    }
}