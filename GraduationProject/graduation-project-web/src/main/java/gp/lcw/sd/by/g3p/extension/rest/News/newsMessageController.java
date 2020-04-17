package gp.lcw.sd.by.g3p.extension.rest.News;


import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.newsMessage;
import gp.lcw.sd.by.g3p.extension.domain.newsMessageDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.newsMessageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.HtmlUtils;










import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Action;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/newsmessage")
public class newsMessageController extends GenericController<newsMessage,Long, newsMessageManager> {


    @Autowired
    newsMessageDaoOperate newsMessageDaoOperate;

    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    @ResponseBody
    public boolean newsAdd(@RequestParam(name = "content", required = true) String content,
                           @RequestParam(name = "newsAuthor", required = true) String newsAuthor,
                           @RequestParam(name = "picsUrl", required = true) String picsUrl,
                           @RequestParam(name = "newsTitle", required = true) String newsTitle,
                           @RequestParam(name = "topFlag", required = true) String topFlag,
                           @RequestParam(name = "clickNumber", required = true) String clickNumber) {
        boolean returnFlag = false;

        //String toHtml = HtmlUtils.htmlEscapeHex(html);

        /*https://blog.csdn.net/weixin_39309402/article/details/101215388
         * 转成html格式
         * */
        String returnHtml = HtmlUtils.htmlUnescape(content);
        newsMessage newsMessage = new newsMessage();
        newsMessage.setNewsContent(returnHtml);
        newsMessage.setPicsUrl(picsUrl);
        newsMessage.setNewsTitle(newsTitle);
        newsMessage.setNewsAuthor(newsAuthor);
        newsMessage.setClickNumber(clickNumber);
        newsMessage.setTopFlag(topFlag);
        newsMessageDaoOperate.save(newsMessage);



        returnFlag=true;
        return returnFlag;
    }

    @RequestMapping("/delete.json")
    @ResponseBody
    public boolean newsDelete() {
        boolean returnFlag = false;

        return returnFlag;
    }

    @RequestMapping("/updata.json")
    @ResponseBody
    public boolean newsUpdata() {
        boolean returnFlag = false;


        return returnFlag;
    }

    @RequestMapping("/check.json")
    @ResponseBody
    public boolean newsCheck() {
        boolean returnFlag = false;


        return returnFlag;
    }

    @RequestMapping("/top.json")
    @ResponseBody
    public boolean newsMakeTop() {
        boolean returnFlag = false;


        return returnFlag;
    }
    /*   map.put("type", "String");
         map.put("name", "testName");
          D:\JAVA\WorkSpace\freemaker\src\main\resources\testEntity.ftl
     */



    private static Configuration getConfiguration(String templateDirectory)
    {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        try {
            configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
            //鍔犺浇妯℃澘
            configuration.setDirectoryForTemplateLoading(new File(templateDirectory));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return configuration;
    }

    private boolean freemaker() throws IOException
    {
        {
            Map<String, Object> map = new HashMap<String, Object>();
            String templateDirectory = "src/main/resources/template";//设置模板地址
            String templateFile = "testEntity.ftl";//模板的名称
            String targetPath = "C:/Users/i/Desktop/template";//设置生成模板的地址
            String fileName = "web.html";//设置目录名

            new File(targetPath).mkdirs();
            File nFile = new File(targetPath + "/" + fileName);//新建一个文件
            if (nFile.exists()) {
                System.out.println("文件建立成功1");
                throw new RuntimeException("File \'" + fileName + "\' already exists");
            } else {
                System.out.println("文件建立成功");
            }
            Writer writer = null;
            try {
                writer = new FileWriter(nFile);//吧生成的模板内容写入文件
                Template template = getConfiguration(templateDirectory).getTemplate(templateFile, "UTF-8");
                template.process(map, writer);
            } catch (TemplateException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("写入成功");
                writer.close();
            }

        }

        return true;
    }
    @RequestMapping(value = "/makehtlm.json", method = RequestMethod.GET)
    @ResponseBody
    public boolean makehtlm(@RequestParam(name = "content", required = true) String content,
                            @RequestParam(name = "title", required = true) String title) {
        boolean flag=false;


        return  flag;
    }






    @RequestMapping(value = "/findAll.json",method = RequestMethod.GET)
    @ResponseBody
    public List<newsMessage> newsFindAll(){
        List<newsMessage> newsMessages=newsMessageDaoOperate.findAll();


        return  newsMessages;
    }

    @Action
    @RequestMapping(value = "/postPic.json",method = RequestMethod.POST)
    @ResponseBody
    public String getPic(@RequestParam(name = "pic",required = true)String pic) throws Exception
    {

        /*      @RequestParam Map<String,String> map,
                         @RequestParam("file") MultipartFile[] file,
                         HttpServletRequest req, MultipartHttpServletRequest multiReq*/

        String returnHtml = HtmlUtils.htmlUnescape(pic);
        System.out.println("输出文件"+returnHtml);
        setFile(returnHtml);
       /* if(map.size() >0) {
            try {
                String fileId = map.get("fileId").toString();
                String fileType = map.get("fileType").toString();
                String fileDesc = map.get("fileDesc").toString();
                String filePath = map.get("filePath").toString();
                 baseAppfileService.uploadFiles(file,filePath,fileId,fileType,fileDesc);
            } catch (Exception e) {
                 return new Result().error();
            }


        }
             return new Result();

            HttpServletRequest request = ServletActionContext.getRequest();
            String mdeiaName =  request.getParameter("mdeiaName");
            String id = request.getParameter("id");
            String arr = request.getParameter("arr");
*/
            //List<newsMessage> newsMessages=newsMessageDaoOperate.findAll();
            String url = "C:\\Users\\i\\Desktop\\创业资料\\图片\\tu .jpg";
            System.out.println("输出获取的图片" + pic);


            return url;

    }

    private static String saveTxtFilePath = "E:\\newsMessage\\test.html";
    @RequestMapping(value = "/saveAsTxt.json", method = RequestMethod.POST)
    @ResponseBody
    public boolean saveAsTxt(@RequestParam(name = "content", required = true) String content) {
        /*     , @RequestParam(name = "title", required = true) String title*/


        boolean flag=false;

        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter(saveTxtFilePath);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }



        return  flag;
    }


    private void setFile(String content){



        FileWriter fwriter = null;
        try {
            fwriter = new FileWriter(saveTxtFilePath);
            fwriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
