package gp.lcw.sd.by.g3p.extension.rest.News;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.newsMessage;
import gp.lcw.sd.by.g3p.extension.domain.newsMessageDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.newsMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newsmessage")
public class newsMessageController extends GenericController<newsMessage,Long, newsMessageManager> {


    @Autowired
    newsMessageDaoOperate newsMessageDaoOperate;

    @RequestMapping(value = "/add.json",method = RequestMethod.GET )
    @ResponseBody
    public boolean newsAdd(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("/delete.json")
    @ResponseBody
    public boolean newsDelete(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("/updata.json")
    @ResponseBody
    public boolean newsUpdata(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("/check.json")
    @ResponseBody
    public boolean newsCheck(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("/top.json")
    @ResponseBody
    public boolean newsMakeTop(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("/findALl.json")
    @ResponseBody
    public boolean newsFindAll(){
        boolean returnFlag=false;



        return  returnFlag;
    }

}
