package gp.lcw.sd.by.g3p.extension.tengXunYunMessageService;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.message;
import org.json.JSONException;
import com.github.qcloudsms.httpclient.HTTPException;

import javax.swing.text.StringContent;
import java.io.IOException;


public class SendMessage {

    private Data smsParameter = new Data();
/*https://www.jianshu.com/p/4c0d473d743e*/

    public void testSendMessage(String Contentofshortmessage){
        try {
            System.out.println("短信测试");
            //短信模板中的参数列表
            String[] params = {Contentofshortmessage,"5"};//设置短信内容Contentofshortmessage
            SmsSingleSender sender = new SmsSingleSender(smsParameter.getAppId(), smsParameter.getAppKey());
            SmsSingleSenderResult result = sender.sendWithParam("86", smsParameter.getPhoneNumbers(), smsParameter.getTemplateId(), params, smsParameter.getSmsSign(), "", "");
        } catch (HTTPException e) {
            System.out.println(" HTTP 响应码错误");
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println(" JSON 解析错误");
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("网络 IO 错误");
            // 网络 IO 错误
            e.printStackTrace();
        }
    }
}
