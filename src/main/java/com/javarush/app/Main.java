package com.javarush.app;

import com.javarush.redis.RedisClientHolder;
import io.lettuce.core.api.sync.RedisCommands;

public class Main {

    public static void main(String[] args) {

        RedisCommands<String, String> commands =
                RedisClientHolder.getConnection().sync();

        commands.set("test", "Hello Redis");

        System.out.println(commands.get("test"));

        RedisClientHolder.shutdown();
    }
}