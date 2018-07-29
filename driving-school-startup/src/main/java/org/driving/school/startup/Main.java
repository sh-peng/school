package org.driving.school.startup;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value="org.driving")
@MapperScan("org.driving.school.dal.mapper")
public class Main {
	public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
