package com.company.CHALOGHARE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TrainAdpter extends RecyclerView.Adapter<TrainAdpter.trainViewHolder>{


    Context context;
    List<TrainClasses> trainList;

    public TrainAdpter(Context context, List<TrainClasses> trainList) {
        this.context = context;
        this.trainList=trainList;
    }


    @Override
    public trainViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.trainlist,viewGroup,false);
        trainViewHolder trainViewHolder = new trainViewHolder(view);
        return trainViewHolder;
    }
    @Override
    public void onBindViewHolder(trainViewHolder trainViewHolder, int i) {
        TrainClasses trainClasses = trainList.get(i);
        trainViewHolder.train.setText("Train: " + trainClasses.getName());
        trainViewHolder.number.setText("Number: " + trainClasses.getNumber());
        trainViewHolder.dptime.setText("Departure Time: " + trainClasses.getAtime());
        trainViewHolder.artime.setText("Arrival Time: " + trainClasses.getDtime());


       // trainViewHolder.train.setText("Train: " + );
       // trainViewHolder.time.setText("Time: " +bussesClass.getTime());
        // Animation anim = (Animation) AnimationUtils.loadAnimation(this,R.anim.righttoleft);
        // busviewHolder.bus.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return trainList.size();
    }

    class trainViewHolder extends RecyclerView.ViewHolder{

        TextView train,number,dptime,artime;


        public trainViewHolder(@NonNull View itemView) {
            super(itemView);

            train=itemView.findViewById(R.id.TrainName);
            number=itemView.findViewById(R.id.Number);
            artime=itemView.findViewById(R.id.Artime);
            dptime=itemView.findViewById(R.id.Dptime);

        }
    }


}
