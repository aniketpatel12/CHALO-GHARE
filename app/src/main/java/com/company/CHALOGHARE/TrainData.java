package com.company.CHALOGHARE;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TrainData extends AppCompatActivity {

   private RecyclerView recyclerView;
    TrainAdpter trainAdpter;
    List<TrainClasses> trainClassesList;
    TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainrecycler);

        recyclerView = findViewById(R.id.my_recycler_view1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        tv1 = findViewById(R.id.train);
        tv2 = findViewById(R.id.Number);
        tv3 = findViewById(R.id.Dptime);
        tv4=findViewById(R.id.Artime);
        trainClassesList = new ArrayList<>();


        Intent i = getIntent();
        String source = i.getStringExtra("Source");
        String dest = i.getStringExtra("Dest");

        trainAdpter = new TrainAdpter(TrainData.this, trainClassesList);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child(source).child(dest);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                trainClassesList.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        trainClassesList.add(new TrainClasses(ds.child("Train").getValue(String.class),ds.child("Number").getValue(Long.class) ,ds.child("Dtime").getValue(String.class),ds.child("Atime").getValue(String.class)));

                    }
                    Toast.makeText(TrainData.this,trainClassesList.size() + " Trains Found ", Toast.LENGTH_SHORT).show();
                    //LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(recyclerView.getContext(),R.anim.uptodown);
                    recyclerView.setAdapter(trainAdpter);
                    //recyclerView.setLayoutAnimation(layoutAnimationController);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }


        });/*
        tv1.startAnimation(anim);
        tv1.startAnimation(anim);
        tv1.startAnimation(anim);
        tv1.startAnimation(anim);*/




    }
}

