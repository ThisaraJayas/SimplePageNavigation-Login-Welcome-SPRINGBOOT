package com.newapp.MyApplication.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")  // model.put("name",name);
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET) //when loading indefault
    public String gotoWelcomePage(ModelMap model){
        model.put("name","Kamal");// it is get when we submit only post
        return "welcome";
    }

}
