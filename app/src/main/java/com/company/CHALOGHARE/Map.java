package com.company.CHALOGHARE;


import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

//import androidx.viewpager.widget.ViewPager;

public class Map extends AppCompatActivity {

    /*
        SpaceNavigationView navigationView;
    */
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors=null;
    Button mapselect;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipeview);

        models=new ArrayList<>();
        models.add(new Model(R.drawable.charusatmap,"CHARUSAT MAP","You can easily get location of any Department/Building by just selecting this option.",mapselect));
        models.add(new Model(R.drawable.food,"FOOD(Near By)","You can easily get location of nearby Food Places by just selecting places.",mapselect));
        mapselect=findViewById(R.id.mapselectbtn);
        adapter=new Adapter(models,this);
        viewPager=findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] color_temp={
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2)
        };

        colors=color_temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position<(adapter.getCount() -1) && position<(colors.length - 1)){
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }else {
                    viewPager.setBackgroundColor(colors[colors.length -1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

                if(position == 0){

                    startActivity(new Intent(getApplicationContext()
                            , CharusatMapsActivity.class));
                }
                if(position == 1){
                    startActivity(new Intent(getApplicationContext()
                            , FoodMapsActivity.class));
                }



            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
