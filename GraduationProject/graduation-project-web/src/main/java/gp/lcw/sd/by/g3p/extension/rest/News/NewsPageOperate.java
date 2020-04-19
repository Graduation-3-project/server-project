package gp.lcw.sd.by.g3p.extension.rest.News;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.news;
import gp.lcw.sd.by.g3p.extension.dao.newsMessage;
import gp.lcw.sd.by.g3p.extension.domain.newsDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.newsManager;
import gp.lcw.sd.by.g3p.extension.serviceManager.newsMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/newsPage")
public class NewsPageOperate extends GenericController<news,Long, newsManager> {


    @Autowired
    newsDaoOperate newsDaoOperate;
    @Autowired
    httpVideos httpVideos;

    @RequestMapping("/pics.json")
    @ResponseBody
    public String ads(@RequestParam("file") MultipartFile[] files) {
           String returnFlag;
/*https://blog.csdn.net/weixin_44294593/article/details/103070687*/
        String path="E:\\newsMessage\\Pic";
        File file=new File(path);
        if(!file.exists())//文件夹不存在就创建
        {
            file.mkdirs();
        }
        //保存文件
        try {
            files[0].transferTo(new File(file+"\\"+files[0].getOriginalFilename()+""));
            returnFlag="上传成功";
        } catch (IOException e) {
            returnFlag="上传失败";
            e.printStackTrace();
        }
        news news=new news();
        //广告信息
        return returnFlag;
    }

    @RequestMapping("/videoUrl.json")
    @ResponseBody
    public String videoUrl(@RequestParam( value="file",required=false) MultipartFile multipartFile, HttpServletRequest request) {
        String returnFlag;
        news news=new news();
        news.setNewsPageVideoUrl(multipartFile.getOriginalFilename());
        newsDaoOperate.save(news);
       /*https://blog.csdn.net/qq_40979624/article/details/105293900*/

        //视频上传
        //获取原文件名
        String name=multipartFile.getOriginalFilename();
        //获取文件后缀
        String subffix=name.substring(name.lastIndexOf(".")+1,name.length());
        //控制格式

       /*  if(subffix.equals("")||!subffix.equals("mp4")||!subffix.equals("mov")||!subffix.equals("avi")||!subffix.equals("wmv")||!subffix.equals("m4v")||!subffix.equals("dat")||!subffix.equals("flv")||!subffix.equals("mkv"))
        {
            return AjaxResult.error("视频格式不对");
        }
       String realPath=file+"\\"+fileName+"."+subffix;
        String simulationVideo="/videos/"+fileName+"."+subffix;
        新的文件名以日期命名
         String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        获取项目路径到webapp
        String filepath=request.getServletContext().getRealPath("/")+"files\\";
        获取项目根路径并转到static/videos
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/videos/";
       */
        String path="E:\\newsMessage\\Videos";
        File file=new File(path);
        if(!file.exists())//文件夹不存在就创建
        {
            file.mkdirs();
        }
        //保存文件
        try {
            multipartFile.transferTo(new File(file+"\\"+name+""));
           returnFlag="上传成功";
        } catch (IOException e) {
            returnFlag="上传失败";
            e.printStackTrace();
        }

       // httpVideos.path=path+multipartFile.getOriginalFilename();
        httpVideos.setPath(path+"\\"+multipartFile.getOriginalFilename());
       // video(response,"E:\\newsMessage\\Videos\\"+multipartFile.getOriginalFilename());
        //视频地址
        return  returnFlag;
    }

    @RequestMapping("/specialNotice.json")
    @ResponseBody
    public boolean specialNotice() {
        boolean returnFlag = false;



        //特殊通知
        return returnFlag;
    }

    @RequestMapping("/getAllMessage.json")
    @ResponseBody
    public List<news> getAllMessage() {
       // boolean returnFlag = false;

        List<news> news=newsDaoOperate.findAll();

        //特殊通知
        return news;
    }

   /* public void video(HttpServletResponse response,String vidoePath){

        File file = new File(vidoePath);
        ServletOutputStream out = null;
        try {
            FileInputStream instream = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length = 0;
            BufferedInputStream buf = new BufferedInputStream(instream);
            out = response.getOutputStream();
            BufferedOutputStream bot = new BufferedOutputStream(out);

            while ((length = buf.read(b)) != -1) {

                bot.write(b, 0, b.length);
            }
            buf.close();
            bot.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
*/

}
