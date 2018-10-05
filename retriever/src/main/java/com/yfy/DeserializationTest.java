package com.yfy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yfy.cityutil.CityUtils;
import com.yfy.location.City;
import com.yfy.weather.CurrentConditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Slf4j
public class DeserializationTest {
    public static void main(String[] args) {
        City city = CityUtils.getByID(2172797);
        log.info("city = {}", city);
        try (BufferedReader reader = new BufferedReader(
                new FileReader(
                        ResourceUtils.getFile("classpath:test.json")
                )
        )) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            CurrentConditions conditions = gson.fromJson(reader, CurrentConditions.class);
            log.info("Success? {}", conditions);
        } catch (IOException e) {
            log.info("{}", e);
        }
    }
}
