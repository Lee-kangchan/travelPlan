package com.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author :      lee_kangchan
 * @FileName :    TokenResDto
 * @Date :        2022/07/07
 * @Discription : 토큰 전달할 Dto
 */

@Getter
@AllArgsConstructor
public class TokenResDto {
    private String accessToken;
    private String refreshToken;
}
