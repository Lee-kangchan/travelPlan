package com.auth.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

/**
 * @author :      lee_kangchan
 * @FileName :    Member
 * @Date :        2022/07/07
 * @Discription : Member 엔티티
 */

@Entity
@Table(name = "Members")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    private String role = "ROLE_USER";

    public static User of(String email, String nickname, String password) {
        return User.builder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .build();
    }
}
