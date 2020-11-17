package com.example.currencyconverter;



import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;

public class FixerCurrency extends AppCompatActivity implements CurrencyDAOAble {
    @Override
    public List<Rate> GetRates(String base) {
        String URL = "http://data.fixer.io/api/latest?access_key=48ca2971d2884b38bd4f0653caf81de7";
        RequestQueue queue = Volley.newRequestQueue(FixerCurrency.this);

        String url = "http://my-json-feed";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        textView.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

        return null;

    }


    public List<Rate> GetRates() {
        return null;
    }
}
