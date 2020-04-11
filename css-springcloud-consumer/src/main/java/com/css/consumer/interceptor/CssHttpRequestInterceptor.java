package com.css.consumer.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @Title Http请求拦截器
 */
@Component
public class CssHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(CssHttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logger.info("load ClientHttpRequestInterceptor! ");
        HttpHeaders headers = httpRequest.getHeaders();
        final String token = StringUtils.isEmpty(headers.get("token"))?"token nullL":String.valueOf(headers.get("token"));
        // 加入自定义字段
        headers.add("token", "1000010000");
        // 保证请求继续被执行
        return execution.execute(httpRequest, body);
    }
}
