package com.auth.repository;

import com.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author :      lee_kangchan
 * @FileName :    AuthRepository
 * @Date :        2022/07/07
 * @Discription : Auth 데이터를 불러오기 위한  Repository
 */
public interface AuthRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}

