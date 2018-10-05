package com.yfy.location;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


/**A class that represents the latitude and longitude coordinates of a {@link City}.
 *
 * @see com.yfy.location.City
 */
@AllArgsConstructor
@ToString
@Getter
public class Coord {
    private final double lat;
    private final double lon;
}
