package com.yan01;

import com.yan01.dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbctest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao2", IAccountDao.class);
        //3.执行操作
        System.out.println(accountDao.findAccountById(1));
    }
}
