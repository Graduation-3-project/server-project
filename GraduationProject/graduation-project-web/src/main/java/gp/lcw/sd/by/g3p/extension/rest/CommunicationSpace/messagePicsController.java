package gp.lcw.sd.by.g3p.extension.rest.CommunicationSpace;


import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.message;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.messagePics;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageDaoOperate;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messagePicsDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messageManager;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messagePicsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/messagePics")
public class messagePicsController  extends GenericController<messagePics,Long, messagePicsManager> {


    @Autowired
    messagePicsDaoOperate messagePicsDaoOperate;


    @RequestMapping(value = "/findAll.json",method = RequestMethod.GET)
    @ResponseBody
    public List<messagePics> findAll(){

        List<messagePics>messagePicsList= messagePicsDaoOperate.findAll();

        return  messagePicsList;
    }
}
