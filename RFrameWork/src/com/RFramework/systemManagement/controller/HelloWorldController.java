package com.RFramework.systemManagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wangronghua on 15/1/24.
 */
@Controller
public class HelloWorldController {

    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/helloworld/{id}")
    public String hello(@PathVariable String id,
                        @RequestParam(value = "name",required = false) String name) {
        logger.debug("id:{},name:{}", id, name);
        return "/sample/helloworld";
    }
}
