package com.ashwin.java;

import com.ashwin.java.data.source.StudentSource;
import com.ashwin.java.data.source.TeacherSource;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CaffeineDemoConfiguration {
    @Bean
    public Caffeine<Object, Object> caffeineConfig() {
        return Caffeine.newBuilder()
                .initialCapacity(3)
                .maximumSize(5)
                .expireAfterAccess(5, TimeUnit.MINUTES)
                .weakKeys()  // Eligible for removal during GC
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(@Nullable Object key, @Nullable Object value, @NonNull RemovalCause removalCause) {
                        System.out.format("Caffeine removal listener: key: %s | val: %s | cause: %s | evicted: %b\n", key, value, removalCause.toString(), removalCause.wasEvicted());
                    }
                })
                .recordStats();
    }

    @Bean
    public CacheManager cacheManager() {
        Caffeine<Object, Object> caffeine = caffeineConfig();
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("StudentCache", "TeacherCache");
        cacheManager.setCaffeine(caffeine);
        // OR
        //String specAsString = "initialCapacity=100, maximumSize=500, expireAfterAccess=5m, recordStats";
        //cacheManager.setCacheSpecification(specAsString);
        return cacheManager;
    }

    @Bean
    public StudentSource studentSource() {
        return new StudentSource();
    }

    @Bean
    public TeacherSource teacherSource() {
        return new TeacherSource();
    }
}
