package com.yfy.location;

import lombok.*;


/**
 * Represents a city that is supported in OpenWeatherMap's current weather API.
 * The class contains an {@code id}, the {@code name} of the city, the {@code country} it is in and its {@link Coord}.
 * The overridden {@link #equals(Object)} method uses the unique {@code id} of each city.
 * The {@link #compareTo(City)} compares the names of the cities, although future implementations might change that.
 */
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Getter
public class City implements Comparable<City> {
    private final long id;
    private final String name;
    private final String country;
    private final Coord coord;

    @Override
    public int compareTo(City o) {
        return name.compareTo(o.getName());
    }
}
