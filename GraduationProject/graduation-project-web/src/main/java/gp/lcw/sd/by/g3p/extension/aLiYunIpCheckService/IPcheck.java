package gp.lcw.sd.by.g3p.extension.aLiYunIpCheckService;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@RestController
@RequestMapping("/ip")
public class IPcheck {
    @RequestMapping(value = "/location.json",method = RequestMethod.GET)
    @ResponseBody
    public String getIP(@RequestParam(name = "ip",required = true)String ip) throws Exception{
        System.out.println("ip接口被调用");
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
        querys.put("ip", ip);
        JSONObject responseBody;
        HttpResponse response;
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
              response=  HttpUtils.doGet(host, path, method, headers, querys);


            //EntityUtils.toString(response.getEntity())entity流只能被调用一次有效

              return EntityUtils.toString(response.getEntity());
              //String res=response.getEntity().toString();
             // System.out.println(res);



             //获取response的body
             //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {

            System.out.println("调用失败");
            responseBody=new JSONObject("{result:失败}");
            address="失败";
            e.printStackTrace();
            return "失败";
        }

       // return response;
    }
}
