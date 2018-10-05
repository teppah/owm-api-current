package com.yfy.weather;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Wind {
    private double speed;
    private double deg;
}
