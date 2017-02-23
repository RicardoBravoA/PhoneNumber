package com.rba.phonenumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.rba.phonenumber.phone.PhoneNumber;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_phone_input)
    PhoneNumber my_phone_input;
    @BindView(R.id.btnValidate) AppCompatButton btnValidate;
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);



    }

    @OnClick(R.id.btnValidate)
    public void onClickValidate(){
        String myInternationalNumber;
        if(my_phone_input.isValid()) {
            myInternationalNumber = my_phone_input.getNumber();
            Log.i("z- number", "válido");
            Log.i("z- number", myInternationalNumber);
        }else{
            Log.i("z- number", "no válido");
        }


    }


}
