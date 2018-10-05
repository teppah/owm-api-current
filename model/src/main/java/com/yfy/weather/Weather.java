package com.yfy.weather;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
