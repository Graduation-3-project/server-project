package gp.lcw.sd.by.g3p.extension.rest.CommunicationSpace;

import com.mysql.cj.core.io.LongValueFactory;
import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.message;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.messagePics;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messageManager;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/message")
public class messageController extends GenericController<message,Long, messageManager> {



    @Autowired
    messageDaoOperate messageDaoOperate;

    messageManager messageManager;


    @Autowired
    public void setMessageManager(messageManager messageManager) {
        this.messageManager = messageManager;
        this.manager = this.messageManager;
    }

    /*@RequestBody message message*/

    @RequestMapping(value = "/Add.json",method = RequestMethod.POST)
    @ResponseBody
    public String messageAdd(@RequestParam(name = "messageTitle",required = true) String messageTitle,
                             @RequestParam(name = "messageContent",required = true)String messageContent,
                             @RequestBody List<messagePics>picsList){
        /*@RequestParam(name = "[]picsList",required = true)String[]picsList,*/
        System.out.println("输出集合长度"+picsList.size());
        message message1=new message();
        messageDaoOperate.save(message1);
        try {
            message message=messageDaoOperate.findById(message1.getId()).get();
            message.setMessagePicsList(picsList);
            for(int i=0;i<picsList.size();i++){
                System.out.println("输出Set的内容"+picsList.get(i).getPicData());
               // message.getMessagePicsList().add(picsList.get(i));
            }
            message.setMessage_badPointNumber(0);
            message.setMessageTitle(messageTitle);
            message.setMessageContent(messageContent);
            message.setMessage_goodPointNumber(0);
            messageDaoOperate.save(message);
            //messageManager.save(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String returnFlag="发表成功";
        System.out.println("调用message接口成功");
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

    @RequestMapping(value = "/findAll.json",method = RequestMethod.GET)
    @ResponseBody
    public List<message> findAll(){

       List<message>messageList=messageDaoOperate.findAll();

        return  messageList;
    }

    @RequestMapping(value = "/Check",method = RequestMethod.GET)
    @ResponseBody
    public boolean messageCheck(){
        Boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping(value = "/save.json",method = RequestMethod.POST)
    @ResponseBody
    public boolean messagepicSave(@RequestParam("file") MultipartFile[] files){
        Boolean returnFlag=false;


        return  returnFlag;
    }

}
