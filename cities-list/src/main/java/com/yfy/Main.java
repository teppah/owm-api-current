package com.yfy;

import com.yfy.cityutil.CityUtils;

public class Main {
    public static void main(String[] args) {
//        List<City> cities = CityUtils.getCitiesList();
//        cities.stream()
//                .filter(city -> city.getCountry().equalsIgnoreCase("CA"))
//                .sorted()
//                .forEach(System.out::println);
        System.out.println(CityUtils.getByID(6089694));
    }
}
