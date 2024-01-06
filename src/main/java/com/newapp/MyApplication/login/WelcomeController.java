package com.newapp.MyApplication.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;


@Controller
@SessionAttributes("name")  // model.put("name",name);
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET) //when loading indefault
    public String gotoWelcomePage(ModelMap model){
        model.put("name",getLoggedInUsername());// it is get when we submit only post
        return "welcome";
    }
    private String getLoggedInUsername(){
        Authentication authenticaton = SecurityContextHolder.getContext().getAuthentication();
        return authenticaton.getName();
    }

}
