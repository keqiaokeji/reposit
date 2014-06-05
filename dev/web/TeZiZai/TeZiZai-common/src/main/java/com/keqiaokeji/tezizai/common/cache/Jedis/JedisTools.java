package com.keqiaokeji.tezizai.common.cache.Jedis;

import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.utils.JsonUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 当个Redis服务管理
 * Created by keqiaokeji on 14-5-21.
 */
public class JedisTools {

    /**
     * 单个Redia服务的链接池
     */
    private JedisPool jedisPool;


    public void setString(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
        jedisPool.returnResource(jedis);
    }

    /**
     * 向redis中设置值
     *
     * @param key     键
     * @param value   值
     * @param timeout 超时时间（以秒为单位）
     */
    public void setString(String key, String value, long timeout) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value, "XX", "EX", timeout);
        jedisPool.returnResource(jedis);
    }

    public String getString(String key) {
        String result = null;
        Jedis jedis = jedisPool.getResource();
        result = jedis.get(key);
        jedisPool.returnResource(jedis);
        return result;
    }

    public void setObject(String key, Object value) {
        String valueContent = JsonUtils.toJSONString(value);
        setString(key, valueContent);
    }

    /**
     * 向redis中设置值
     *
     * @param key     键
     * @param value   值
     * @param timeout 超时时间（以秒为单位）
     */
    public void setObject(String key, Object value, long timeout) {
        String valueContent = JsonUtils.toJSONString(value);
        setString(key, valueContent, timeout);
    }

    public <T> T getObject(String key, Class<T> clazz) {
        String value = getString(key);
        if (StringUtils.isNotBlank(value)) {
            return JsonUtils.parseObject(value, clazz);
        } else {
            return null;
        }
    }

    /**
     * 为指定键设置超时时长
     *
     * @param key     键
     * @param timeout 超时时长（单位为秒）
     */
    public void expireAt(String key, long timeout) {
        Jedis jedis = jedisPool.getResource();
        jedis.expireAt(key, timeout);
        jedisPool.returnResource(jedis);
    }

    /**
     * 判断一个键是否存在
     *
     * @param key 键
     * @return true：存在，false：不存在
     */
    public boolean exits(String key) {
        boolean result = false;
        Jedis jedis = jedisPool.getResource();
        result = jedis.exists(key);
        jedisPool.returnResource(jedis);
        return result;
    }

    /**
     * 判断一个键是否存在，如果存在则重新设置超时时长
     *
     * @param key     键
     * @param timeout 超时时长
     * @return true：存在，false：不存在
     */
    public boolean exitsAndSetTimeout(String key, long timeout) {
        boolean result = false;
        Jedis jedis = jedisPool.getResource();
        result = jedis.exists(key);
        if (result) {
            jedis.expireAt(key, timeout);
        }
        jedisPool.returnResource(jedis);
        return result;
    }


    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
