package com.yfy.cityutil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yfy.data.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


/**
 *
 *
 */
@Slf4j
public final class CityUtils {
    private static final String CITY_LIST = "city/city.list.json";
    private static final String FROM_PATH = ResourceUtils.CLASSPATH_URL_PREFIX;

    private static final List<City> cities;

    static {
//        Create a new Gson object
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        List<City> tempCityList = null;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(ResourceUtils.getFile(FROM_PATH + CITY_LIST))
        )) {

//            Creates an immutable list of immutable City objects
//            when the class is loaded
            tempCityList = List.of(
                    gson.fromJson(reader, City[].class)
            );

        } catch (IOException e) {
            log.error("FATAL ERROR IN INITIALIZING CityUtils: {}", e);
        } finally {
            // Make sure that the static final cities is assigned to something, even if it's null
//            log.info("Assigned {} to cities list", tempCityList.toString());
            cities = tempCityList;
            log.info("Finished initializing, cities is correctly initialized: {}", cities != null);
        }
    }

    /**
     * Returns an immutable list of {@link City} that are supported in the OpenWeatherMap current weather API.
     *
     * @see com.yfy.data.City
     * */
    public static List<City> getCities() {
        if (cities == null) {
            throw new NullPointerException("cities is null");
        } else {
            return cities;
        }
    }
}
