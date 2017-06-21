package com.voyager.core.rest;

import com.voyager.model.entity.User;
import org.springframework.security.core.Authentication;
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
    public String test(Authentication authentication){
        return ((User)authentication.getPrincipal()).getEmail();
    }
}
