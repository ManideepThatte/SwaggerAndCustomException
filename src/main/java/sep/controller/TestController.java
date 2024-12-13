package sep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/welcome")
    public String hello(){
        return "welcome to SpringBoot Application";
    }

    @GetMapping("/number")
    public int integer(){
        return 100;
    }

}
