package com.android.app.weather.forecast;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.app.weather.forecast.adapter.ListFunctionAdapter;
import com.android.app.weather.forecast.model.InformationFunction;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    public static final String TAG_TP = "ThangPham";

    private ListView listViewFunction;
    private InformationFunction informationFunction;
    private ListFunctionAdapter listFunctionAdapter;
    private List<InformationFunction> listFunction = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView tvDetail = (TextView) findViewById(R.id.tvDetail);
//        Typeface ty = Typeface.createFromAsset(getAssets(), "fonts/TIMESBI.TTF");
//        tvDetail.setTextAppearance(MainActivity.this, R.style.mode_activated);
//        tvDetail.setTypeface(ty);
        listViewFunction = (ListView) findViewById(R.id.listViewFunction);
        listFunctionAdapter = new ListFunctionAdapter(MainActivity.this, R.layout.custom_item_list_main, initDataFuntion());
        listViewFunction.setAdapter(listFunctionAdapter);
    }

    private List<InformationFunction> initDataFuntion() {
        String [] nameFunction = getResources().getStringArray(R.array.name_function_weather);
        int [] imageFuntion = {R.drawable.ic_weathercurrent, R.drawable.ic_weatheranywhere, R.drawable.ic_location, R.drawable.ic_weatherpredict, R.drawable.ic_weathermap};
        for (int i = 0; i < nameFunction.length; i++) {
            informationFunction = new InformationFunction(imageFuntion[i], nameFunction[i]);
            listFunction.add(informationFunction);
        }
        return listFunction;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
