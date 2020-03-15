package gp.lcw.sd.by.g3p.extension.rest.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.message;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class messageController extends GenericController<message,Long, messageManager> {

    @Autowired
    messageDaoOperate messageDaoOperate;


    @RequestMapping("Add")
    public boolean messageAdd(){
        Boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("Delete")
    public boolean messageDelete(){
        Boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("Updata")
    public boolean messageUpdata(){
        Boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("Check")
    public boolean messageCheck(){
        Boolean returnFlag=false;


        return  returnFlag;
    }


}
