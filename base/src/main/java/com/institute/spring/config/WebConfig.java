package com.institute.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
  private static final String UI_PATH_PREFIX = "/WEB-INF/base/dist/base/";



/*  @Override public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.
  }*/

  @Bean
  public org.springframework.web.servlet.ViewResolver getViewResolver() {
    System.out.println("------------VIEW --------------");
    InternalResourceViewResolver internalResourceViewResolver= new InternalResourceViewResolver();
    internalResourceViewResolver.setSuffix(".html");
    internalResourceViewResolver.setPrefix(UI_PATH_PREFIX);
    return internalResourceViewResolver;
  }
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    System.out.println("----------------- Resource -------------------");
    registry.addResourceHandler("/**.html").addResourceLocations(UI_PATH_PREFIX);
    registry.addResourceHandler("/**.js").addResourceLocations(UI_PATH_PREFIX);
    registry.addResourceHandler("/static/**").addResourceLocations(UI_PATH_PREFIX);
    //registry.addResourceHandler("/**").addResourceLocations(UI_PATH_PREFIX);
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer handlerConfigurer) {
    System.out.println("----------------- Config -------------------");
    handlerConfigurer.enable();
  }

}
