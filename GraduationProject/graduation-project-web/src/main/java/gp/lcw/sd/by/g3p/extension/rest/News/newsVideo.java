package gp.lcw.sd.by.g3p.extension.rest.News;


import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.news;
import gp.lcw.sd.by.g3p.extension.dao.newsVideos;
import gp.lcw.sd.by.g3p.extension.domain.newsDaoOperate;
import gp.lcw.sd.by.g3p.extension.domain.newsVideosDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.newsVideosManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/newsVideo")
public class newsVideo extends GenericController<newsVideos,Long, newsVideosManager> {

    @Autowired
    newsVideosDaoOperate newsVideosDaoOperate;

    @RequestMapping(value = "/Add.json",method = RequestMethod.POST)
    public String Add(@RequestParam(name = "file",required = false) MultipartFile multipartFile){
        String returnFlag;
        //获取原文件名
        String name=multipartFile.getOriginalFilename();

        newsVideos newsVideos=new newsVideos();
        newsVideos.setPointNumber(0);
        newsVideos.setTopFlag("false");
        newsVideos.setVideoName(name);
        newsVideos.setVideoUrl("E:\\newsMessage\\Videos\\"+name);
        newsVideosDaoOperate.save(newsVideos);
        /*https://blog.csdn.net/qq_40979624/article/details/105293900*/
        //视频上传



        returnFlag=this.saveVideoInFile(multipartFile,name);

        return  returnFlag;

    }

    @RequestMapping(value = "/Delete.json",method = RequestMethod.POST)
    public String Delete(@RequestParam(name = "id",required = true)Long id){

        String returnFlag;

        newsVideosDaoOperate.deleteById(id);

        returnFlag="删除成功";
        return  returnFlag;

    }

    @RequestMapping(value = "/findAll.json",method = RequestMethod.GET)
    public List<newsVideos> findAll(){

        List<newsVideos>newsVideosList=newsVideosDaoOperate.findAll();

        return  newsVideosList;

    }

    @RequestMapping(value = "/makeTop.json",method = RequestMethod.POST)
    public String makeTop(@RequestParam(name = "id",required = true)Long id){
        String returnFlag;

        List<newsVideos>newsVideosList=newsVideosDaoOperate.findAll();
        for(int i=0;i<newsVideosList.size();i++){
            //把一个置顶其他手取消
            newsVideos newsVideos=newsVideosList.get(i);
            newsVideos.setTopFlag("false");
            newsVideosDaoOperate.save(newsVideos);
        }
        newsVideos newsVideos=newsVideosDaoOperate.findById(id).get();
        newsVideos.setTopFlag("true");
        newsVideosDaoOperate.save(newsVideos);
        returnFlag="置顶成功";

        return  returnFlag;

    }

    public String saveVideoInFile(MultipartFile multipartFile,String name){
        String returnFlag;

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

        return returnFlag;
    }


}
