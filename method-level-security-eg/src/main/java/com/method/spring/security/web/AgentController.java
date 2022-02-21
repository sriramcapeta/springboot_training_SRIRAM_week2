package com.method.spring.security.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
class XyzServices{

    @Secured("ROLE_ANONYMOUS")
    public String anonymous() {
        return "Anonymous Logged in!!!!";
    }

    @Secured("ROLE_ADMIN")
    public String hasAdminRole() {
        return "ADMIN Logged in!!!!";
    }
}


@RestController
@RequestMapping("agent")
public class AgentController {
	@Autowired
	XyzServices xyz;
	
    @GetMapping("anonymous")
    public String anonymous() {
        return xyz.anonymous();
    }

    @GetMapping("has-role")
    public String hasAdminRole() {
        return xyz.hasAdminRole();
    }

}
