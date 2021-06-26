package cc.secondbrain.demo.controller;

import cc.secondbrain.demo.annotation.TimeLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @TimeLog
    @RequestMapping("/")
    public String hello() {
        return "Hello Spring Boot";
    }

}
