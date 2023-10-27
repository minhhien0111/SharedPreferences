package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    TextView myTextview;
    Button myButton;
    ArrayList<String> list;
    ArrayList<String> listColor;
    ArrayList<String> listSize_height;
    ArrayList<String> listSize_width;
    String text_TextView;
    int color_TextView;
    int size_height_TextView;
    int size_width_TextView;
    TextView myTextviewColor;
    Button myClear;
    TextView size;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        listColor = new ArrayList<>();
        listColor.add(String.valueOf(Color.BLACK));
        listColor.add(String.valueOf(Color.WHITE));
        listColor.add(String.valueOf(Color.CYAN));
        listColor.add(String.valueOf(Color.MAGENTA));
        listSize_height = new ArrayList<>();
        listSize_height.add("230");
        listSize_height.add("80");
        listSize_height.add("100");
        listSize_width = new ArrayList<>();
        listSize_width.add("150");
        listSize_width.add("580");
        listSize_width.add("340");
        myButton = findViewById(R.id.button);
        myTextview = findViewById(R.id.textView);
        myTextviewColor = findViewById(R.id.textViewColor);
        myClear = (Button) findViewById(R.id.buttonClear);
        size = findViewById(R.id.textViewSize);
        SharedPreferences pref = getSharedPreferences("save", MODE_PRIVATE);
        text_TextView = pref.getString("txt", "");
        color_TextView = pref.getInt("color",0);
        size_height_TextView = pref.getInt("height", 0);
        size_width_TextView = pref.getInt("width", 0);
        Toast.makeText(MainActivity.this, Integer.toString(size_height_TextView), Toast.LENGTH_SHORT).show();
        myTextviewColor.setBackgroundColor(color_TextView);
        myTextview.setText(text_TextView);
        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) size.getLayoutParams();
        layoutParams.width = size_width_TextView;
        layoutParams.height = size_height_TextView;
        size.setLayoutParams(layoutParams);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(list);
                Collections.shuffle(listColor);
                Collections.shuffle(listSize_height);
                Collections.shuffle(listSize_width);
                int randomColor = Integer.parseInt(listColor.get(0));
                int randomHeight = Integer.parseInt(listSize_height.get(0));
                int randomWidth = Integer.parseInt(listSize_width.get(0));
                String randomValue = list.get(0);
                myTextview.setText(randomValue);
                myTextviewColor.setBackgroundColor(randomColor);
                ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) size.getLayoutParams();
                layoutParams.width = randomWidth;
                layoutParams.height = randomHeight;
                size.setLayoutParams(layoutParams);
                Toast.makeText(MainActivity.this, Integer.toString(size_height_TextView), Toast.LENGTH_SHORT).show();
                text_TextView = randomValue;
                color_TextView = randomColor;
                size_height_TextView = randomHeight;
                size_width_TextView = randomWidth;
                //Toast.makeText(MainActivity.this, "Button Random clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        myClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button Clear clicked!", Toast.LENGTH_SHORT).show();
                text_TextView = "Xin chao";
                color_TextView = Color.BLACK;
                size_height_TextView = 50;
                size_width_TextView = 100;
                myTextviewColor.setBackgroundColor(color_TextView);
                myTextview.setText(text_TextView);
                ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) size.getLayoutParams();
                layoutParams.width = size_width_TextView;
                layoutParams.height = size_height_TextView;
                size.setLayoutParams(layoutParams);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Toast.makeText(MainActivity.this, "Pause!", Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, Integer.toString(size_height_TextView), Toast.LENGTH_SHORT).show();
        SharedPreferences pref = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("txt", text_TextView);
        editor.putInt("color", color_TextView);
        editor.putInt("height", size_height_TextView);
        editor.putInt("width", size_width_TextView);
        editor.commit();
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(MainActivity.this, "Resume!", Toast.LENGTH_SHORT).show();
//        SharedPreferences pref = getSharedPreferences("save", MODE_PRIVATE);
//        text_TextView = pref.getString("txt", "");
//        color_TextView = pref.getInt("color",0);
//        int size_height = pref.getInt("height", 0);
//        int size_width = pref.getInt("width", 0);
//        myTextviewColor.setBackgroundColor(color_TextView);
//        myTextview.setText(text_TextView);
//        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) size.getLayoutParams();
//        layoutParams.width = size_width;
//        layoutParams.height = size_height;
//        size.setLayoutParams(layoutParams);
//    }
}