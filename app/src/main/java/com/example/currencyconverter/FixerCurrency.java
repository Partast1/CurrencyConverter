package com.example.currencyconverter;



import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FixerCurrency extends AppCompatActivity implements CurrencyDAOAble {
    @Override
    public List<Rate> GetRates(String base) {
        final List<Rate> rates = new ArrayList<>();
        String URL = "http://data.fixer.io/api/latest?access_key=48ca2971d2884b38bd4f0653caf81de7";
        RequestQueue queue = Volley.newRequestQueue(FixerCurrency.this);

        StringRequest request = new StringRequest(Request.Method.GET, URL, response -> {
            try {
                JSONObject object=new JSONObject(response);
                JSONArray array=object.getJSONArray("rates");
                for(int i=0;i<array.length();i++) {
                    JSONObject object1=array.getJSONObject(i);
                    String name =object1.getString("name");
                    String spotRate =object1.getString("spotrate");
                    double dRate = double.valueOf(spotRate);

                    // lav spotrate om til (double)
                    rates.add(new Rate(name, spotRate));
                }
                textView.setText("email: "+list.get(0).email+ " \nname: "+list.get(0).name);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",error.toString());
            }
        });

//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
//                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                    Log.e("Rest response", response.toString());
//                    }
//                }, error -> {
//                    // TODO: Handle error
//
//                });
            queue.add(jsonObjectRequest);
        return null;

    }


    public List<Rate> GetRates() {
        return null;
    }
}
