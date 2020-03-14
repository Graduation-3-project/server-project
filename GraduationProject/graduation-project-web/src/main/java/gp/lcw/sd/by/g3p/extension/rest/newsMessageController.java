package gp.lcw.sd.by.g3p.extension.rest;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.newsMessage;
import gp.lcw.sd.by.g3p.extension.domain.newsMessageDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.newsMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("newsmessage")
public class newsMessageController extends GenericController<newsMessage,Long, newsMessageManager> {


    @Autowired
    newsMessageDaoOperate newsMessageDaoOperate;

    public boolean newsAdd(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    public boolean newsDelete(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    public boolean newsUpdata(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    public boolean newsCheck(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    public boolean newsMakeTop(){
        boolean returnFlag=false;


        return  returnFlag;
    }

}
