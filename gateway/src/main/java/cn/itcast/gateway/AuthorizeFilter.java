package cn.itcast.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(1)
public class AuthorizeFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求
        ServerHttpRequest request = exchange.getRequest();
        //2.获取参数
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        //3.判断
        String authorization = queryParams.getFirst("Authorization");
        //4.判断参数值是否符合判断规则
        if ("admin".equals(authorization)) {
            //5.符合，放行
            return chain.filter(exchange);
        }
        //6.不符合，设置状态码,再结束方法
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }
}
