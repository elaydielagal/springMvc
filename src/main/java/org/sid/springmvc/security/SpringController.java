package org.sid.springmvc.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {

    @GetMapping(path = "/notAuthorized")
    protected String error(){
        return "notAuthorized";
    }

}
