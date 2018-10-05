package com.yfy.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Wind {
    private double speed;
    private double deg;
}
