package com.css.provider.api;


import com.css.model.user.CssResultVO;
import com.css.model.user.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Api(description = "用户操作接口")
@RestController
@RequestMapping("/user")
public class UserAPI {
    final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    /**
     * @param userVO 用户信息
     * @return 新增用户信息
     * @name 新增用户方法
     * @author liwei
     * @date 2020-04-09
     */
    @ApiOperation(value = "添加用户", notes="添加用户信息")
    //@ApiImplicitParam(name = "userVO", value = "用户信息VO", required = true)
    @RequestMapping(value = "/create", method= RequestMethod.POST)
    private CssResultVO create(@RequestBody UserVO userVO) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        final String token  = request.getHeader("token");
        logger.info("token"+token);
        logger.info("userName is " + userVO.getUserName());
        return CssResultVO.success(userVO);
    }
}
