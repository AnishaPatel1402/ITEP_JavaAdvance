package com.info.SpringAnnotationConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.info.SpringAnnotationConfig.entity"})
public class AnnotationConfig {

}
