package com.blossom.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 项目的总入口
 * @author Blossom
 * @time 2017年3月2日 下午4:34:15
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApplicationContextMain {
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationContextMain.class, args);
	}

}
