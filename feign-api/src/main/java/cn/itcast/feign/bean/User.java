package cn.itcast.feign.bean;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String address;
}