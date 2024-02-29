package com.example.staticfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("ayush1");

        Button btn1,btn2,btn3;

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        creatfn(new f2(),0);
        System.out.println("ayush2");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatfn(new f1(),1);
                System.out.println("ayush 3");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatfn(new f2(),2);
                System.out.println("ayush 4");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               creatfn(new f3(),3);
                System.out.println("ayush 5");
            }
        });

        System.out.println("ayush 6");

    }

    public void creatfn(Fragment fragment, int flag)
    {
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction ft = fragManager.beginTransaction();
        ft.add(R.id.frame,fragment);
        ft.commit();
    }
}