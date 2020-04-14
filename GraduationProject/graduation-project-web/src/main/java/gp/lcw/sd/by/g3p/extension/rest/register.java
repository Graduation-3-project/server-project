package gp.lcw.sd.by.g3p.extension.rest;

import gp.lcw.sd.by.g3p.extension.dao.users;
import gp.lcw.sd.by.g3p.extension.domain.userDaoOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/register")
public class register {


    private int verificationCode;

    @Autowired
    userDaoOperate userDaoOperate;

    @RequestMapping( path = "/getVerificationCode.json",method = RequestMethod.GET)
    @ResponseBody
     public users getVerificationCode(@RequestParam(name = "number",required = true) String number){


        //userDaoOperate.findByUser_tel(number);
        //System.out.println("输出通过电话号码查询结果"+userDaoOperate.findByUserTel(number));
        if(userDaoOperate.findByUserTel(number)==null){
            Random random = new Random();//默认构造方法
            //Random randoms = new Random(1000);//指定种子数字
            verificationCode = random.nextInt(1100000);
            users users=new users();
            users.setUserTel(number);
            users.setUserRegisterCode(String.valueOf(verificationCode));
            users.setUserRegisterFlag("false");
            userDaoOperate.save(users);
            return users;

        }else{
            // return   userDaoOperate.findByUserTel(number);

            users users=userDaoOperate.findByUserTel(number);
             if(users.getUserRegisterFlag().equals("false")){
                 return users;
             }
             else {
                 return null;
             }



        }
    }
    @RequestMapping( path = "/setPassword.json",method = RequestMethod.GET)
    @ResponseBody
    public int registerAccount(@RequestParam(name = "password",required = true) String password,
                                   @RequestParam(name = "id",required = true)  Long id){


        users users;

        users=userDaoOperate.findById(id).get();
        users.setUserPassword(password);
        users.setUserRegisterFlag("true");
        userDaoOperate.save(users);

        return 1;
    }

}
