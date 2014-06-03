package com.keqiaokeji.tezizai.common.cache.Jedis;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 集群Redis服务管理
 * Created by keqiaokeji on 14-5-21.
 */
public class JedisSharedTools {

    /**
     * 集群服务
     */
    private ShardedJedisPool shardedJedisPool;


    public void set(String key, String value) {
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        shardedJedis.set(key, value);
        shardedJedisPool.returnResource(shardedJedis);
    }

    public ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }

    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }
}
