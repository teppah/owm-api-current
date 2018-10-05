package com.yfy.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
