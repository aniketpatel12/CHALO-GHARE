package com.company.CHALOGHARE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//import android.support.annotation.NonNull;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.busviewHolder> {

    Context context;
    List<BussesClass> buslist;



    public BusAdapter(Context context, List<BussesClass> buslist) {
        this.context = context;
        this.buslist = buslist;
    }


    @Override
    public busviewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.buslist,viewGroup,false);
        busviewHolder busviewHolder = new busviewHolder(view);
        return busviewHolder;
    }

    @Override
    public void onBindViewHolder(busviewHolder busviewHolder, int i) {
                BussesClass bussesClass = buslist.get(i);
                busviewHolder.bus.setText("Bus: " + bussesClass.getName());
                busviewHolder.time.setText("Time: " +bussesClass.getTime());
               // Animation anim = (Animation) AnimationUtils.loadAnimation(this,R.anim.righttoleft);
               // busviewHolder.bus.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return buslist.size();
    }

    class busviewHolder extends RecyclerView.ViewHolder{

            TextView bus,time;


            public busviewHolder(@NonNull View itemView) {
                super(itemView);
                bus=itemView.findViewById(R.id.BusName);
                time=itemView.findViewById(R.id.Time);

            }
        }

}
