package gp.lcw.sd.by.g3p.extension.rest.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.message;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class messageController extends GenericController<message,Long, messageManager> {

    @Autowired
    messageDaoOperate messageDaoOperate;


    @RequestMapping(value = "/Add",method = RequestMethod.POST)
    @ResponseBody
    public boolean messageAdd(){
        Boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping(value = "/Delete",method = RequestMethod.POST)
    @ResponseBody
    public boolean messageDelete(){
        Boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("Updata")
    @ResponseBody
    public boolean messageUpdata(){
        Boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping(value = "/Check",method = RequestMethod.GET)
    @ResponseBody
    public boolean messageCheck(){
        Boolean returnFlag=false;


        return  returnFlag;
    }


}
