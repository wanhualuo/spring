package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //获得容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService = (PersonService) ctx.getBean("personService");
        System.out.println(personService);
    }
}
