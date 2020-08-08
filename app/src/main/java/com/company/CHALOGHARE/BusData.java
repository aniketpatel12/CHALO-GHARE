package com.company.CHALOGHARE;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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

//import android.support.annotation.RequiresApi;
//import android.support.v7.widget.RecyclerView;

//import android.support.annotation.NonNull;

//import android.support.v7.app.AppCompatActivity;

public class BusData extends AppCompatActivity {


    RecyclerView recyclerView;
    BusAdapter busAdapter;
    List<BussesClass> bussesClassList;
    TextView tv1,tv2,tv3;
   // CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busrecycler);

        //cardView=findViewById(R.id.card_view);
     //   ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
       /* Sprite doubleBounce = new DoubleBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
*/


//       final Animation anim = (Animation) AnimationUtils.loadAnimation(this,R.anim.righttoleft);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tv1=findViewById(R.id.BusName);
        tv2=findViewById(R.id.Time);
        bussesClassList = new ArrayList<>();

        Intent i = getIntent();
        String source = i.getStringExtra("Source");
        String dest = i.getStringExtra("Dest");


        busAdapter = new BusAdapter(BusData.this,bussesClassList);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child(source).child(dest);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bussesClassList.clear();
                if(dataSnapshot.exists()){
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                       bussesClassList.add(new BussesClass(ds.child("Bus").getValue(String.class), ds.child("Time").getValue(String.class)));

                         //BussesClass b = ds.getValue(BussesClass.class);
                         //bussesClassList.add(b);
                    }
                    Toast.makeText(BusData.this,bussesClassList.size() + " Buses Found ", Toast.LENGTH_SHORT).show();
                    recyclerView.setAdapter(busAdapter);

    /*

                    String s = "";
                    for (int i = 0; i < bussesClassList.size(); i++) {
//                    Toast.makeText(nadiad.this, "Bus Name:" + busList.get(i).getName() + " \tTime  " + busList.get(i).getTime(), Toast.LENGTH_SHORT).show();
                        s += bussesClassList.get(i).getName() + " Time  " + bussesClassList.get(i).getTime();
                    }
                    Toast.makeText(BusData.this, "" + s, Toast.LENGTH_SHORT).show();
                        *//*
                    LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(BusData.this.recyclerView.getContext(),R.anim.uptodown);
                    BusData.this.recyclerView.setLayoutAnimation(layoutAnimationController);
                    BusData.this.recyclerView.scheduleLayoutAnimation();
*/

                  //  progressBar.onVisibilityAggregated(true);



                    //recyclerView.startAnimation(anim);



                              }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }

}
