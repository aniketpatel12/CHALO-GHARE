package com.company.CHALOGHARE;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class MainActivity extends AppCompatActivity {

/*
       private TextView apname;
       private final int SPLASH_DISPLAY_LENGTH = 3150;

*/
    private ViewPager mslideviewpager;
    private LinearLayout mdotlayout;

    private slideradapter slideradapter;
    private TextView[] mdots;
    private int curpage;
    Button backbtn;
    Button nextbtn;
    Button skipbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nextbtn=findViewById(R.id.btn_next);
        backbtn=findViewById(R.id.btn_back);
        skipbtn=findViewById(R.id.btn_skip);

        mslideviewpager=findViewById(R.id.slideviewpager);
        mdotlayout=findViewById(R.id.dotsLayout);

        slideradapter =  new slideradapter(this);
        mslideviewpager.setAdapter(slideradapter);

        adddotsindicater(0);

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), MainHomeActivity.class);
                startActivity(a);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mslideviewpager.setCurrentItem(curpage + 1);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mslideviewpager.setCurrentItem(curpage-1);

            }
        });

        mslideviewpager.addOnPageChangeListener(viewlistner);
    }

    public void adddotsindicater(int position){

        mdots = new TextView[4];
        mdotlayout.removeAllViews();
        for(int i=0;i<mdots.length;i++){

            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226"));
            mdots[i].setTextSize(40);
            mdots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            mdotlayout.addView(mdots[i]);

        }
        if(mdots.length > 0){
            mdots[position].setTextColor(getResources().getColor(R.color.colorAppDivider));
        }
    }

    ViewPager.OnPageChangeListener viewlistner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            adddotsindicater(i);
            curpage = i;

            if(i == 0){
                nextbtn.setEnabled(true);
                backbtn.setEnabled(false);
                skipbtn.setEnabled(false);
                backbtn.setVisibility(View.INVISIBLE);
                skipbtn.setVisibility(View.INVISIBLE);
                skipbtn.setText("");
                nextbtn.setText("Next");
                nextbtn.setVisibility(View.VISIBLE);
                backbtn.setText("");

            }
            else if (i == mdots.length -1 ){
                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);
                nextbtn.setVisibility(View.INVISIBLE);
                nextbtn.setText("Next");
                backbtn.setText("Back");
                skipbtn.setVisibility(View.VISIBLE);
                skipbtn.setText("Finish");
            }
            else
            {
                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);
                skipbtn.setVisibility(View.INVISIBLE);
                skipbtn.setText("");
                //nextbtn.setVisibility(View.INVISIBLE);
                nextbtn.setText("Next");
                backbtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


    public void btnnextClick(View view) {
    }

    public void btnSkipClick(View view) {
    }

























        /*apname = findViewById(R.id.apnm);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent mainIntent = new Intent(MainActivity.this,MainHomeActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            },SPLASH_DISPLAY_LENGTH);

            Animation anim = AnimationUtils.loadAnimation(this, R.anim.fadein);
            apname.startAnimation(anim);
        }*/
    }




