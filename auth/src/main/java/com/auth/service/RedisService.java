package com.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author :      lee_kangchan
 * @FileName :    RedisService
 * @Date :        2022/07/07
 * @Discription : Redis 데이터 접근할 Service
 */
@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate redisTemplate;

    public void setValues(String key, String data) {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set(key, data);
    }

    public void setValues(String key, String data, Duration duration){
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set(key, data, duration);
    }

    public String getValues(String key){
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        return values.get(key);
    }
    public void deleteValues(String key){
        redisTemplate.delete(key);
    }
}
