package com.bwie.yuel14.until;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:15:29
 *@Description:${DESCRIPTION}
 * */

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bwie.yuel14.app.Appcotion;

public class Until {
    private static final Until ourInstance = new Until();
    private final RequestQueue requestQueue;

    public static Until getInstance() {
        return ourInstance;
    }

    private Until() {
        requestQueue = Volley.newRequestQueue(Appcotion.context);
    }

    public void onget(String url, final MycallBack mycallBack) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mycallBack.onsuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mycallBack.onerror(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public void onpost(String url, final MycallBack mycallBack) {
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mycallBack.onsuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mycallBack.onerror(error.getMessage());
            }
        });
        requestQueue.add(stringRequest);
    }

    public interface MycallBack {
        void onsuccess(String json);

        void onerror(String error);
    }

}
