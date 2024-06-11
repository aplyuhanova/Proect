package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void apple1(View view){
        Intent intent = new Intent(MainActivity.this, Easy_peasy.class);
        startActivity(intent);
    }
    public void apple2(View view){
        Intent intent = new Intent(MainActivity.this, Middle.class);
        startActivity(intent);
    }
    public void apple3(View view){
        Intent intent = new Intent(MainActivity.this, Hard.class);
        startActivity(intent);
    }
    public void check(View view){

    }

}