package com.yfy.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;




@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
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
