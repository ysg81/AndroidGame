package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TargetView tView = findViewById(R.id.tview);
        final BlockView bView= new BlockView(this);
        LayoutInflater inflater = getLayoutInflater();
        addContentView(bView, new LinearLayout.LayoutParams(1080, 1920) );

        Button blow_btn = (Button) findViewById(R.id.blow_btn); // 버튼 선언
        blow_btn.setOnClickListener(new View.OnClickListener() { // Listener 함수
            @Override
            public void onClick(View v) {
                if (tView.detmove == 0) { // 움직일 수 있다
                    int a = 0;
                    a += 8;
                    tView.radius = tView.radius + a;
                    tView.invalidate();
                    tView.moveable = 1;

                    for (int i = 0; i < 15; i++) {
                        if ( Math.sqrt((Math.pow(tView.x - bView.px[i], 2)
                                + Math.pow(tView.y - bView.py[i], 2)))
                                <= tView.radius + bView.pr[i] ) {

                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                            // 제목셋팅
                            alertDialogBuilder.setTitle(" Retry? ");

                            // AlertDialog 셋팅
                            alertDialogBuilder
                                    .setMessage("Game over")
                                    .setCancelable(false)

                                    .setPositiveButton("게임 종료",
                                            new DialogInterface.OnClickListener() {
                                                    public void onClick(
                                                        DialogInterface dialog, int id) {
                                                    // 프로그램을 종료한다
                                                    MainActivity.this.finish();
                                                }
                                            })
                                    .setNegativeButton("다시 하기",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(
                                                        DialogInterface dialog, int id) {
                                                    // 다이얼로그를 취소한다
                                                    dialog.cancel();
                                                }
                                            });
                            // 다이얼로그 생성
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            // 다이얼로그 보여주기
                            alertDialog.show();

                        } // 충돌할 경우
                    }
                }
                count += 150;
            }
        });
    }

}
