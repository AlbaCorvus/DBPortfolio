package com.cjmulcahy.config;

import com.cjmulcahy.dao.ReadDBSchema;
import com.cjmulcahy.dao.ReadDBSchemaImpl;
import com.cjmulcahy.service.ReadDBService;
import com.cjmulcahy.service.ReadDBServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@EnableWebMvc
@Configuration
@ComponentScan({"com.cjmulcahy.web"})
public class AppData extends WebMvcConfigurerAdapter{

   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
      registry.addResourceHandler("resources/**").addResourceLocations("/resources/");

   }

   @Bean
   public ReadDBServiceImpl dbService(){

       return new ReadDBServiceImpl(readDB());

   }




   @Bean
   public ReadDBSchema readDB(){
       return new ReadDBSchemaImpl();
   }


    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }







}