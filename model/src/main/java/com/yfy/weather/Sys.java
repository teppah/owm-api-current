package com.yfy.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Sys {
    private int type;
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;
}
