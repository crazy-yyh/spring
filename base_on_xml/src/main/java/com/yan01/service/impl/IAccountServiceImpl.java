package com.yan01.service.impl;

import com.sun.security.ntlm.Client;
import com.yan01.dao.IAccountDao;
import com.yan01.dao.impl.IAccountDaoImpl;
import com.yan01.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class IAccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public IAccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
