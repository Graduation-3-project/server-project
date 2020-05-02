package gp.lcw.sd.by.g3p.extension.rest.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.administrator;

import gp.lcw.sd.by.g3p.extension.domain.administratorDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.administratorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrator")
public class administratorController extends GenericController<administrator,Long, administratorManager> {
           @Autowired
           administratorDaoOperate administratorDaoOperate;


@PostMapping("/add")
public String Add(@RequestBody administrator administrator0){
    String returnFlag;

    administrator administrator=new administrator();
    administrator.setAccount(administrator0.getAccount());
    administrator.setPassword(administrator0.getPassword());
    administrator.setType(administrator0.getType());
    administratorDaoOperate.save(administrator);
    returnFlag="添加成功";
    return  returnFlag;
}
@PostMapping("/login")
public boolean login(@RequestBody administrator administrator) {
boolean returnFlag=false;
    administrator administrator1;
if(administratorDaoOperate.findByAccount(administrator.getAccount())!=null){
     administrator1=  administratorDaoOperate.findByAccount(administrator.getAccount());

    if(administrator1.getPassword().equals(administrator.getPassword()))
    {
        returnFlag=true;
    }
}else {
    returnFlag=false;
}


return  returnFlag;
}

}




