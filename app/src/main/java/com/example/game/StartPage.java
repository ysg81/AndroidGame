package com.example.game;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        Button start_btn = (Button)findViewById(R.id.exitgame);
        Button exit_btn = (Button)findViewById(R.id.restart);
        Button help_btn = (Button)findViewById(R.id.helpgame);
        start_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }));
        help_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartPage.this, HelpPage.class);
                startActivity(intent);
                finish();
            }
        }));
        exit_btn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }));
    }
}