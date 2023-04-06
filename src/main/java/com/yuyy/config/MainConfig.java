package com.yuyy.config;

import com.yuyy.Dao.BookDao;
import com.yuyy.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author Ther
 * @date 2023/3/22 20:04
 */

@Configuration
//@ComponentScan(basePackages = "com.yuyy")
//@ComponentScan(basePackages = "com.yuyy",excludeFilters = {@ComponentScan.Filter(classes = {Controller.class})})
@ComponentScan(basePackages = "com.yuyy",
        includeFilters = {
        /*@ComponentScan.Filter(classes = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookDao.class}),*/
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        },
        useDefaultFilters = false)
public class MainConfig {
    /**
     * beanname 默认是方法名 如果注解上加了属性，则是注解属性值
     * @return
     */
    @Bean
//    @Scope("prototype")
    public Person Person() {
        return new Person("tom",26);
    }
}
