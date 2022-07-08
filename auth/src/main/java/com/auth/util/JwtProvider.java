package com.auth.util;

import com.auth.service.RedisService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Duration;
import java.util.Date;

/**
 * @author :      lee_kangchan
 * @FileName :    JwtUtil
 * @Date :        2022/07/07
 * @Discription : JWT 유틸 도구
 */
@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final CustomAccountDetailsService customAccountDetailsService;
    private final RedisService redisService;
    @Value("${jwt.secret}")
    private String secretKey;

    public String createAccessToken(String userId, String roles) {
        Long tokenInvalidTime = 1000L * 60 * 3; // 3m
        return this.createToken(userId, roles, tokenInvalidTime);
    }

    public String createRefreshToken(String userId, String roles) {
        Long tokenInvalidTime = 1000L * 60 * 60 * 24; // 1d
        String refreshToken = this.createToken(userId, roles, tokenInvalidTime);
        redisService.setValues(userId, refreshToken, Duration.ofMillis(tokenInvalidTime));
        return refreshToken;
    }


    public void checkRefreshToken(String userId, String refreshToken) {
        String redisRT = redisService.getValues(userId);
        if (!refreshToken.equals(redisRT)) {
            throw new BadRequestException("토큰이 만료되었습니다.");
        }
    }

    private String createToken(String userId, String roles, Long tokenInvalidTime){
        Claims claims = Jwts.claims().setSubject(userId); // claims 생성 및 payload 설정
        claims.put("roles", roles); // 권한 설정, key/ value 쌍으로 저장
        Date date = new Date();
        return Jwts.builder()
                .setClaims(claims) // 발행 유저 정보 저장
                .setIssuedAt(date) // 발행 시간 저장
                .setExpiration(new Date(date.getTime() + tokenInvalidTime)) // 토큰 유효 시간 저장
                .signWith(SignatureAlgorithm.HS256, secretKey) // 해싱 알고리즘 및 키 설정
                .compact(); // 생성
    }
}
