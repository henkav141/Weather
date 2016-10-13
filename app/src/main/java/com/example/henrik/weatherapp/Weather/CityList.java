package com.example.henrik.weatherapp.Weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by HenrikKarlsson on 2016-10-13.
 */

public class CityList {

    private List<String> cityList = new ArrayList<>();


   public String getRandomCity(){
       cityList.add("Barcelona");
       cityList.add("Stockholm");
       cityList.add("London");
       cityList.add("NewYork");
       cityList.add("Tokyo");

       Random random = new Random();

                  String as = cityList.get(random.nextInt(cityList.size()));

       return as;
   }
}
