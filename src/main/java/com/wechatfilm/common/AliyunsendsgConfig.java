package com.wechatfilm.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aliyun.send-msg")
@Data
public class AliyunsendsgConfig {
    private String accessKeyId;
    private String accessKeySecret;//短信签名名称
    private String SignName;//短信模板ID
    private String templateCode;
}
