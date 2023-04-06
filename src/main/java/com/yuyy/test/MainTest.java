package com.yuyy.test;

import com.yuyy.bean.Person;
import com.yuyy.config.MainConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Ther
 * @date 2023/3/22 20:05
 */
public class MainTest {

    @Test
    public void testConfig(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
    @Test
    public void testComponentScan(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        System.out.println("------------");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("------------");
    }
    @Test
    public void testScope(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person0 = (Person) applicationContext.getBean("Person");
        Person person1 = (Person) applicationContext.getBean("Person");
        System.out.println(person0 == person1);
    }
}
