package com.projectuas.sukma.apollo;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ImageView kost1;
    Button buton;
    TextView facility;

    public static String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mToolbar = (Toolbar) findViewById(R.id.toolbar2);
        kost1 = (ImageView) findViewById(R.id.image);
        facility = (TextView) findViewById(R.id.facility);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
           // mToolbar.setTitle(bundle.getString("kost1"));
            if (mToolbar.getTitle().toString().equalsIgnoreCase("Dewa Futsal Tembalang")) {
                kost1.setImageDrawable(ContextCompat.getDrawable(secondActivity.this,
                        R.drawable.dewa));
                nama="Dewa Futsal Tembalang";
                facility.setText("1.Indoor\n2.Full Music\n3.Locker\n4.Rumput Sintetis\n5.Cafe\n6.Parkir Gratis");
            }
            else if (mToolbar.getTitle().toString().equalsIgnoreCase("Fanny Futsal Stadium")) {
                kost1.setImageDrawable(ContextCompat.getDrawable(secondActivity.this,
                        R.drawable.fanny));
                nama="Fanny Futsal Stadium";
                facility.setText("1.Lapangan Rumput\n2.Lapangan Sintetis");
            }
            else if (mToolbar.getTitle().toString().equalsIgnoreCase("Mega Futsal")) {
                kost1.setImageDrawable(ContextCompat.getDrawable(secondActivity.this,
                        R.drawable.mega));
                nama="Mega Futsal";
                facility.setText("1.Free Wifi\n2.Full Music");
            }
            else if (mToolbar.getTitle().toString().equalsIgnoreCase("Spider Futsal Stadium")) {
                kost1.setImageDrawable(ContextCompat.getDrawable(secondActivity.this,
                        R.drawable.spider));
                nama="Spider Futsal Stadium";
                facility.setText("1.Indoor\n2.Full Music\n3.Locker\n4.Rumput Sintetis");
            }
            else if (mToolbar.getTitle().toString().equalsIgnoreCase("Radja Futsal")) {
                kost1.setImageDrawable(ContextCompat.getDrawable(secondActivity.this,
                        R.drawable.radja));
                nama="Radja Futsal";
                facility.setText("1.Indoor\n2.Locker\n3.Rumput Sintetis");
            }
        }


        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent1 = new Intent(secondActivity.this, Review.class);
                buton = (Button) findViewById(R.id.bt2);
                myIntent1.putExtra("layout", R.layout.activity_review);
                startActivity(myIntent1);
            }
        });
    }
    public void review(View view) {
    }
}