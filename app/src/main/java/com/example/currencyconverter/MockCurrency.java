package com.example.currencyconverter;

import java.util.ArrayList;
import java.util.List;
/*
*Creates and returns dummy data
*
 */
public class MockCurrency implements CurrencyDAOAble {
    @Override
    public List<Rate> GetRates(String base) {
        List<Rate> rates = new ArrayList<Rate>();
        Rate rate = new Rate("DKK",7.446848);
        Rate rate2 = new Rate("EUR",1);
        rates.add(rate);
        rates.add(rate2);
        return rates;
    }
}
