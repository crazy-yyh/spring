package com.yan01.ui;

import com.yan01.config.SpringConfiguration;
import com.yan01.domain.Account;
import com.yan01.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.根据id获取Bean对象
        IAccountService as  = (IAccountService)ac.getBean("accountService");

        List<Account> allAccount = as.findAllAccount();
        for(Account l : allAccount){
            System.out.println(l);
        }

    }
}
