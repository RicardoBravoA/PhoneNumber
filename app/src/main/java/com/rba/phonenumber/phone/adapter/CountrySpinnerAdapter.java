package com.rba.phonenumber.phone.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.rba.phonenumber.R;
import com.rba.phonenumber.phone.model.CountryEntity;

/**
 * Created by Ricardo Bravo on 23/02/17.
 */

public class CountrySpinnerAdapter extends ArrayAdapter<CountryEntity> {
    private LayoutInflater mLayoutInflater;

    public CountrySpinnerAdapter(Context context) {
        super(context, 0);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_country, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imgCountry = (AppCompatImageView) convertView.findViewById(R.id.imgCountry);
            viewHolder.lblDescription = (AppCompatTextView) convertView.findViewById(R.id.lblDescription);
            viewHolder.lblCode = (AppCompatTextView) convertView.findViewById(R.id.lblCode);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CountryEntity countryEntity = getItem(position);
        viewHolder.imgCountry.setImageResource(getFlagResource(countryEntity));
        viewHolder.lblDescription.setText(countryEntity.getName());
        viewHolder.lblCode.setText(String.format("+%s", countryEntity.getDialCode()));
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountryEntity countryEntity = getItem(position);

        if (convertView == null) {
            convertView = new ImageView(getContext());
        }

        ((ImageView) convertView).setImageResource(getFlagResource(countryEntity));

        return convertView;
    }

    private int getFlagResource(CountryEntity countryEntity) {
        return getContext().getResources().getIdentifier("country_" + countryEntity.getIso().toLowerCase(), "drawable", getContext().getPackageName());
    }


    private static class ViewHolder {
        public AppCompatImageView imgCountry;
        public AppCompatTextView lblDescription;
        public AppCompatTextView lblCode;
    }
}
