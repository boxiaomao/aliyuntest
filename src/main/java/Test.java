import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.reader.JsonReader;
import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.runtime.JSONListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Boxiaomao on 2017/7/25 0025.
 */
public class Test {

    public void sendeMsg(String phoneNumber,String SignName,String TemplateCode,String TemplateParam ){
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        //替换成你的AK
        final String accessKeyId = "LTAICZoKxfKDKIxz";//你的accessKeyId,参考本文档步骤2
        final String accessKeySecret = "DtxWqwedmMeObUI5g5Cb8v80XnECCO";//你的accessKeySecret，参考本文档步骤2
        //初始化ascClient,暂时不支持多region
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        SendSmsResponse sendSmsResponse=null;
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            IAcsClient acsClient = new DefaultAcsClient(profile);
            //组装请求对象
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
            request.setPhoneNumbers(phoneNumber);//"17388290571,13388917712"
            //必填:短信签名-可在短信控制台中找到
            request.setSignName(SignName);//阿里云短信测试专用
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(TemplateCode);//"SMS_76630928"
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(TemplateParam);//"{\"code\":\"123\"}"
            //可选-上行短信扩展码(无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");
            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId("mujia");
            //请求失败这里会抛ClientException异常
             sendSmsResponse = acsClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println(sendSmsResponse.getCode());
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
//请求成功
        }
    }

    public static void main(String[] args) {
                    Test test = new Test();
                    String phoneNumber = "17388290571";//17388290571,13388917712,15002359405,18203087761,15310479261,18523059914,
                    String SignName = "阿里云短信测试专用";
                    String TemplateCode = "SMS_78965062";
                    //HashMap hashMap=new HashMap();17782005754
                    //hashMap.put("code","666666");
                    JSONObject json = new JSONObject();
                    String name = "车护宝";
                    json.put("name", name);
                    String TemplateParam = json.toString();
                    System.out.println(TemplateParam);
                    test.sendeMsg(phoneNumber, SignName, TemplateCode, TemplateParam);
}

}
