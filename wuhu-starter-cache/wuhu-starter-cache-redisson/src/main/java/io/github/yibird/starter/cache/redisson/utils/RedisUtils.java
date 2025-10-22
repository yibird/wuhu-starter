package io.github.yibird.starter.cache.redisson.utils;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.extra.spring.SpringUtil;
import io.github.yibird.starter.core.constant.StringConstants;
import org.redisson.api.*;

import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @Description Redis工具类
 * @Author zchengfeng
 * @Datetime 2025/3/18 2:08
 */
public class RedisUtils {

    private static final RedissonClient CLIENT = SpringUtil.getBean(RedissonClient.class);

    private RedisUtils() {
    }

    /**
     * 格式化键，将各子键用 : 拼接起来
     *
     * @param subKeys 子键列表
     * @return key
     */
    public static String formatKey(String... subKeys) {
        return String.join(StringConstants.COLON, ArrayUtil.removeBlank(subKeys));
    }

    /**
     * 是否存在 key
     */
    public static boolean exists(String key) {
        return CLIENT.getBucket(key).isExists();
    }

    /**
     * 删除 key
     */
    public static boolean delete(String key) {
        return CLIENT.getBucket(key).delete();
    }

    // ===================== 📦 RBucket =====================

    /**
     * 设置缓存值（默认不过期）
     */
    public static <T> void set(String key, T value) {
        CLIENT.getBucket(key).set(value);
    }

    /**
     * 设置缓存值并设置过期时间
     */
    public static <T> void set(String key, T value, Duration duration) {
        CLIENT.getBucket(key).set(value, duration);
    }

    /**
     * 尝试设置缓存值并设置过期时间,返回一个布尔值,表示是否设置成功
     *
     * @param key      key
     * @param value    缓存value
     * @param duration 缓存value
     * @return 返回一个布尔值, 表示是否设置成功
     */
    public static <T> boolean setIfAbsent(String key, T value, Duration duration) {
        RBucket<T> bucket = CLIENT.getBucket(key);
        return bucket.setIfExists(value, duration);
    }

    /**
     * 获取缓存值
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) CLIENT.getBucket(key).get();
    }

    /**
     * 尝试原子设置值(不存在才设置),带过期时间
     */
    public static boolean trySet(String key, String value, Duration duration) {
        return CLIENT.getBucket(key).setIfAbsent(value, duration);
    }

    // ===================== 🗝️ RLock =====================

    /**
     * 获取锁对象
     */
    public static RLock getLock(String lockKey) {
        return CLIENT.getLock(lockKey);
    }

    /**
     * 尝试加锁（带超时）
     */
    public static boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException {
        RLock lock = getLock(lockKey);
        return lock.tryLock(waitTime, leaseTime, unit);
    }

    /**
     * 解锁
     */
    public static void unlock(String lockKey) {
        RLock lock = getLock(lockKey);
        if (lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }

    // ===================== 🗂️ RMap =====================

    /**
     * 获取 map 缓存
     */
    public static <K, V> RMap<K, V> getMap(String key) {
        return CLIENT.getMap(key);
    }

    /**
     * 向 map 中放入数据
     */
    public static <K, V> void putToMap(String key, K mapKey, V mapValue) {
        getMap(key).put(mapKey, mapValue);
    }

    /**
     * 获取 map 中某个值
     */
    public static <K, V> V getFromMap(String key, K mapKey) {
        return (V) getMap(key).get(mapKey);
    }

    // ===================== 📃 RList =====================

    public static <T> RList<T> getList(String key) {
        return CLIENT.getList(key);
    }

    public static <T> void addToList(String key, T value) {
        getList(key).add(value);
    }

    public static <T> void addAllToList(String key, Collection<T> values) {
        getList(key).addAll(values);
    }

    public static <T> T getFromList(String key, int index) {
        return (T) getList(key).get(index);
    }

    // ===================== 🔁 过期相关 =====================

    public static boolean expire(String key, long timeout, TimeUnit unit) {
        return CLIENT.getBucket(key).expire(timeout, unit);
    }

    public static long getExpire(String key) {
        return CLIENT.getBucket(key).getExpireTime();
    }

}
