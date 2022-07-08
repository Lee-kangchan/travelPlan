package com.auth.controller;

import com.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author :      lee_kangchan
 * @FileName :    AccountController
 * @Date :        2022/07/07
 * @Discription : Controller
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class AuthController {

    private final AuthService accountService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginDto) {
        LoginResponseDto responseDto = accountService.login(loginDto.getEmail(), loginDto.getPassword());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }


    @GetMapping("/re-issue")
    public ResponseEntity<LoginResponseDto> reIssue(@RequestParam("email") String email, @RequestParam("refreshToken") String refreshToken) {
        LoginResponseDto responseDto = accountService.reIssueAccessToken(email, refreshToken);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
