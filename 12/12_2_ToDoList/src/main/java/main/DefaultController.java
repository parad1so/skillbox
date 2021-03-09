package main;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DefaultController {
    @RequestMapping("/")
    public String index() {
        return (int) (Math.random() * 100) + " random   date:" + (new Date()).toString();
    }
}