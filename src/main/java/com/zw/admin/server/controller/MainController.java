package com.zw.admin.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: boot-backend <br>
 * @Date: 2019-04-04 9:27 <br>
 * @Author: lvxh <br>
 * @Description: <br>
 */
@Api(tags = "登陆")
@RequestMapping
public class MainController {
    @ApiOperation(value = "登录")
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
}
