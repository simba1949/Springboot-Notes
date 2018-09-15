package top.simba1949.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.simba1949.common.UserCommon;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/16 7:26
 */
@Controller
@RequestMapping
public class UserController {

    @RequestMapping
    public String index(Model model){
        UserCommon userCommon = new UserCommon();
        userCommon.setId(666);
        userCommon.setUsername("李白");

        model.addAttribute("user",userCommon);
        return "Index";
    }

}
