package com.yan01.dao.impl;

import com.yan01.dao.IAccountDao;

public class IAccountDaoImpl implements IAccountDao {
    @Override
    public  void saveAccount(){

        System.out.println("保存了账户");
    }
}
