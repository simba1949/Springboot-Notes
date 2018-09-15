package top.simba1949.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/15 21:46
 */
@Controller
@RequestMapping
public class Page2PageController {

    @RequestMapping
    public String index(){
        return "Index";
    }

}
