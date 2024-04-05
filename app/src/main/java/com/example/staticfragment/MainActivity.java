package com.example.staticfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1, btn2, btn3;

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        creatfn(new f2(),0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatfn(new f1(),0);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatfn(new f2(),1);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatfn(new f3(),0);
            }
        });
    }

    public void creatfn(Fragment fragment, int flag) {
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction ft = fragManager.beginTransaction();

        if(flag==0) {
            ft.replace(R.id.frame, fragment);
            fragManager.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);
        }
        else{
            ft.replace(R.id.frame, fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
    }
    private static final String ROOT_FRAGMENT_TAG = "root_fragment";
}
