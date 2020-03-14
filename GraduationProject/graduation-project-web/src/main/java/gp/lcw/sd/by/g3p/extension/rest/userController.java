package gp.lcw.sd.by.g3p.extension.rest;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.users;
import gp.lcw.sd.by.g3p.extension.domain.userDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.userManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Repository("/user")
public class userController  extends GenericController<users,Long, userManager> {


    @Autowired
    userDaoOperate userDaoOperate;

    @RequestMapping("add")
    public boolean userAdd(){

        boolean returnFlag=false;




        return  returnFlag;
    }
    @RequestMapping("delete")
    public boolean userDelete(){

        boolean returnFlag=false;




        return  returnFlag;
    }
    @RequestMapping("updata")
    public boolean userUpdata(){

        boolean returnFlag=false;




        return  returnFlag;
    }
    @RequestMapping("check")
    public boolean userCheck(){

        boolean returnFlag=false;




        return  returnFlag;
    }

}
