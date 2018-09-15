package top.simba1949.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.simba1949.common.UserCommon;
import top.simba1949.service.UserService;

import java.util.List;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/15 21:06
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("users")
    public String getUsers(Model model){
        List<UserCommon> list = userService.getAll();
        String str = "君不见黄河之水天上来";

        model.addAttribute("list",list);
        model.addAttribute("str",str);

        return "user/userList";
    }

}
