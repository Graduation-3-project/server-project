package gp.lcw.sd.by.g3p.extension.serviceImpl;

import gp.lcw.sd.by.g3p.base.service.impl.GenericManagerImpl;
import gp.lcw.sd.by.g3p.extension.dao.location;
import gp.lcw.sd.by.g3p.extension.dao.users;
import gp.lcw.sd.by.g3p.extension.domain.userDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.userManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;



public class userImlpl extends GenericManagerImpl<users,Long> implements userManager{

/*
    userDaoOperate userDaoOperate;
    @Autowired
    public void setUserDaoOperate(userDaoOperate userDaoOperate){
        System.out.println("这是setUserDaoOperate");
        this.userDaoOperate=userDaoOperate;
        this.dao=this.userDaoOperate;

    }

    @Override
    public List<users>findAllMsg(){

        return userDaoOperate.findAll();
    }*/

}
