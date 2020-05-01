package gp.lcw.sd.by.g3p.extension.rest.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.message;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.messageComment;
import gp.lcw.sd.by.g3p.extension.dao.users;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageCommentDaoOperate;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageDaoOperate;
import gp.lcw.sd.by.g3p.extension.domain.userDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messageCommentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messageComment")
public class messageCommentController  extends GenericController<messageComment,Long, messageCommentManager> {

    @Autowired
    messageCommentDaoOperate messageCommentDaoOperate;


    @Autowired
    messageDaoOperate messageDaoOperate;

    @Autowired
    userDaoOperate userDaoOperate;

    @ResponseBody
    @RequestMapping(value = "/Add.json",method = RequestMethod.POST)
    public String Add(@RequestParam(name = "id",required = true) Long id,
                      @RequestParam(name = "userId",required = true)Long userId,
                      @RequestParam(name = "commentContent",required = true)String commentContent){
        String returnFlag;
        //userId为发评论人的id
        //id为message的id

        users user=userDaoOperate.findById(userId).get();

        messageComment messageComment0=new messageComment();
        messageCommentDaoOperate.save(messageComment0);
        messageComment messageComment=messageCommentDaoOperate.findById(messageComment0.getId()).get();
        messageComment.setCommentContent(commentContent);
        messageComment.setUserId(userId);

        messageComment.setCommentPeopleName(user.getUserScreenName());
        message message=messageDaoOperate.findById(id).get();
        message.getMessageCommentSet().add(messageComment);
        messageDaoOperate.save(message);
        userDaoOperate.save(user);

        returnFlag="发表成功";
        return  returnFlag;
    }
    @ResponseBody
    @RequestMapping(value = "/findAll.json",method = RequestMethod.POST)
    public String findAll(@RequestParam(name = "id",required = true) Long id,
                      @RequestParam(name = "userId",required = true)Long userId,
                      @RequestParam(name = "commentContent",required = true)String commentContent){
        String returnFlag;





        returnFlag="发表成功";
        return  returnFlag;
    } @ResponseBody
    @RequestMapping(value = "/delete.json",method = RequestMethod.POST)
    public String delete(@RequestParam(name = "id",required = true) Long id,
                      @RequestParam(name = "userId",required = true)Long userId,
                      @RequestParam(name = "commentContent",required = true)String commentContent){
        String returnFlag;


        returnFlag="发表成功";
        return  returnFlag;
    } @ResponseBody
    @RequestMapping(value = "/findById.json",method = RequestMethod.POST)
    public message findById(@RequestParam(name = "id",required = true) Long id){
        //找一个动态的所有评论
        String returnFlag;

       message message=messageDaoOperate.findById(id).get();


        return  message;
    }

}
