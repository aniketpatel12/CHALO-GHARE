package com.company.CHALOGHARE;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class devlopers extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    TextView t7;
    TextView t8;
    TextView t9;
    TextView t10;
    TextView t11;
    TextView tt1;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.devlopers);

        t1 = findViewById(R.id.ns1);
        t10=findViewById(R.id.tv7);
        t11=findViewById(R.id.tv8);
        t2 = findViewById(R.id.tv2);
        t3 = findViewById(R.id.tv3);
        t4 = findViewById(R.id.tv4);

        t5 = findViewById(R.id.tv5);
        t6 = findViewById(R.id.tv6);

        Animation an1 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        t1.startAnimation(an1);
        t2.startAnimation(an1);
        t3.startAnimation(an1);
        t4.startAnimation(an1);
        t5.startAnimation(an1);
        t6.startAnimation(an1);
        t10.startAnimation(an1);
        t11.startAnimation(an1);



    }
}
