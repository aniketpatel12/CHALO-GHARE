package com.company.CHALOGHARE;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

//import android.support.annotation.NonNull;
//import android.support.v4.view.PagerAdapter;

public class slideradapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public slideradapter(Context context){
        this.context=context;
    }

    public int[] slide_images={
            R.drawable.rckslide,
            R.drawable.busslide,
            R.drawable.trainslide,
            R.drawable.map
    };

    public String[] slideheading={
            "Rickshaw","Bus","Train","Nearby Places"
    };

    public String[] slidedesc={
            "(If you face any problem in finding rickshaw then, from this app you can easily contact rickshaw driver(call/sms))","(If you face any problem to find which bus is best for you to travel from college to home then, from this app you can get enough information about different buses,which help you to reach at your destination in your suitable time.)","(If you face any problem to find which train is best for you to travel from college to home then, from this app you can get enough information about different trains, which help you to reach at your destination in your suitable time.)","(If you face any problem to find particular Building/Labs/Rooms/Foodplaces(Nearby) then, from this app you can get direction which leads you towards your destination)"
    };




    @Override
    public int getCount() {


        return slideheading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slidelayout,container,false);

        ImageView slide_imageView = view.findViewById(R.id.imageView);
        TextView slideHeading = view.findViewById(R.id.tvHeading);
        TextView  slideDescription = view.findViewById(R.id.tvDescription);

        slide_imageView.setImageResource(slide_images[position]);
        slideHeading.setText(slideheading[position]);
        slideDescription.setText(slidedesc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
