package com.example.t_helper21.rest;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.t_helper21.domain.Problem;

import java.util.HashMap;
import java.util.Map;

public class ProblemApiVolley implements ProblemApi{

    private final Context context;
    public static final String BASE_URL= "http://192.168.1.104:8081";
    public static final String API_TEST = "API_TEST";
    private Response.ErrorListener errorListener;

    public ProblemApiVolley(Context context) {
        this.context = context;
    }

    @Override
    public void addProblem(Problem problem) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String url = BASE_URL + "/problem";

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(API_TEST, response);
                    }
                },
                errorListener
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Log.e("fdgdf", "проблема:" + problem.toString());

                Map<String, String> params = new HashMap<>();
                params.put("nameProblem", problem.getName());
                params.put("namePerson", problem.getPerson().getName());
                params.put("surnamePerson", problem.getPerson().getSurname());
                params.put("room_number", String.valueOf(problem.getPerson().getRoom_number()));
                params.put("bed_number", String.valueOf(problem.getPerson().getBed_number()));

                return params;
            }
        };

        requestQueue.add(request);

    }
}
