package gp.lcw.sd.by.g3p.extension.rest;

import gp.lcw.sd.by.g3p.extension.dao.users;
import gp.lcw.sd.by.g3p.extension.domain.userDaoOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class login {

    @Autowired
    userDaoOperate userDaoOperate;

    //private boolean loginFlag=false;
    @RequestMapping(path = "/judeg.json",method = RequestMethod.GET)
    public users judeg_Login(@RequestParam(name = "account",required = true) String account,
                               @RequestParam(name = "password",required = true) String password){
        users users=userDaoOperate.findByUserTel(account);

        if(users.getUserPassword().equals(password)){
            return users;
        }else {
            return null;
        }

    }


    @RequestMapping(path = "/setLoginFlag.json",method = RequestMethod.POST)
    public void setLoginFlag(@RequestParam(name = "account",required = true) String account){
        users users=userDaoOperate.findByUserTel(account);

            users.setUserLoginFlag("true");
            userDaoOperate.save(users);
    }




    @RequestMapping(path = "/quitLogin.json",method = RequestMethod.POST)
    public users quitLogin(@RequestParam(name = "id",required = true) Long id)
    {

        users users=userDaoOperate.findById(id).get();
            users.setUserLoginFlag("false");
            userDaoOperate.save(users);

       /* if(users!=null&&users.getUserPassword()==password){
            this.loginFlag=true;
        }*/


        //  return this.loginFlag;
        return users;
    }


}
