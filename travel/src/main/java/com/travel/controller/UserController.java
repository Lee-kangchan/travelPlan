package com.travel.controller;

import com.travel.dto.UserReqDto;
import com.travel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :      lee_kangchan
 * @FileName :    UserController
 * @Date :        2022/06/27
 * @Discription : 유저 Controller
 */

@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/get/list")
    public String getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/get/detail")
    public String getUserDetail(UserReqDto.userDetail userDetail) {
        return userService.getUserDetail(userDetail);
    }

    @GetMapping("/login")
    public String login(UserReqDto.login login) {
        return userService.login(login);
    }

    @GetMapping("/register")
    public String signup(UserReqDto.register register) {
        return userService.register(register);
    }

    @GetMapping("/logout")
    public String logout(UserReqDto.logout logout) {
        return userService.logout(logout);
    }
}
