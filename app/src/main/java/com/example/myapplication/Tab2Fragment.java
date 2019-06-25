package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Tab2Fragment extends Tab1Fragment {
    private static final String TAG = "Tab2Fragment";
    private TextView jsonText;
    private String json="Loading";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,container,false);
        jsonText = (TextView) view.findViewById(R.id.text_view_json);
        jsonText.setText(json);
        return view;
    }
    public String setJsonData(String mJson){
        json=mJson;
        try {
            jsonText.setText(json);
        }catch (Exception e){
            //ignore
        }
        return "2";
    }
}
