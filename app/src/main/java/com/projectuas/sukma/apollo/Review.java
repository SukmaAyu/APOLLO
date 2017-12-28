package com.projectuas.sukma.apollo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Review extends AppCompatActivity {

    Toolbar Xtoolbar;
    TextView rv;
    String nope;
    String address;
    TextView maps;
    TextView tlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Xtoolbar = (Toolbar) findViewById(R.id.toolbar2);
        rv = (TextView) findViewById(R.id.review);
        maps = (TextView) findViewById(R.id.maps);
        tlp = (TextView) findViewById(R.id.telp);

        new secondActivity();
        if(secondActivity.nama =="Dewa Futsal Tembalang"){
            Xtoolbar.setTitle("Review Dewa Futsal Tembalang");
            rv.setText("Alamat Jalan Tirto Agung Raya No 98 Pedalangan Tembalang Semarang\n Dari arah ngresrep setelah Perumahan Graha Estetika.\n Nomor Telepon 024 74077798 – 081904480508.\nFasilitas indoor, full musik, locker, rumput sintetis, cafe, parkir gratis.");
            maps.setText("UDINUS");
            tlp.setText("0246702873");
            nope="081234567890";
            address="https://www.google.co.id/maps/place/Dewa+Futsal+%26+Cafe/@-7.062553,110.4243133,17z/data=!4m12!1m6!3m5!1s0x2e708eacb5b5c51f:0x28217fcb80bc36d0!2sDewa+Futsal+%26+Cafe!8m2!3d-7.062553!4d110.426502!3m4!1s0x2e708eacb5b5c51f:0x28217fcb80bc36d0!8m2!3d-7.062553!4d110.426502?hl=id";
        }
        else if(secondActivity.nama =="Fanny Futsal Stadium"){
            Xtoolbar.setTitle("Review Fanny Futsal");
            rv.setText("Alamat Jalan Arteri Soekarno Hatta No 212 Semarang\n Tarif Sewa Lapangan:\n Hari Senin s/d Sabtu:\n Lapangan Rumput\n Pukul 08.00 – 16.00 = 80.000\n Pukul 16.00 – 24.00 = 135.000\n Lapangan Plester\n Pukul 08.00 – 16.00 = 50.000\n Pukul 16.00 – 24.00 = 80.000\n");
            maps.setText("UDINUS");
            tlp.setText("085742348232");
            nope="081234567890";
            address="https://www.google.co.id/maps/place/Fanny+Futsal+Stadium/@-7.002362,110.4658013,17z/data=!3m1!4b1!4m5!3m4!1s0x2e708ce49fc419ab:0xd74ad641e934c4d!8m2!3d-7.002362!4d110.46799?hl=id";
        }
        if(secondActivity.nama =="Mega Futsal"){
            Xtoolbar.setTitle("Review Mega Futsal");
            rv.setText("Alamat Jalan Wolter Monginsidi No 7 Pedurungan Kidul Semarang Kode Pos 50192 Jawa Tengah.\n Nomor Telepon 024 6712082.");
            maps.setText("UDINUS");
            tlp.setText("0246712082");
            nope="085742348232";
            address="https://www.google.co.id/maps/place/Urban+Futsal/@-7.0139967,110.3178015,12z/data=!4m8!1m2!2m1!1sfutsal+di+dekat+Semarang,+Kota+Semarang,+Jawa+Tengah!3m4!1s0x2e708c015639dd15:0x400aa3e297a2b1ff!8m2!3d-7.0520813!4d110.4313602?hl=id";
        }
        if(secondActivity.nama =="Spider Futsal Stadium"){
            Xtoolbar.setTitle("Review Spider Futsal");
            rv.setText("Alamat: Jl Gajah Raya No 56 Semarang Jawa Tengah.\n Nomor telepon: 024 6735232\n Arena bermain futsal Spider Futsal Stadium ini didominasi warna warna hijau,\nberada di jalan gajah dekat medoho,\n dari arah Lotte Mart Majapahit sebelum Masjid Agung Jawa Tengah.");
            maps.setText("UDINUS");
            tlp.setText("0246735232");
            nope="081234567890";
            address="https://www.google.co.id/maps/place/Spider+Futsal+Stadium/@-6.989994,110.4455563,17z/data=!3m1!4b1!4m5!3m4!1s0x2e708cbf3a12b111:0xe7402e2498e9d2da!8m2!3d-6.989994!4d110.447745?hl=id";
        }
        if(secondActivity.nama =="Radja Futsal") {
            Xtoolbar.setTitle("Review Radja Futsal");
            rv.setText("Radja Futsal Semarang Majapahit.\nAlamat: Jalan Bridjend Sudiarto (Majapahit) No 133 Semarang.\nNomor Telepon: 024 6721556, 6722102.\nRadja Futsal Semarang Tembalang.\nAlamat: Jalan Ngesrep Timur V No 102 Kec. Banyumanik Semarang.\n Nomor Telepon: 024 7472399.");
            maps.setText("UDINUS");
            tlp.setText("0247472399");
            nope = "081234567890";
            address="https://www.google.co.id/maps/place/Radja+Futsal+Gayamsari/@-7.002514,110.4458903,17z/data=!3m1!4b1!4m5!3m4!1s0x2e708c92e1d317b3:0xaa63a9fd52156dc6!8m2!3d-7.002514!4d110.448079?hl=id";
        }
    }
    public void contactDirectly(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + nope));
        startActivity(intent);
    }

    public void destination(View view) {
        String url = "http://" + address  ;
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
        startActivity(intent);
    }
}

