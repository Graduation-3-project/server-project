import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import gp.lcw.sd.by.g3p.extension.tengXunYunMessageService.Data;
import org.json.JSONException;
import com.github.qcloudsms.httpclient.HTTPException;

import java.io.IOException;

public class SendMessage {
    private Data smsParameter = new Data();

/*短信服务内容测试*/


    public void testSendMessage(){
        try {
            //短信模板中的参数列表
            String[] params = {"99999","5"};
            SmsSingleSender sender = new SmsSingleSender(smsParameter.getAppId(), smsParameter.getAppKey());
            SmsSingleSenderResult result = sender.sendWithParam("86", smsParameter.getPhoneNumbers(),
                    smsParameter.getTemplateId(), params, smsParameter.getSmsSign(), "", "");
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
    }
}
