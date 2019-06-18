 package com.apkglobal.signupwithvolley;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity {
Button signs,logs;
FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signs=findViewById(R.id.sign);
        logs=findViewById(R.id.login);
        fm=getSupportFragmentManager();
        signs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.frame,new Signup()).commit();
            }
        });
        logs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.frame,new Login()).commit();
            }
        });
    }
}
