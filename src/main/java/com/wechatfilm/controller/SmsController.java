package com.wechatfilm.controller;

import com.wechatfilm.common.Result;
import com.wechatfilm.controller.request.SmsRequset;
import com.wechatfilm.service.SmsService;
import com.wechatfilm.utils.RandomUtil;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/sendCode/{phone}")
    public Result smsCode(@PathVariable String phone){
        /*
         * 发送短信验证码
         * 首先从redis里面获取，redis里面能够获取到就直接发送给用户
         * 如果redis里面获取不到证明上一条验证码已过期，重新生成验证发给用户
         */
        String code = stringRedisTemplate.opsForValue().get(phone);
        if (StringUtils.isEmpty(code)) {
            code = RandomUtil.getSixBitRandom();
        }
        // 拿到phone、和code进行验证码发送
        boolean isSend = smsService.sendSms(phone, code);
        if(isSend){
            // 放到redis里面
            stringRedisTemplate.opsForValue().set(phone, code, 5, TimeUnit.MINUTES);
            System.out.println("插入成功");
            return Result.success();
        }else{
            return Result.error("发送短信失败");
        }
    }

    @PostMapping("/getCode")
    public Result getCode(@RequestBody SmsRequset smsRequset){
        System.out.println("获取"+smsRequset.getCode()+"----"+smsRequset.getCode());
        return Result.success(smsService.getCode(smsRequset.getPhone(),smsRequset.getCode()));
    }

}
