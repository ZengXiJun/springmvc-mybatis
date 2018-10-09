package com.jesse.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jesse.model.User;
import com.jesse.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;
	
	//RESTful  URL:http://localhost:8080/springweb/user/test?id=1
    @RequestMapping(value="/test",method=RequestMethod.GET)  
    public String test(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        System.out.println("userId:"+userId);
        User user = null;
        if (userId == 1) {
             user = new User();  
             user.setAge(11);
             user.setUserId(1);
             user.setPassword("123");
             user.setUserName("javen");
        }
       
        logger.debug(user.toString());
        model.addAttribute("user", user);  
        return "index";  
    }  
    
    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
    public User findOneUser(@PathVariable("id") Integer id) {
    	return userService.getUserById(id); 
    }
    
    @RequestMapping("/home")
    public String getTest() {
    	return "home";
    }
    
    
    
}

