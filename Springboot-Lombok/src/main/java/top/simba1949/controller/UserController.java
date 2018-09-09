package top.simba1949.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.common.UserDto;

/**
 * @author simba1949@outlook.com
 * @date 2018/9/9 9:05
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("get")
    public UserDto getUserDto(){
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setUsername("李白");
        userDto.setPassword("666666");

        return userDto;
    }
}
