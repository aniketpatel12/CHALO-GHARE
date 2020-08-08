package com.company.CHALOGHARE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainHomeActivity extends AppCompatActivity {

    SpaceNavigationView navigationView;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        navigationView= findViewById(R.id.space);
        navigationView.initWithSaveInstanceState(savedInstanceState);
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_rickshaw));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_directions_bus_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_train));
        navigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_map_black_24dp));

        isGPSEnable();
      //  onBackPressed();


        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {

                navigationView.setCentreButtonSelectable(true);

            }


/*
            @Override
            public void onBackPressed() {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainHomeActivity.this);
                builder.setMessage("Do you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MainHomeActivity.super.onBackPressed();
                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }*/


            @Override
            public void onItemClick(int itemIndex, String itemName) {

                    switch (itemIndex){

                        case 0:
                        startActivity(new Intent(getApplicationContext()
                        ,rickshaw.class));
                        overridePendingTransition(0,0);
                        break;

                        case 1:
                            startActivity(new Intent(getApplicationContext()
                                ,bus.class));
                            overridePendingTransition(0,0);
                            break;

                        case 2:
                            startActivity(new Intent(getApplicationContext()
                                    ,train.class));
                            overridePendingTransition(0,0);
                            break;

                        case 3:
                            startActivity(new Intent(getApplicationContext()
                                    ,Map.class));
                            overridePendingTransition(0,0);
                            break;


                    }

            }




            @Override
            public void onItemReselected(int itemIndex, String itemName) {


                switch (itemIndex){

                    case 0:
                        startActivity(new Intent(getApplicationContext()
                                ,rickshaw.class));
                        overridePendingTransition(0,0);
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext()
                                ,bus.class));
                        overridePendingTransition(0,0);
                        break;



                    case 2:
                        startActivity(new Intent(getApplicationContext()
                                ,train.class));
                        overridePendingTransition(0,0);
                        break;

                    case 3:
                        startActivity(new Intent(getApplicationContext()
                                ,Map.class));
                        overridePendingTransition(0,0);
                        break;


                }


            }
        });


    }

    public void isGPSEnable(){
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = service
                .isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!enabled) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main__home,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.ContactUs){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"chaloghare@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.setPackage("com.google.android.gm");
            if (intent.resolveActivity(getPackageManager()) != null)
                startActivity(intent);
            else
                Toast.makeText(this, "Gmail App is not installed", Toast.LENGTH_SHORT).show();
        }

        if(item.getItemId()==R.id.devlopers){
            Intent intent3 = new Intent(this, devlopers.class);
            startActivity(intent3);
        }
        return super.onOptionsItemSelected(item);
    }
}