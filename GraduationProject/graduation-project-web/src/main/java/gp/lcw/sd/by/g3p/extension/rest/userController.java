package gp.lcw.sd.by.g3p.extension.rest;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.users;
import gp.lcw.sd.by.g3p.extension.domain.userDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.userManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController  extends GenericController<users,Long, userManager> {


    @Autowired
    userDaoOperate userDaoOperate;

    @RequestMapping(value = "/delete.json",method = RequestMethod.POST)
    @ResponseBody
    public String userDelete(@RequestParam(name = "id",required = true) Long id){
        String returnFlag;
        userDaoOperate.deleteById(id);
        returnFlag="删除成功";
        return  returnFlag;
    }
    @RequestMapping(value = "/findAll.json", method = RequestMethod.GET)
    @ResponseBody
    public List<users> usersfindAll(){

     List<users>usersLists=userDaoOperate.findAll();

    System.out.println("输出用户数组长度"+usersLists.size());
     return usersLists;
    }

}
