package com.projectuas.sukma.apollo;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("APOLLO");
        listView = (ListView) findViewById(R.id.listView);

        customadapter ca = new customadapter();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("kost", Names[i]);
                startActivity(intent);
            }
        });
        FirebaseAuth f = FirebaseAuth.getInstance();
        f.signOut();
        listView.setAdapter(ca);
    }

    class customadapter extends BaseAdapter {
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return images.length;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(final int position, View convertview, ViewGroup arg2) {
            // TODO Auto-generated method stub
            LayoutInflater inflater = getLayoutInflater();
            convertview = inflater.inflate(R.layout.custom, null);
            TextView tv = (TextView) convertview.findViewById(R.id.TV1);
            TextView tv1 = (TextView) convertview.findViewById(R.id.TV2);
            ImageView image = (ImageView) convertview.findViewById(R.id.IV);
            tv.setText(Names[position]);
            //tv1.setText(Prize[position]);
            image.setImageResource(images[position]);

            return convertview;
        }

    }

    public static String[] Names = {"Dewa Futsal Tembalang", "Fanny Futsal Stadium Semarang Arteri Soekarno Hatta", "Mega Futsal", "Spider Futsal Stadium Semarang", "Radja Futsal"};
    //String[] Prize = {"Rp.500.000.000", "Rp.400.000.000", "Rp.350.000.000", "Rp.475.000.000", "Rp.550.000.000"};
    int[] images = {R.drawable.dewa, R.drawable.fanny, R.drawable.mega,
            R.drawable.spider, R.drawable.radja};
}
