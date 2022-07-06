package com.travel.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.travel.dto.UserReqDto;
import org.springframework.stereotype.Service;

/**
 * @author :      lee_kangchan
 * @FileName :    UserService
 * @Date :        2022/06/27
 * @Discription : User Micro Service 데이터를 받아오기 위한 Service
 */
@Service
public class UserService {


    @HystrixCommand(commandKey="CUD", fallbackMethod = "getUserFallback")
    public String login(UserReqDto.login login) {
        return "Login Success";
    }

    @HystrixCommand(commandKey="CUD", fallbackMethod = "getUserFallback")
    public String register(UserReqDto.register register) {
        return "Register Success";
    }

    @HystrixCommand(commandKey = "default", fallbackMethod = "getUserFallback")
    public String logout(UserReqDto.logout logout) {
        return "Logout Success";
    }

    @HystrixCommand(commandKey = "default", fallbackMethod = "getUserFallback")
    public String getUserDetail(UserReqDto.userDetail userDetail) {
        return "User Detail Success";
    }

    @HystrixCommand(commandKey = "default", fallbackMethod = "getUserFallback")
    public String getUserList() {
        return "User List Success";
    }

    private String getUserFallback() {
        return "유저 정보를 받아오는 중 오류가 발생했습니다.";
    }

}
