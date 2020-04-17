package gp.lcw.sd.by.g3p.extension.rest.News;

import gp.lcw.sd.by.g3p.extension.dao.newsMessage;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import java.io.File;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/newsPage")
public class NewsPageOperate {



    @RequestMapping("/ads.json")
    @ResponseBody
    public boolean ads(@RequestParam("file") MultipartFile[] files) {
        boolean returnFlag = false;
/*https://blog.csdn.net/weixin_44294593/article/details/103070687*/

        System.out.println("输出视频大小"+files[0].getSize());
        String path="E:\\newsMessage\\Videos";
        File file=new File(path);
        if(!file.exists())//文件夹不存在就创建
        {
            file.mkdirs();
        }
        //保存文件
        try {
            files[0].transferTo(new File(file+"\\"+files[0].getOriginalFilename()+""));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //广告信息
        return returnFlag;
    }

    @RequestMapping("/videoUrl.json")
    @ResponseBody
    public boolean videoUrl(@RequestParam( value="file",required=false) MultipartFile multipartFile, HttpServletRequest request) {
        boolean returnFlag = false;

/*https://blog.csdn.net/qq_40979624/article/details/105293900*/

//视频上传
        //获取原文件名
        String name=multipartFile.getOriginalFilename();
        //获取文件后缀
        String subffix=name.substring(name.lastIndexOf(".")+1,name.length());
        //控制格式
        if(subffix.equals("")||!subffix.equals("mp4")||!subffix.equals("mov")||!subffix.equals("avi")||!subffix.equals("wmv")||!subffix.equals("m4v")||!subffix.equals("dat")||!subffix.equals("flv")||!subffix.equals("mkv"))
        {
            //return AjaxResult.error("视频格式不对");
        }
        //新的文件名以日期命名
        // String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        //获取项目路径到webapp
        //String filepath=request.getServletContext().getRealPath("/")+"files\\";
        //获取项目根路径并转到static/videos
        //String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/videos/";
        String path="E:\\newsMessage\\Videos";
        File file=new File(path);
        if(!file.exists())//文件夹不存在就创建
        {
            file.mkdirs();
        }
        //保存文件
        try {
            multipartFile.transferTo(new File(file+"\\"+name+""));
        } catch (IOException e) {
            e.printStackTrace();
        }
       // String realPath=file+"\\"+fileName+"."+subffix;
        //String simulationVideo="/videos/"+fileName+"."+subffix;

        //视频地址
        return returnFlag;
    }

    @RequestMapping("/specialNotice.json")
    @ResponseBody
    public boolean specialNotice() {
        boolean returnFlag = false;





        //特殊通知
        return returnFlag;
    }



}
