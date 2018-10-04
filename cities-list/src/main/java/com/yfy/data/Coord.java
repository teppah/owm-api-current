package com.yfy.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**A class that represents the latitude and longitude coordinates of a {@link City}.
 *
 * @see com.yfy.data.City
 * @see com.yfy.cityutil.CityUtils
 */
@AllArgsConstructor
@Data
@ToString
public class Coord {
    private final double lat;
    private final double lon;
}
