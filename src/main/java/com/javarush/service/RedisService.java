package com.javarush.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.redis.CityCountry;
import com.javarush.redis.RedisClientHolder;
import io.lettuce.core.KeyValue;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RedisService {

    private final RedisCommands<String, String> commands =
            RedisClientHolder.getConnection().sync();

    private final ObjectMapper mapper = new ObjectMapper();

    public void save(List<CityCountry> cities) {

        for (CityCountry city : cities) {
            try {
                commands.set(
                        String.valueOf(city.getId()),
                        mapper.writeValueAsString(city)
                );
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<CityCountry> get(List<Integer> ids) {

        List<String> keys = ids.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        List<KeyValue<String, String>> values = commands.mget(keys.toArray(new String[0]));

        List<CityCountry> result = new ArrayList<>();

        for (KeyValue<String, String> value : values) {

            if (!value.hasValue()) {
                continue;
            }

            try {
                result.add(mapper.readValue(value.getValue(), CityCountry.class));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
    public List<String> getRaw(List<Integer> ids) {

        List<String> keys = ids.stream()
                .map(String::valueOf)
                .toList();

        return commands.mget(keys.toArray(new String[0]))
                .stream()
                .filter(kv -> kv.hasValue())
                .map(kv -> kv.getValue())
                .toList();
    }

    public List<CityCountry> deserialize(List<String> jsonList) {

        List<CityCountry> result = new ArrayList<>();

        for (String json : jsonList) {
            try {
                result.add(mapper.readValue(json, CityCountry.class));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}