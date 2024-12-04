package com.shuting.seckillproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.shuting.seckillproject.mapper")
@EnableCaching //开启声明式缓存，利用注解进行redis读写
@EnableScheduling
public class SeckillProjectApplication {
    //修改默认的redisTemplate持久化方式
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //设置value的序列化方式为JSON
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //设置key的序列化方式为String
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    };
    public static void main(String[] args) {
        SpringApplication.run(SeckillProjectApplication.class, args);
    }

}
