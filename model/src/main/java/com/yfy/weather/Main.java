package com.yfy.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Main {
    private double temp;
    private double pressure;
    private double humidity;
    private double temp_min;
    private double temp_max;
    private double sea_level;
    private double grnd_level;
}
