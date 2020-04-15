package gp.lcw.sd.by.g3p.extension.rest.News;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.newsMessage;
import gp.lcw.sd.by.g3p.extension.domain.newsMessageDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.newsMessageManager;
import org.hibernate.type.LongType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
@RequestMapping("/newsmessage")
public class newsMessageController extends GenericController<newsMessage,Long, newsMessageManager> {


    @Autowired
    newsMessageDaoOperate newsMessageDaoOperate;

    @RequestMapping(value = "/add.json",method = RequestMethod.POST )
    @ResponseBody
    public boolean newsAdd(@RequestParam (name = "content",required = true) String content){
        boolean returnFlag=false;

        //String toHtml = HtmlUtils.htmlEscapeHex(html);

        /*https://blog.csdn.net/weixin_39309402/article/details/101215388
        * 转成html格式
        * */
        String returnHtml = HtmlUtils.htmlUnescape(content);
         newsMessage newsMessage=new newsMessage();
         newsMessage.setNewsContent(returnHtml);

         newsMessageDaoOperate.save(newsMessage);
        return  returnFlag;
    }
    @RequestMapping("/delete.json")
    @ResponseBody
    public boolean newsDelete(){
        boolean returnFlag=false;
        
        return  returnFlag;
    }
    @RequestMapping("/updata.json")
    @ResponseBody
    public boolean newsUpdata(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("/check.json")
    @ResponseBody
    public boolean newsCheck(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping("/top.json")
    @ResponseBody
    public boolean newsMakeTop(){
        boolean returnFlag=false;


        return  returnFlag;
    }
    @RequestMapping(value = "/findAll.json",method = RequestMethod.GET)
    @ResponseBody
    public List<newsMessage> newsFindAll(){
        List<newsMessage> newsMessages=newsMessageDaoOperate.findAll();


        return  newsMessages;
    }

}
