package com.css.consumer.api;

import com.css.consumer.interceptor.CssHttpRequestInterceptor;
import com.css.model.user.CssResultVO;
import com.css.model.user.UserVO;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Collections;

@Api(description = "用户操作接口")
@RestController
@RequestMapping("/user")
public class UserAPI {
    final Logger logger = LoggerFactory.getLogger(UserAPI.class);
    @Autowired
    private RestTemplate restTemplate;
    @Value("${css.provider.host}")
    private String host;
    @Value("${css.provider.port}")
    private String port;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private CssResultVO create(@RequestBody UserVO userVO) {
        final String apiUrl = "/user/create";
        final String apiServicerURL = "http://" + host + ":" + port + "/" + apiUrl;
        logger.info("full url is " + apiServicerURL);
        //final CssResultVO resultVO = restTemplate.postForObject(apiServicerURL, userVO, CssResultVO.class);
        final ResponseEntity<CssResultVO> responseEntity = restTemplate.postForEntity(apiServicerURL, userVO, CssResultVO.class);
        return responseEntity.getBody();
    }
}
