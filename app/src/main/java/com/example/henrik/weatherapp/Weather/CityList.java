package com.example.henrik.weatherapp.Weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by HenrikKarlsson on 2016-10-13.
 */

public class CityList {

    private List<String> cityList = new ArrayList<>();

    public CityList(){
        cityList.add("Barcelona");
        cityList.add("Stockholm");
        cityList.add("London");
        cityList.add("NewYork");
        cityList.add("Tokyo");
        cityList.add("Chicago");
        cityList.add("Miami");
        cityList.add("Edinburgh");
        cityList.add("Glasgow");
        cityList.add("Troon");
        cityList.add("Dublin");
        cityList.add("bangkok");
        cityList.add("Lulea");
        cityList.add("Sundsvall");
        cityList.add("Berlin");
        cityList.add("Paris");
        cityList.add("Marseille");
        cityList.add("Madrid");
        cityList.add("Rome");
        cityList.add("Milano");
        cityList.add("lisabon");
        cityList.add("amsterdam");
        cityList.add("Sydney");
        cityList.add("melbourne");
        cityList.add("Sundsvall");
        cityList.add("ankara");
        cityList.add("istanbul");
        cityList.add("edmonton");
        cityList.add("toronto");
        cityList.add("ottawa");
        cityList.add("manchester");
        cityList.add("newcastle,GB");
        cityList.add("liverpool");
        cityList.add("perth");
        cityList.add("prague");
        cityList.add("oslo");
        cityList.add("copenhagen");
        cityList.add("newdehli");
        cityList.add("nairobi");
        cityList.add("hongkong");
        cityList.add("karachi");
        cityList.add("indianapolis");
        cityList.add("jakarta");
        cityList.add("saopaulo");
        cityList.add("riodejaneiro");
        cityList.add("brasilia");
        cityList.add("mexicocity");
        cityList.add("sanfrancisco");
        cityList.add("seattle");
        cityList.add("dallas");
        cityList.add("lasvegas");
        cityList.add("santodomingo");
        cityList.add("lima");
        cityList.add("casablanca");
        cityList.add("capetown");
        cityList.add("cairo");
        cityList.add("athens");
        cityList.add("vancouver");
        cityList.add("seoul");
        cityList.add("moscow");
        cityList.add("denver");
        cityList.add("detroit");
        cityList.add("montreal");
        cityList.add("zurich");
        cityList.add("vienna");
        cityList.add("brussels");
        cityList.add("jerusalem");
        cityList.add("budapest");
        cityList.add("philadelphia");
        cityList.add("phuket");

    }

   public String getRandomCity(){
       Random random = new Random();
       String result = cityList.get(random.nextInt(cityList.size()));
       return result;
   }
}
