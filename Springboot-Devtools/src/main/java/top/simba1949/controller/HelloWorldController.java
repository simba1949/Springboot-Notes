package top.simba1949.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 10:21
 */
@RestController
@RequestMapping("hello")
public class HelloWorldController {

    @RequestMapping("sayhi")
    public String sayHi(){
        return "Hi";
    }

    @RequestMapping("sayhello")
    public String sayHello(){
        return "Hello";
    }

}
