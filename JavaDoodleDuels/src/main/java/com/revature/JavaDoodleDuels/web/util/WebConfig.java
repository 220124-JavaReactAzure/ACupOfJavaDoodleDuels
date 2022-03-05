package com.revature.JavaDoodleDuels.web.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.result.view.UrlBasedViewResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//@EnableWebMvc
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//   @Override
//   public void addViewControllers(ViewControllerRegistry registry) {
//      registry.addViewController("/fightDummy").setViewName("fightDummy");
//   }
//
//   @Bean
//   public ViewResolver viewResolver() {
//      InternalResourceViewResolver bean = new InternalResourceViewResolver();
//
//      bean.setViewClass(JstlView.class);
//      bean.setPrefix("src/main/webapp");
//      bean.setSuffix(".jsp");
//
//      return bean;
//   }
//}
