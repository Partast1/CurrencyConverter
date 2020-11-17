package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  CurrencyPresenter.View {
    String baseCurrency = "DK";
    String ConvertTo = "EUR";
    Button getCurrencies_Button;
    TextView AmountTextView;
    Spinner currencySpinner;
    ListView currencyListView;
    ArrayList<Rate> rates = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CurrencyPresenter cPresenter = new CurrencyPresenter(this);

//         getCurrencies_Button = new Button()

        //Henter rates liste og typecaster til Arraylist, sætter derefter Listviewet
        rates = (ArrayList<Rate>) GetCurrencyData("hej");
        AdapterRate rateAdapter = new AdapterRate(this, rates);
        ListView cListView = findViewById(R.id.currencyListView);
        cListView.setAdapter(rateAdapter);

        //Henter navne og skriver dem i spinneren
        Spinner cSpinner = findViewById(R.id.currencySpinner);
        List<String> names = GetNames(rates);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, names);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cSpinner.setAdapter(adapter2);



//        cSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Rate rate = (Rate) parent.getSelectedItem();
//                displayUserData(rate);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });


    }
    private List<Rate> GetCurrencyData(String text){
        List<Rate> rates;
        MockCurrency mockCurrency = new MockCurrency();
        rates = mockCurrency.GetRates(text);
        return rates;
    }
    private List<String> GetNames(ArrayList<Rate> rates){
        List<String> countries = new ArrayList<>();
        for (Rate var : rates){
            countries.add(var.getName());
        }
        return countries;
    }
//    private void displayRateData(Rate rate) {
//        String name = rate.getName();
//        double Rate = rate.getSpotRate();
//        String rateData = "Name: " + name + "\nSpotrate: " + Rate;
//        Toast.makeText(this, rateData, Toast.LENGTH_LONG).show();
//    }

    @Override
    public List<Rate> GetRates() {
        return null;
    }
}