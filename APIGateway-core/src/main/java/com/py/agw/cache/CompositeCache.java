package com.py.agw.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.Callable;

/**
 * description：缓存管理配置
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/19
 */
public class CompositeCache implements org.springframework.cache.Cache {

    private String name;

    private int timeOut;

    private RedisTemplate redisTemplate;

    private CacheManager ehCacheManager;

    public CompositeCache(String name, int timeOut, RedisTemplate redisTemplate, CacheManager ehCacheManager) {
        this.name = name;
        this.timeOut = timeOut;
        this.redisTemplate = redisTemplate;
        this.ehCacheManager = ehCacheManager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return null;
    }

    @Override
    public ValueWrapper get(Object key) {
        Cache enCache = ehCacheManager.getCache(name);
        String realKey = String.format("%s-%s", name, key);
        Element element = enCache.get(realKey);
        if (element != null) {
            // 类型强制转换
            return element::getObjectValue;
        }
        Object realValue = redisTemplate.opsForValue().get(realKey);

        if (realValue != null) {
            enCache.put(new Element(realKey, realValue));
            return () -> realValue;
        }

        return null;
    }

    @Override
    public <T> T get(Object key, Class<T> aClass) {
        return (T) get(key).get();
    }

    @Override
    public <T> T get(Object key, Callable<T> callable) {
        return (T) get(key).get();
    }

    @Override
    public void put(Object key, Object value) {
        Cache ehCache = ehCacheManager.getCache(name);
        String realKey = String.format("%s-%s", name, key);
        Element element = ehCache.get(realKey);
        if (element == null) {
            element = new Element(realKey, value);
        }
        ehCache.put(element);

        redisTemplate.opsForValue().set(realKey, value);
    }

    @Override
    public void evict(Object o) {

    }

    @Override
    public void clear() {

    }
}
