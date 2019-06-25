package com.example.myapplication;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    // Fragment codes
    private static final String TAG="MainActivity";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private SectionsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Fragment codes
        mSectionsPagerAdapter= new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager) findViewById(R.id.container);

        adapter= new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        mViewPager.setAdapter(adapter);

        TabLayout tabLayout=((TabLayout) findViewById(R.id.toolbarTop));
        tabLayout.setupWithViewPager(mViewPager);


        tabLayout.getTabAt(0).setText("System 1");
        tabLayout.getTabAt(1).setText("System 2");
        tabLayout.getTabAt(2).setText("System 3");
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));


        OkHttpClient client = new OkHttpClient();

        String url = "https://12od33mwyb.execute-api.us-east-2.amazonaws.com/dev/compare-yourself/all";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONArray jsonarray = new JSONArray(myResponse);

                                JSONObject jsonobject0 = jsonarray.getJSONObject(0);
                                Tab1Fragment frag1 =(Tab1Fragment) adapter.getItem(0);
                                Log.i("Fragments",frag1.setJsonData(jsonobject0));
                                Tab1Fragment frag2 =(Tab1Fragment) adapter.getItem(1);
                                Log.i("Fragments",frag2.setJsonData(myResponse));
                                Tab1Fragment frag3 =(Tab1Fragment) adapter.getItem(2);
                                Log.i("Fragments",frag3.setJsonData(myResponse));
                            }catch (Exception e){
                                //pass
                                Log.i("json","error");
                            }
                        }
                    });
                }
            }
        });
    }
    public void httpCall(){
        OkHttpClient client = new OkHttpClient();

        String url = "https://12od33mwyb.execute-api.us-east-2.amazonaws.com/dev/compare-yourself/all";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONArray jsonarray = new JSONArray(myResponse);

                                JSONObject jsonobject0 = jsonarray.getJSONObject(0);
                                Tab1Fragment frag1 =(Tab1Fragment) adapter.getItem(0);
                                Log.i("Fragments",frag1.setJsonData(jsonobject0));
                                Tab1Fragment frag2 =(Tab1Fragment) adapter.getItem(1);
                                Log.i("Fragments",frag2.setJsonData(myResponse));
                                Tab1Fragment frag3 =(Tab1Fragment) adapter.getItem(2);
                                Log.i("Fragments",frag3.setJsonData(myResponse));
                            }catch (Exception e){
                                //pass
                                Log.i("json","error");
                            }
                        }
                    });
                }
            }
        });

    }
}
