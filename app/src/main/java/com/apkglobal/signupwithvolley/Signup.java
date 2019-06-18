package com.apkglobal.signupwithvolley;


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
public class Signup extends Fragment {

    EditText e11,e12,e13;
    Button signbutton;
    View V;
    String s1,s2,s3;



    public Signup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        V= inflater.inflate(R.layout.fragment_signup, container, false);
        e11=V.findViewById(R.id.edit1);
        e12=V.findViewById(R.id.edit2);
        e13=V.findViewById(R.id.edit3);
        signbutton=V.findViewById(R.id.but2);
        signbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e11.getText().toString();
                s2=e12.getText().toString();
                s3=e13.getText().toString();
                register();
            }
        });
    return V;


    }

    public void register() {
        RequestQueue rq = Volley.newRequestQueue(getActivity());
        String url="https://rahulsoni442000.000webhostapp.com/studentbhutan/register.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "Data Register", Toast.LENGTH_SHORT).show();
                e11.setText("");
                e12.setText("");
                e13.setText("");

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
                hm1.put("n",s1);
                hm1.put("p",s2);
                hm1.put("m",s3);
                return hm1;

            }
        };
        rq.add(sr);

    }
}
