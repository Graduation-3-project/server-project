package gp.lcw.sd.by.g3p.extension.aLiYunIpCheckService;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ip")
public class IPcheck {
    @RequestMapping("/location.json")
    @ResponseBody
    public String getIP(){

        String address;
        String host = "https://api01.aliyun.venuscn.com";
        String path = "/ip";
        String method = "GET";
        //String appcode = "你自己的AppCode";
        String appcode = "adf93c70cc1a48c29aa436c9ae5ff4bd";

        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        //headers.put("Authorization", "APPCODE " + appcode);
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("ip", "113.87.188.238");

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            address="成功";
            HttpResponse response=  HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(EntityUtils.toString(response.getEntity()));
            //address=EntityUtils.toString(response.getEntity());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            address="失败";
            e.printStackTrace();
        }
        return address;
    }

}
