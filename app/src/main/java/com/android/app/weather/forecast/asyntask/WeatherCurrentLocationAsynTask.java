package com.android.app.weather.forecast.asyntask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.android.app.weather.forecast.R;
import com.android.app.weather.forecast.model.OpenWeatherJson;
import com.android.app.weather.forecast.utils.GetImageWeatherAPI;
import com.android.app.weather.forecast.utils.OpenWeatherMapAPI;
import com.android.app.weather.forecast.utils.TypePrediction;

/**
 * Created by pnthang on 10/27/2015.
 */
public class WeatherCurrentLocationAsynTask extends AsyncTask<Void, Void, OpenWeatherJson> {

    private Activity activity;
    private ProgressDialog progressDialog;
    private TypePrediction typePrediction;
    private double lat;
    private double lon;
    private OpenWeatherJson resultJson;
    private Bitmap bitmapWeather;
    private String idIcon = "";

    public WeatherCurrentLocationAsynTask(Activity activity, double lat, double lon) {
        this.activity = activity;
        this.lat = lat;
        this.lon = lon;
        this.typePrediction = TypePrediction.LATITUDE_LONGITUDE;
        progressDialog = new ProgressDialog(activity);
        progressDialog.setTitle(activity.getResources().getString(R.string.loading_data));
        progressDialog.setMessage(activity.getResources().getString(R.string.please_wait));
        progressDialog.setCancelable(true);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.show();
    }

    @Override
    protected OpenWeatherJson doInBackground(Void... voids) {
        if (typePrediction == TypePrediction.LATITUDE_LONGITUDE) {
            resultJson = OpenWeatherMapAPI.predictionJson(lat, lon);
        }
        idIcon = resultJson.getWeather().get(0).getIcon().toString();

        bitmapWeather = GetImageWeatherAPI.getImageWeather(idIcon);
        return resultJson;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(OpenWeatherJson openWeatherJson) {
        super.onPostExecute(openWeatherJson);
    }
}
