package gp.lcw.sd.by.g3p.extension.rest.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.administrator;

import gp.lcw.sd.by.g3p.extension.domain.administratorDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.administratorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    administrator.setLoginFlag(false);
    administratorDaoOperate.save(administrator);
    returnFlag="添加成功";
    return  returnFlag;
}
@PostMapping("/login")
public String login(@RequestParam(name = "password" ,required = true) String password,
                     @RequestParam(name = "account" ,required = true) String account) {
    System.out.println("管理员登录接口");
String returnFlag="false";
    administrator administrator1;
if(administratorDaoOperate.findByAccount(account)!=null){
     administrator1=  administratorDaoOperate.findByAccount(account);
     System.out.println("输出登录标识"+ administrator1.isLoginFlag());
    if(administrator1.getPassword().equals(password)&&(administrator1.isLoginFlag()==false))
    {
        administrator1.setLoginFlag(true);
        administratorDaoOperate.save(administrator1);
        returnFlag="true";
    }
}else {
    returnFlag="false";
}


return  returnFlag;
}


@PostMapping("/quitLogin")
public void quitLogin(@RequestParam(name = "id",required = true) Long id){
    administrator administrator=administratorDaoOperate.findById(id).get();
    administrator.setLoginFlag(false);
    administratorDaoOperate.save(administrator);
}


    @GetMapping("/getOne")
    public administrator getOne(String account){


        administrator administrator=administratorDaoOperate.findByAccount(account);

        return administrator;
    }

}




