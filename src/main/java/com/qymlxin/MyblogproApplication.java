package com.qymlxin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//使用@repository注解时需要配置扫描路径
//@MapperScan("com.qymlxin.mapper")
public class MyblogproApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyblogproApplication.class, args);
    }

}