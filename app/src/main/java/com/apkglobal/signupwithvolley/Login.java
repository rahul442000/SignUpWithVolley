package com.apkglobal.signupwithvolley;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    EditText e111,e122;
    Button loginbutton;
    View V;
    String s111,s122;


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        V= inflater.inflate(R.layout.fragment_login, container, false);

        e111=V.findViewById(R.id.edit11);
        e122=V.findViewById(R.id.edit12);
        loginbutton=V.findViewById(R.id.but22);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s111=e111.getText().toString();
                s122=e122.getText().toString();
                login();
            }
        });
        return V;
    }

    public void login() {
        RequestQueue rq = Volley.newRequestQueue(getActivity());
        String url="https://rahulsoni442000.000webhostapp.com/studentbhutan/login.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equalsIgnoreCase("login done succeessfully")) {
                    Toast.makeText(getActivity(), "Login Succeessfully", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getActivity(),BasicActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getActivity(), "Failed"+response.toString(), Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(), "Data Not Register", Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm1=new HashMap<String, String>();
                hm1.put("n",s111);
                hm1.put("p",s122);
                return hm1;

            }
        };
        rq.add(sr);

    }
}
