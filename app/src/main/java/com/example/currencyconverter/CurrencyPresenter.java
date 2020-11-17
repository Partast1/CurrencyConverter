package com.example.currencyconverter;

import android.view.View;

import java.util.List;

public class CurrencyPresenter {

    public CurrencyPresenter(View v){
        View w = v;
    }

    public interface View{
        public List<Rate> GetRates();
    }
}
