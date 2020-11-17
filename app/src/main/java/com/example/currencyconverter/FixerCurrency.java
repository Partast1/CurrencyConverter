package com.example.currencyconverter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class FixerCurrency implements CurrencyDAOAble {
    @Override
    public List<Rate> GetRates(String base) {
        RequestQueue queue = Volley.newRequestQueue(activity_main);

        return null;

    }
}
