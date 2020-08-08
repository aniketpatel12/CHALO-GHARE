package com.company.CHALOGHARE;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class rickshaw extends AppCompatActivity {


    ListView lst;
    String rcname[] = {"Amarbhai","Hasanbhai","Ajitbhai","Rhpbhai" , "Karanshanbhai" , "Rameshbhai" , "Akashbhai" , "Hiteshbhai","Allubhai Saiyed","Dhwanii Taxiwala"};
    String np[] = {"Gj07cb6653","Gj23zq6353","Gj0723ap5225","Gj07ak14206","Gj07vp2347","Gj07mp1977","Gj23da1201","Gj07md2262","Gj07cz3010","Gj05ad1201"};
    int btn[] ={R.id.callbtn,R.id.callbtn,R.id.callbtn,R.id.callbtn,R.id.callbtn,R.id.callbtn,R.id.callbtn,R.id.callbtn};
    int mbtn[] ={R.id.msgbtn,R.id.msgbtn,R.id.msgbtn,R.id.msgbtn,R.id.msgbtn,R.id.msgbtn,R.id.msgbtn,R.id.msgbtn};
    ImageView rcklogo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_rickshaw);

        lst =  findViewById(R.id.rcklst);
        myadpater adptr = new myadpater(this, rcname,np,btn,mbtn);
        lst.setAdapter(adptr);
        ImageView rcslg = findViewById(R.id.rcklogo);
        Animation rclganim = AnimationUtils.loadAnimation(rickshaw.this,R.anim.lefttoright);
        rcslg.startAnimation(rclganim);
        TextView rcls = findViewById(R.id.rclsnm);
        Animation rcnmanim = AnimationUtils.loadAnimation(rickshaw.this,R.anim.bounce);
        rcls.startAnimation(rcnmanim);

    }

    class myadpater extends ArrayAdapter<String>{

        Context context;
        String crname[];
        String pn[];
        int tnb[];
        int nmbt[];

        myadpater(Context c , String crname[], String pn[],int tnb[],int nmbt[]){
            super(c,R.layout.rlist,R.id.txtview1,crname);
            this.context=c;
            this.crname=crname;
            this.pn=pn;
            this.tnb=tnb;
            this.nmbt=nmbt;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rcklist = layoutInflater.inflate(R.layout.rlist,parent,false);
            Button btn = rcklist.findViewById(R.id.callbtn);
            TextView nametxt = rcklist.findViewById(R.id.txtview1);
            TextView nptxt = rcklist.findViewById(R.id.txtview2);
            Animation anim = AnimationUtils.loadAnimation(rickshaw.this,R.anim.lefttoright);


            Button mesgbtn = rcklist.findViewById(R.id.msgbtn);
            nametxt.setText(crname[position]);
            nptxt.setText(pn[position]);
            if(position==0){
                nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }
            if(position==1)
            {
                nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }
            if(position==2)
            {nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }
            if(position==3)
            {nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }
            if(position==4)
            {nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }
            if(position==5)
            {nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }
            if(position==6)
            {nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }
            if(position==7)
            {nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }
            if(position==8)
            {nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }
            if(position==9)
            {nametxt.startAnimation(anim);
                nptxt.startAnimation(anim);
            }


            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation anim = AnimationUtils.loadAnimation(rickshaw.this,R.anim.lefttoright);
                    if(position==0){
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:9737679411"));
                        startActivity(call);
                    }
                    if(position==1)
                    {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:9714504143"));
                        startActivity(call);
                    }
                    if(position==2)
                    {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:7046573553"));
                        startActivity(call);
                    }
                    if(position==3)
                    {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:6356976442"));
                        startActivity(call);
                    }
                    if(position==4)
                    {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:9879747285"));
                        startActivity(call);
                    }
                    if(position==5)
                    {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:7359594830"));
                        startActivity(call);
                    }
                    if(position==6)
                    {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:9427809011"));
                        startActivity(call);
                    }
                    if(position==7)
                    {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:9879748301"));
                        startActivity(call);
                    }

                    if(position==8)
                    {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:7359947285"));
                        startActivity(call);
                    }

                    if(position==8)
                    {
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:9574081608"));
                        startActivity(call);
                    }
                }
            });

            mesgbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position==0){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","9737679411",null));
                        startActivity(m);
                    }
                    if(position==1){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","9714504143",null));
                        startActivity(m);
                    }
                    if(position==2){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","7046573553",null));
                        startActivity(m);
                    }
                    if(position==3){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","6356976442",null));
                        startActivity(m);
                    }
                    if(position==4){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","9879747285",null));
                        startActivity(m);
                    }
                    if(position==5){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","7359594830",null));
                        startActivity(m);
                    }
                    if(position==6){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","9427809011",null));
                        startActivity(m);
                    }
                    if(position==7){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","9737679411",null));
                        startActivity(m);
                    }
                    if(position==8){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","7359947285",null));
                       startActivity(m);
                        /*Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setData(Uri.parse("smsto:"+"7359947285")); // This ensures only SMS apps respond
                        intent.putExtra("sms_body","Passengers: " + " From: " + "To: ");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }*/
                    }

                    if(position==7){

                        Intent m = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","9574081608",null));
                        startActivity(m);
                    }


                }
            });
            return rcklist;

        }
    }

}


