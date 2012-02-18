package com.vyre.notivyre.redis;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 */
public class RedisClient {

    private Jedis jedis;

    public RedisClient(String host) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(host));
        jedis = new Jedis(host);
    }

    public void publish(String channel, String message) {
        jedis.publish(channel, message);
    }

    public void subscribe(JedisPubSub jedisPubSub, String channel) {
        jedis.subscribe(jedisPubSub,channel);
    }
}
