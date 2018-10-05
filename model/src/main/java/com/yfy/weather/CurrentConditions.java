package com.yfy.weather;

import com.yfy.location.Coord;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CurrentConditions {
    private Coord coord;
    private Weather weather;
    private String base;
    private Main main;
    private Clouds clouds;
    private Rain rain;
    private Snow snow;
    private long dt;
    private Sys sys;
    private long id;
    private String name;
    private int cod;
}
