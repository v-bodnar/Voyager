package com.voyager.core.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by volodymyr.bodnar on 6/19/2017.
 */
@Controller
@RequestMapping( value = "/test" )
public class TestController {
    @RequestMapping( value = "/", method = RequestMethod.GET )
    @ResponseBody
    public String test(){
        return "test";
    }
}
