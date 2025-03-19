package application.petsybackend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test1")
    public String hello(){
        return "Hey";
    }

    @GetMapping("/test2")
    public String test2(){
        return "Hey";
    }
}
