package com.android.app.weather.forecast.utils;

import android.util.Log;

import com.android.app.weather.forecast.MainActivity;
import com.android.app.weather.forecast.model.OpenWeatherJson;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pnthang on 10/27/2015.
 */
public class OpenWeatherMapAPI {

    /**
     * A method to download json data from url and convert it to OpenWeatherJson object
     * http://api.openweathermap.org/data/2.5/weather?lat=10.761436&lon=106.6810284&appid=c32e07be338b928d2f5484bb9ede6e15
     *
     * @param lat
     * @param lon
     * @return
     */
    private static String linkUrl = "";
    private static String dataJson = "";
    private static InputStream inputStream = null;
    private static HttpURLConnection httpURLConnection = null;
    private static OpenWeatherJson openWeatherJson = null;

    /**
     * get weather forecast follow lat, lon
     * @param lat latitude of current position
     * @param lon longitude of current position
     * @return
     */
    public static OpenWeatherJson predictionJson(double lat, double lon) {
        linkUrl = LinksAPI.LINK_OPEN_WEATHER +
                LinksAPI.LATITUDE +
                LinksAPI.EQUAL_CHARACTER +
                lat +
                LinksAPI.AND_CHARACTER +
                LinksAPI.LONGITUDE +
                LinksAPI.EQUAL_CHARACTER +
                lon +
                LinksAPI.AND_CHARACTER +
                LinksAPI.APP_ID +
                LinksAPI.EQUAL_CHARACTER +
                LinksAPI.API_KEY;
        Log.d(MainActivity.TAG_TP, "OpenWeatherMapAPI >> predictionJson >> linkUrl: " + linkUrl);
        try {
            URL url = new URL(linkUrl);
            // Create http connection to communicate with url
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            // Connect to url
            httpURLConnection.connect();
            // Read data json from url
            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            dataJson = stringBuffer.toString();

            bufferedReader.close();
            Log.d(MainActivity.TAG_TP, "OpenWeatherMapAPI >> predictionJson >> dataJson: " + dataJson);
            openWeatherJson = new Gson().fromJson(dataJson, OpenWeatherJson.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return openWeatherJson;
    }
}
