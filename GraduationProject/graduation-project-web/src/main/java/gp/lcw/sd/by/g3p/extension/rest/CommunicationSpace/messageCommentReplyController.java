package gp.lcw.sd.by.g3p.extension.rest.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.message;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.messageComment;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.messageCommentReply;
import gp.lcw.sd.by.g3p.extension.dao.users;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageCommentDaoOperate;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageCommentReplyDaoOperate;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageDaoOperate;
import gp.lcw.sd.by.g3p.extension.domain.userDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messageCommentManager;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messageCommentReplyManager;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messageCommentReply")
public class messageCommentReplyController extends GenericController<messageCommentReply,Long, messageCommentReplyManager> {

         @Autowired
         messageCommentReplyDaoOperate messageCommentReplyDaoOperate;

         @Autowired
         messageDaoOperate messageDaoOperate;

         @Autowired
         messageCommentDaoOperate messageCommentDaoOperate;


         @Autowired
         userDaoOperate userDaoOperate;

         @RequestMapping(value = "/Add.json",method = RequestMethod.POST)
         @ResponseBody
         public String Add(@RequestParam(name = "messageFromUserId",required = true) Long messageFromUserId,
                           @RequestParam(name = "messageToUserId",required = true) Long messageToUserId,
                           @RequestParam(name = "replyCommentContent",required = true)String replyCommentContent,
                           @RequestParam(name = "messageId",required = true)Long messageId){
             String returnFlag;
             users userFrom =userDaoOperate.findById(messageFromUserId).get();
             users userTo=   userDaoOperate.findById(messageToUserId).get();

             messageComment messageComment=messageCommentDaoOperate.findById(messageId).get();

             messageCommentReply messageCommentReply=new messageCommentReply();
             messageCommentReplyDaoOperate.save(messageCommentReply);
             messageCommentReply messageCommentReply1=messageCommentReplyDaoOperate.findById(messageCommentReply.getId()).get();
             messageCommentReply1.setReplyCommentContent(replyCommentContent);
             messageCommentReply1.setMessageFromUserId(messageFromUserId);
             messageCommentReply1.setMessageToUserId(messageToUserId);
             messageCommentReply1.setMessageFromUserName(userFrom.getUserScreenName());
             messageCommentReply1.setMessageToUserName(userTo.getUserScreenName());
             messageCommentReply1.setMessageCommentId(messageComment.getId());
             messageCommentReplyDaoOperate.save(messageCommentReply1);
             messageComment.getMessageCommentReplySet().add(messageCommentReply1);
             messageCommentDaoOperate.save(messageComment);


             returnFlag="发表成功";
             return  returnFlag;
         }


         @RequestMapping(value = "peopleToPeople.json",method = RequestMethod.POST)
         @ResponseBody
         public String Replay(@RequestParam(name = "messageFromUserId",required = true) Long messageFromUserId,
                              @RequestParam(name = "messageToUserId",required = true) Long messageToUserId,
                              @RequestParam(name = "replyCommentContent",required = true)String replyCommentContent,

                              @RequestParam(name = "messageCommentId",required = true)Long messageCommentId
                              ){
             String returnFlag;
/*  @RequestParam(name = "messageId",required = true) Long messageId,*/
              messageCommentReply messageCommentReply=new messageCommentReply();
              messageCommentReplyDaoOperate.save(messageCommentReply);
              messageCommentReply messageCommentReply1=messageCommentReplyDaoOperate.findById(messageCommentReply.getId()).get();
             messageCommentReply1.setMessageToUserId(messageToUserId);
             messageCommentReply1.setMessageFromUserId(messageFromUserId);
             messageCommentReply1.setMessageToUserName(userDaoOperate.findById(messageToUserId).get().getUserScreenName());
             messageCommentReply1.setMessageFromUserName(userDaoOperate.findById(messageFromUserId).get().getUserScreenName());
             messageCommentReply1.setReplyCommentContent(replyCommentContent);
             messageCommentReply1.setMessageCommentId(messageCommentId);
             // message message=messageDaoOperate.findById(messageId).get();

              messageComment messageComment=messageCommentDaoOperate.findById(messageCommentId).get();
              messageComment.getMessageCommentReplySet().add(messageCommentReply1);
              messageCommentDaoOperate.save(messageComment);

             returnFlag="回复成功";
             return  returnFlag;
         }
}
