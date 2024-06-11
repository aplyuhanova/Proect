package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Answer extends AppCompatActivity {
    TextView greet;
    String answer;
    String ans;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer);
        answer = String.valueOf((EditText) findViewById(R.id.ans));
        String ans = getIntent().getStringExtra("ans");
        greet = (TextView) findViewById(R.id.greet);
    }
    public void check(View view){

        if(answer==ans){
            greet.setText("Молодец, ответ верный!");
        }
        else{
            greet.setText("Молодец, ответ верный!");
        }

    }

}