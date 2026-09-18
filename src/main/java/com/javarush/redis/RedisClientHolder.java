package com.javarush.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

public class RedisClientHolder {

    private static final RedisClient REDIS_CLIENT =
            RedisClient.create("redis://localhost:6379");

    private static final StatefulRedisConnection<String, String> CONNECTION =
            REDIS_CLIENT.connect();

    private RedisClientHolder() {
    }

    public static StatefulRedisConnection<String, String> getConnection() {
        return CONNECTION;
    }

    public static void shutdown() {
        CONNECTION.close();
        REDIS_CLIENT.shutdown();
    }
}