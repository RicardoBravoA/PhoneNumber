package com.rba.phonenumber.phone;

import android.content.Context;

import com.rba.phonenumber.R;
import com.rba.phonenumber.phone.model.CountryEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Ricardo Bravo on 23/02/17.
 */

public class CountryFetch {
    private static CountryList mCountries;

    private static String getJsonFromRaw(Context context, int resource) {
        String json;
        try {
            InputStream inputStream = context.getResources().openRawResource(resource);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static CountryList getCountries(Context context) {
        if (mCountries != null) {
            return mCountries;
        }
        mCountries = new CountryList();
        try {
            JSONArray countries = new JSONArray(getJsonFromRaw(context, R.raw.countries));
            for (int i = 0; i < countries.length(); i++) {
                try {
                    JSONObject country = (JSONObject) countries.get(i);
                    mCountries.add(new CountryEntity(country.getString("name"), country.getString("iso2"), country.getInt("dialCode")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mCountries;
    }


    public static class CountryList extends ArrayList<CountryEntity> {

        public int indexOfIso(String iso) {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getIso().toUpperCase().equals(iso.toUpperCase())) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unused")
        public int indexOfDialCode(int dialCode) {
            for (int i = 0; i < this.size(); i++) {
                if (this.get(i).getDialCode() == dialCode) {
                    return i;
                }
            }
            return -1;
        }
    }
}