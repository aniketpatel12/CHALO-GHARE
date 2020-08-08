package com.company.CHALOGHARE;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;

public class bus extends AppCompatActivity {

    private TextView tx1;
    private TextView tx2;
    public Spinner sr1;
    public Spinner sr2;
    private ImageView bsic;
    public Button srchbtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bus);
        sr1 = (Spinner) findViewById(R.id.spinner1);
        sr2 = (Spinner) findViewById(R.id.spinner2);
        tx1 = (TextView) findViewById(R.id.srtxt);
        tx2 = (TextView) findViewById(R.id.dstxt);
        bsic = findViewById(R.id.busicon);
        srchbtn = findViewById(R.id.srbtn);


        final String[] data = new String[1];
//        ref.child("Test").setValue("hello");

        srchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), BusData.class);
                final String str = sr2.getSelectedItem().toString();
                final String one = sr1.getSelectedItem().toString();
                if(one.equals(str)){
                    Toast.makeText(bus.this, "Invalid selection", Toast.LENGTH_SHORT).show();
                }else if(one.equals("NADIAD") && str.equals("GANDHINAGAR")){
                    Toast.makeText(bus.this, "There are no buses between this 2 cities!!! Please find an alternative route.", Toast.LENGTH_SHORT).show();
                }
                else if(one.equals("ANAND") && str.equals("SURENDRANAGAR")){
                    Toast.makeText(bus.this, "There are no buses between this 2 cities!!! Please find an alternative route.", Toast.LENGTH_SHORT).show();
                }
                else if(one.equals("SELECT PLACE") || str.equals("SELECT PLACE")){
                    Toast.makeText(bus.this, "Invalid selection", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    b.putExtra("Source", one);
                    b.putExtra("Dest", str);
                    startActivity(b);
                }
//                Toast.makeText(bus.this, "str 2: " + str + "\n str 1: " + one, Toast.LENGTH_SHORT).show();

            }
        });

        Animation an1 = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        bsic.startAnimation(an1);
        ArrayAdapter<String> ar1 = null;
        ArrayList<String> a1 = new ArrayList<String>(6);
        a1.add("SELECT PLACE");
        a1.add("AHMEDABAD");
        a1.add("ANAND");
        a1.add("NADIAD");
        a1.add("VADODARA");
        try {
            ar1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, a1);
            ar1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sr1.setAdapter(ar1);
            sr1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String str1 = sr1.getSelectedItem().toString();
                    // getstr1(str1);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (NullPointerException ignored) {

        }
//For destination
        ArrayList<String> a2 = new ArrayList<String>(16);
        a2.add("SELECT PLACE");
        a2.add("AHMEDABAD");
        a2.add("ANAND");
        a2.add("BARDOLI");
        a2.add("BHARUCH");
        a2.add("BHAVNAGAR");
        a2.add("GANDHINAGAR");
        a2.add("JAMNAGAR");
        a2.add("JUNAGADH");
        a2.add("MEHSANA");
        a2.add("NADIAD");
        a2.add("NAVSARI");
        a2.add("PALANPUR");
        a2.add("RAJKOT");
        a2.add("SURAT");
        a2.add("SURENDRANAGAR");
        a2.add("VALSAD");
        a2.add("VADODARA");


        ArrayAdapter<String> ar2 = null;

        if (!isConnected()) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("No Internet Connection")
                    .setMessage("You need to have Mobile Data or wifi to access this. Press Close to Exit")
                    .setPositiveButton("close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        } else {
            try {
                ar2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, a2);
                ar2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sr2.setAdapter(ar2);
                sr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String str2 = sr2.getSelectedItem().toString();
                        // getstr2(str2);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            } catch (NullPointerException ignored) {

            }
        }
    }

    public String getstr2(String s) {
        return s;
    }

    public String getstr1(String s) {
        return s;
    }

    private Boolean isConnected() {
        ConnectivityManager cnm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nif = cnm.getActiveNetworkInfo();

        return nif != null && nif.isConnected();
    }

    public void checkstr() {
        String str1 = sr1.getSelectedItem().toString();
        String str2 = sr2.getSelectedItem().toString();


    }

    public String getstr1() {
        return sr1.getSelectedItem().toString();
    }

    public String getstr2() {
        return sr2.getSelectedItem().toString();
    }


}
