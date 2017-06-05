package com.android.app.weather.forecast.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.app.weather.forecast.R;
import com.android.app.weather.forecast.model.InformationFunction;

import java.util.List;

/**
 * Created by pnthang on 10/26/2015.
 */
public class ListFunctionAdapter extends BaseAdapter {

    private Context context;
    private int mLayoutId;
    private List<InformationFunction> listFunction;
    private Typeface typeTIMESBI;

    public ListFunctionAdapter(Context context, int mLayoutId, List<InformationFunction> listFunction) {
        this.context = context;
        this.mLayoutId = mLayoutId;
        this.listFunction = listFunction;
        typeTIMESBI = Typeface.createFromAsset(context.getAssets(), "fonts/TIMESBI.TTF");
    }


    @Override
    public int getCount() {
        return listFunction.size();
    }

    @Override
    public Object getItem(int position) {
        return listFunction.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolderFuntion viewHolder;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(mLayoutId, null, false);
            viewHolder = new ViewHolderFuntion(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderFuntion) convertView.getTag();
        }
        viewHolder.icon.setImageResource(listFunction.get(position).getIcon());
        viewHolder.nameFunction.setText(listFunction.get(position).getNameFunction());
        viewHolder.nameFunction.setTypeface(typeTIMESBI);
        return convertView;
    }

    static class ViewHolderFuntion {

        private ImageView icon;
        private TextView nameFunction;

        public ViewHolderFuntion(View view) {
            icon = (ImageView) view.findViewById(R.id.imgWeatherForecast);
            nameFunction = (TextView) view.findViewById(R.id.tvWeatherForecast);
        }
    }
}
