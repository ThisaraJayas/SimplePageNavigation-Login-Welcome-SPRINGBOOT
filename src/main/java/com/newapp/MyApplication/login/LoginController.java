package com.newapp.MyApplication.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")  // model.put("name",name);
public class LoginController {

    @Autowired
    private AuthenticationService authService;
    @RequestMapping(value = "login", method = RequestMethod.GET) //when loading indefault
    public String gotoLoginPage(){                                // it is get when we submit only post
        return "login";
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){

        if(authService.authenticate(name,password)){
            model.put("name",name);
            model.put("password",password);
            return "welcome";
        }else {
            model.put("errorMessage","Invalid username or password");
            return "login";
        }

    }

}
