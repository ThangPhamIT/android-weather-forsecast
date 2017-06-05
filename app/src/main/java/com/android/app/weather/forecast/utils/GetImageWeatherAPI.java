package com.android.app.weather.forecast.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pnthang on 10/27/2015.
 */
public class GetImageWeatherAPI {

    private static String urlIcon = "";
    private static URL urlImage = null;
    private static Bitmap bitmap = null;
    private static InputStream streamImage = null;
    private static HttpURLConnection urlConnectionImage = null;

    /**
     * get image of weather
     * @param idIcon
     * @return
     */
    public static Bitmap getImageWeather(String idIcon) {
        urlIcon = LinksAPI.LINK_OPEN_IMAGE_WEATHER + idIcon + LinksAPI.EXTEND_IMAGE;
        try {
            urlImage = new URL(urlIcon);
            urlConnectionImage = (HttpURLConnection) urlImage.openConnection();
            urlConnectionImage.setDoInput(true);
            urlConnectionImage.connect();
            streamImage = urlConnectionImage.getInputStream();
            // Convert to bitmap
            bitmap = BitmapFactory.decodeStream(streamImage);

            streamImage.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
