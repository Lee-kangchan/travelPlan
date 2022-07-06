package com.travel.dto;

import lombok.*;

/**
 * @author :      lee_kangchan
 * @FileName :    UserReqDto
 * @Date :        2022/06/27
 * @Discription : 유저가 응답받을 Dto
 */

@Getter
@Builder
public class UserReqDto {


    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class login{
        private String id;
        private String pwd;
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class register{
        private String id;
        private String pwd;
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class logout{
        private String id;
        private String pwd;
    }

    @Getter
    @Builder
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class userDetail{
        private String id;
        private String pwd;
    }

}
