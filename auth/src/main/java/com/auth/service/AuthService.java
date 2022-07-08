package com.auth.service;

import com.auth.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author :      lee_kangchan
 * @FileName :    AuthService
 * @Date :        2022/07/07
 * @Discription : 인증을 위한 서비스
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;


    public LoginResponseDto login(String email, String password) {
        Account account = accountRepository
                .findByEmail(email).orElseThrow(() -> new BadRequestException("아이디 혹은 비밀번호를 확인하세요."));
        checkPassword(password, account.getPassword());
        String accessToken = jwtProvider.createAccessToken(account.getEmail(), account.getRole());
        String refreshToken = jwtProvider.createRefreshToken(account.getEmail(), account.getRole());
        return new LoginResponseDto(accessToken, refreshToken);
    }

    public LoginResponseDto reIssueAccessToken(String email, String refreshToken) {
        Account account = accountRepository.findByEmail(email).orElseThrow(() -> new BadRequestException("존재하지 않는 유저입니다."));
        jwtProvider.checkRefreshToken(email, refreshToken);
        String accessToken = jwtProvider.createAccessToken(account.getEmail(), account.getRole());
        return new LoginResponseDto(accessToken, refreshToken);
    }

}
