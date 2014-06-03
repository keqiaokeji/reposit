package com.keqiaokeji.tezizai.common.cache.Jedis;

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


    public void set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
        jedisPool.returnResource(jedis);
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
