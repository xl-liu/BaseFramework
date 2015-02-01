package com.RFramework.common.controller;

/**
 * Created by wangronghua on 15/1/24.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("/login")
    public String login() {
        return "/main/login";
    }

}
