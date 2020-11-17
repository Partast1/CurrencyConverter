package com.example.currencyconverter;

import java.util.List;

public interface CurrencyDAOAble {

List<Rate> GetRates(String base);
}
