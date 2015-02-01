package com.RFramework.systemManagement.controller;

import com.RFramework.pojo.UserBean;
import com.RFramework.systemManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by wangronghua on 15/1/24.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    @Qualifier("userService") //注释指定注入 Bean
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute UserBean userBean, ModelMap modelMap) {
        boolean isAuthorized = userService.authenticate(userBean);
        if(isAuthorized) {
            modelMap.addAttribute("user", userBean);
            return "../index";
        } else {
            return "redirect:/login";
        }
    }

}
