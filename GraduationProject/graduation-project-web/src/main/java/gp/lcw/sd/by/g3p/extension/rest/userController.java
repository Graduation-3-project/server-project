package gp.lcw.sd.by.g3p.extension.rest;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.location;
import gp.lcw.sd.by.g3p.extension.dao.users;
import gp.lcw.sd.by.g3p.extension.domain.locationDaoOperate;
import gp.lcw.sd.by.g3p.extension.domain.userDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.userManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class userController  extends GenericController<users,Long, userManager> {


    @Autowired
    userDaoOperate userDaoOperate;

    @Autowired
    locationDaoOperate locationDaoOperate;
/*
    userManager userManager;

    @Autowired
    public void setUserManager(userManager userManager){
        System.out.println("setUserManager");
        this.userManager=userManager;
        this.manager=this.userManager;

    }*/


    @RequestMapping(value = "/delete.json",method = RequestMethod.POST)
    @ResponseBody
    public String userDelete(@RequestParam(name = "id",required = true) Long id){
        String returnFlag;
        userDaoOperate.deleteById(id);
        returnFlag="删除成功";
        return  returnFlag;
    }

    @RequestMapping(value = "/passwordUpdate.json",method = RequestMethod.POST)
    @ResponseBody
    public String passwordUpdate(@RequestParam(name = "id",required = true) Long id,
                                 @RequestParam(name = "userPassword",required = true) String userPassword){
        String returnFlag;
        users users= userDaoOperate.findById(id).get();
        users.setUserPassword(userPassword);
        userDaoOperate.save(users);
        returnFlag="修改成功";
        return  returnFlag;
    }



    @RequestMapping(value = "/findOneUser.json",method = RequestMethod.GET)
    @ResponseBody
    public users findOneUser(@RequestParam(name = "id",required = true) Long id){


       return userDaoOperate.findById(id).get();
    }

    @RequestMapping(value = "/findAll.json", method = RequestMethod.GET)
    @ResponseBody
    public List<users> usersfindAll(){

     List<users>usersLists=userDaoOperate.findAll();

    System.out.println("输出用户数组长度"+usersLists.size());
     return usersLists;
    }


    @RequestMapping(value = "/finishedMsg.json", method = RequestMethod.POST)
    @ResponseBody
    public String finishedMsg(@RequestParam(name = "id",required = true)Long id,
                              @RequestBody location location,
                              @RequestParam(name = "userAge",required = true) String userAge,
                              @RequestParam(name = "userGender",required = true) String userGender){
        String returnFlag;
        //System.out.println("输出location"+location.getCity());

        users users=userDaoOperate.findById(id).get();

       // location.setUsers(users);
        users.setLocation(location);
        users.setUserAge(userAge);
        users.setUserGender(userGender);
        users.setUserFinishMsgFlag("true");
        userDaoOperate.save(users);
       // List<users>usersLists=userDaoOperate.findAll();
        //System.out.println("输出用户数组长度"+usersLists.size());
        returnFlag="成功";

        return returnFlag;
    }

    @RequestMapping(value = "/findMsg.json", method = RequestMethod.GET)
    @ResponseBody
    public List<users> usersfindAllMsg(){

        List<users>usersList=userDaoOperate.findAll();

        for(int i=0;i<usersList.size();i++){
           // System.out.println("输出地理位置"+ locationDaoOperate.findByUsers(usersList.get(i)));
           // System.out.println("输出地理位置"+ locationDaoOperate.findByUsers_Id(usersList.get(i).getId()).getCity());

            //usersList.get(i).setLocation(locationDaoOperate.findByUsers(usersList.get(i)));
        }
       // System.out.println("输出用户数组长度"+usersLists.size());
        return usersList;
    }


    @RequestMapping(value = "/modifyUserMsg.json",method = RequestMethod.POST)
    @ResponseBody
    public String modifyUserMsg(@RequestParam(name = "id",required = true) Long id,
                               @RequestParam(name = "userScreenName",required = true)String userScreenName,
                               @RequestParam(name = "userProfileUrl",required = true)String userProfileUrl){
        String returnFlag;
        String returnHtml = HtmlUtils.htmlUnescape(userProfileUrl);
        users users=userDaoOperate.findById(id).get();
        users.setUserScreenName(userScreenName);
        users.setUserProfileUrl(returnHtml);
        userDaoOperate.save(users);

        returnFlag="修改成功";
        return returnFlag;
    }


}
