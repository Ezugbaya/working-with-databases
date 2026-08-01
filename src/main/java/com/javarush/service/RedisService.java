package com.javarush.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.dto.CountryDto;
import com.javarush.redis.RedisClientHolder;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.List;

public class RedisService {

    private final RedisCommands<String, String> commands =
            RedisClientHolder.getConnection().sync();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void saveCountries(List<CountryDto> countries) throws JsonProcessingException {

        String json = objectMapper.writeValueAsString(countries);

        commands.set("countries", json);
    }

    public List<CountryDto> getCountries() throws JsonProcessingException {

        String json = commands.get("countries");

        return objectMapper.readValue(
                json,
                new TypeReference<List<CountryDto>>() {
                }
        );
    }
}