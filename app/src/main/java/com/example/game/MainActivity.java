package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TargetView tView = findViewById(R.id.tview);
        BlockView bView= new BlockView(this);
        LayoutInflater inflater = getLayoutInflater();
        addContentView(bView, new LinearLayout.LayoutParams(1080, 1920) );

        Button blow_btn = (Button) findViewById(R.id.blow_btn); // 버튼 선언
        blow_btn.setOnClickListener(new View.OnClickListener() { // Listener 함수
            @Override
            public void onClick(View v) {
                if(tView.detmove == 0) { // 움직일 수 있다
                    int a = 0;
                    a += 8;
                    tView.radius = tView.radius + a;
                    tView.invalidate();
                    tView.moveable = 1;
                }
                count += 150;
//            if(Math.abs(px - tView.x) >= Math.abs(tView.radius + (px - x1)) ||
//                    Math.abs(py - tView.y) >= Math.abs(tView.radius + (py - y1))) {} // 충돌할 경우
            }
        });
    }

}
