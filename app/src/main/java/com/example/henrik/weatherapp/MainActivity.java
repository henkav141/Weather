package com.example.henrik.weatherapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henrik.weatherapp.Weather.CityList;
import com.example.henrik.weatherapp.Weather.JSONWeatherParser;
import com.example.henrik.weatherapp.Weather.Weather;
import com.example.henrik.weatherapp.Weather.WeatherHttpClient;

import org.json.JSONException;
import org.w3c.dom.Text;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    private TextView city;
    private TextView temp;
    private TextView desc;
    private ImageView imgView;
    private ImageView btnRandom;
    private TextView hum;
    private TextView press;
    private TextView windSpeed;
    private TextView windDeg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CityList cityList = new CityList();
        String cit = cityList.getRandomCity();
        city = (TextView) findViewById(R.id.textCity);
        temp = (TextView) findViewById(R.id.textTemp);
        desc = (TextView) findViewById(R.id.textDesc);
        imgView = (ImageView) findViewById(R.id.imageView);
        hum = (TextView) findViewById(R.id.hum);
        press = (TextView) findViewById(R.id.press);
        windSpeed = (TextView) findViewById(R.id.windSpeed);
        windDeg = (TextView) findViewById(R.id.windDeg);
        btnRandom = (ImageView) findViewById(R.id.btnRndm);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONWeatherTask task = new JSONWeatherTask();
                task.execute(new String[]{cityList.getRandomCity()});
            }
        });
        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(new String[]{cityList.getRandomCity()});
    }

    private class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... params) {
            Weather weather = new Weather();
            String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));

            try {
                weather = JSONWeatherParser.getWeather(data);

                // Let's retrieve the icon
                weather.iconData = ( (new WeatherHttpClient()).getImage(weather.currentCondition.getIcon()));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return weather;

        }




        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);

             if (weather.iconData != null && weather.iconData.length > 0) {
                Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
                imgView.setImageBitmap(img);
            }

            city.setText(weather.location.getCity() + "," + weather.location.getCountry());
            desc.setText( weather.currentCondition.getDescr());
            temp.setText("" + Math.round((weather.temperature.getTemp() - 273.15)) + " \u2103");
            hum.setText("Hum: "+"" + weather.currentCondition.getHumidity() + "%");
            press.setText("Press: "+"" + weather.currentCondition.getPressure() + " hPa");
            windSpeed.setText("Windespeed: "+"" + weather.wind.getSpeed() + " mps");
            windDeg.setText("Winddeg: "+"" + weather.wind.getDeg() + "\u21AF");

        }
    }
}
