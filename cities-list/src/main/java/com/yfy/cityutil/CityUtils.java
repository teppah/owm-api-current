package com.yfy.cityutil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yfy.location.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


/** A class comprised of static methods to retrieve cities used in OpenWeatherMap's API.
 * It provides an immutable list of cities, provides functionality to find a city or list of cities by:
 * <ul>
 *     <li>Name</li>
 *     <li>ID</li>
 *     <li>Country</li>
 *     <li>Coordinates (still needs to be implemented)</li>
 * </ul>
 * @see City
 */
@Slf4j
public final class CityUtils {
    private static final String CITY_LIST = "city/city.list.json";
    private static final String FROM_PATH = ResourceUtils.CLASSPATH_URL_PREFIX;

    private static final List<City> cities;


//    Initializes the cities static final list
    static {
//        Create a new Gson object
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
        List<City> tempCityList = null;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(ResourceUtils.
                        getFile(FROM_PATH + CITY_LIST))
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
     * @see com.yfy.location.City
     * */
    public static List<City> getCitiesList() {
        if (cities == null) {
            throw new NullPointerException("cities is null");
        } else {
            return cities;
        }
    }

    /** Returns a list of cities matching the name supplied to the method.
     *
     * @param name the name of the city
     * @return a list containing the city or cities that correspond to the {@code name}
     */

    public static List<City> getByName(String name) {
        return cities.stream()
                .filter(city -> city.getName().equalsIgnoreCase(name))
                .collect(Collectors.toUnmodifiableList());
    }

    /** Returns the city matching the ID supplied.
     *
     *
     * @param id the ID of the city
     * @return the corresponding {@code City} object, or {@code null} if ID does not match any city
     */

    public static City getByID(long id) {
        List<City> c = cities.stream()
                .filter(city -> city.getId() == id)
                .collect(Collectors.toList());
        if (c.size() == 1) {
            return c.get(0);
        } else {
            return null;
        }
    }

    /** Returns a list of cities matching the name and country code supplied.
     *
     * @param name the name of the city
     * @param countryCode the country code
     * @return a list containing cities that correspond to the {@code name} and {@code country} code
     */

    public static List<City> getByNameAndCountry(String name, String countryCode) {
        return cities.stream()
                .filter(city -> city.getName().equalsIgnoreCase(name) && city.getCountry().equalsIgnoreCase(countryCode))
                .collect(Collectors.toUnmodifiableList());
    }

}
