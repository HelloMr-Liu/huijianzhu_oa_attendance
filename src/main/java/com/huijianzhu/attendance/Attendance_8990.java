package com.huijianzhu.attendance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;


/**
 * 描述：考勤启动类
 * @author 刘梓江
 * @date   2020/5/21 11:18
 */
@SuppressWarnings("all")
@SpringBootApplication
@MapperScan({"com.huijianzhu.attendance.mapper"})
public class Attendance_8990 {

    public static void main(String[] args) {
        SpringApplication.run(Attendance_8990.class);
    }

    @Bean
    //由于 @PropertySource 不支持yml文件的对象转换 默认支持properties
    //所以手动配置自定义 yml文件
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new
                PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("databaseConfig.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }
}
