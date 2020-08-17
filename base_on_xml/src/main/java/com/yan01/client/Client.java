package com.yan01.client;

import com.yan01.dao.IAccountDao;
import com.yan01.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象,两种方式
        IAccountService as  = (IAccountService)ac.getBean("accountService");
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

//        System.out.println(as);
//        System.out.println(adao);
        as.saveAccount();

    }
}
