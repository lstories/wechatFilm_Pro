package com.wechatfilm.service.impl;

import com.wechatfilm.Exception.ServiceException;
import com.wechatfilm.service.SmsService;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class SmsServiceImpl implements SmsService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 发送验证码
     * @param phone
     * @param code
     * @return
     */
    @Override
    public boolean sendSms(String phone,String code){
        DefaultProfile profile = DefaultProfile.getProfile("cn-guangzhou", "LTAI5tBVkQ67rNu3wNDN885J", "13RzPk5araT3WR8Cncsm1UmIj4vKlf");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        //下面这3个不要改动
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        //接收短信的手机号码
        request.putQueryParameter("PhoneNumbers",phone);
        //短信签名名称
        request.putQueryParameter("SignName","影咖购票管理系统");
        //短信模板ID
        request.putQueryParameter("TemplateCode","SMS_276180325");
        //短信模板变量对应的实际值 ${code} 中的值

        Map<String,String> param = new HashMap<>(2);
        param.put("code",code);
        request.putQueryParameter("TemplateParam",JSONObject.toJSONString(param));

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 验证码验证
     * @param phone
     * @param code
     */
    @Override
    public boolean getCode(String phone, String code) {
        if(code.isEmpty()){
            throw new ServiceException("请输入验证码");
        }
        if (code.equals(stringRedisTemplate.opsForValue().get(phone))){
            return true;
        }
        return false;
    }
}
