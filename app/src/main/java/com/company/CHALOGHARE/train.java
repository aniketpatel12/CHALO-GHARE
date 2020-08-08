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

public class train extends AppCompatActivity {

    ImageView i1;
    private TextView tx1;
    private TextView tx2;
    public Spinner sr1;
    public Spinner sr2;
    private Button srchbtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_train);

        sr1=(Spinner)findViewById(R.id.spinner1);
        sr2=(Spinner)findViewById(R.id.spinner2);
        tx1= (TextView) findViewById(R.id.srtxt);
        tx2= (TextView) findViewById(R.id.dstxt);
        i1=findViewById(R.id.tric);
        srchbtn=findViewById(R.id.srbtn);
        Animation anim1 = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        i1.startAnimation(anim1);


        srchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), TrainData.class);
                final String str = sr2.getSelectedItem().toString();
                final String one = sr1.getSelectedItem().toString();
                if(one.equals(str)) {
                    Toast.makeText(train.this, "Invalid selection", Toast.LENGTH_SHORT).show();
                } else if(one.equals("SELECT PLACE") || str.equals("SELECT PLACE")){
                    Toast.makeText(train.this, "Invalid selection", Toast.LENGTH_SHORT).show();
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


        ArrayAdapter<String> ar1= null;
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("SELECT PLACE");
        a1.add("AHMEDABAD (AHM)");
        a1.add("ANAND (AN)");
        a1.add("NADIAD (ND)");
        a1.add("VADODARA (VD)");
        try{
            ar1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,a1);
            ar1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sr1.setAdapter(ar1);
            sr1.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String str1 = sr1.getSelectedItem().toString();
                    getstr1(str1);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
           // sr2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) train.this);;
        }catch(NullPointerException ignored){

        }

        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("SELECT PLACE");
        a2.add("AHMEDABAD (AHM)");
        a2.add("ANAND (AN)");
        a2.add("BARDOLI (BR)");
        a2.add("BHARUCH (BRH)");
        a2.add("BHAVNAGAR (BVN)");
        a2.add("GANDHINAGAR (GNN)");
        a2.add("JAMNAGAR (JMN)");
        a2.add("JUNAGADH (JNG)");
        a2.add("MEHSANA (MHS)");
        a2.add("NADIAD (ND)");
        a2.add("NAVSARI (NVS)");
        a2.add("PALANPUR (PLN)");
        a2.add("RAJKOT (RJ)");
        a2.add("SURAT (ST)");
        a2.add("SURENDRANAGAR (SRN)");
        a2.add("VALSAD (VLS)");
        a2.add("VADODARA (VD)");

        ArrayAdapter<String> ar2=null;

        if(!isConnected()){
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
        }
        else
        {
            try{
                ar2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,a2);
                ar2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sr2.setAdapter(ar2);
                sr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                String str2 = sr2.getSelectedItem().toString();
                               // getstr2(str2);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }catch(NullPointerException ignored){

            }
        }
    }


    public String getstr2(String s)
    {
        return s;
    }

    public String getstr1(String s)
    {
        return s;
    }

    private Boolean isConnected(){
        ConnectivityManager cnm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nif = cnm.getActiveNetworkInfo();

        return nif != null && nif.isConnected();
    }



}


