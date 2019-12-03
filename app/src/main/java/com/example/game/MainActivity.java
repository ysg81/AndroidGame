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
        final BlockView bView = new BlockView(this);
        LayoutInflater inflater = getLayoutInflater();
        addContentView(bView, new LinearLayout.LayoutParams(1080, 1920));

        Button blow_btn = (Button) findViewById(R.id.blow_btn); // 버튼 선언
        blow_btn.setOnClickListener(new View.OnClickListener() { // Listener 함수
            @Override
            public void onClick(View v) {
                if (tView.detmove == 1) { // 버튼 누르기 가능
                    int a = 0;
                    a += 8;
                    tView.radius = tView.radius + a;
                    tView.invalidate();
                    tView.moveable = 1; // 버튼이 누르고 난 후 위치변경 불가
                    count += 1; // socre 카운트
                    for (int i = 0; i < 30; i++) {

                        if (Math.sqrt((Math.pow(tView.x - bView.px[i], 2) + Math.pow(tView.y - bView.py[i], 2)))
                                <= tView.radius + bView.pr[i]) { // 원이 접할 경우 충돌
//                                  || Math.abs(tView.x - bView.getWidth()) >= tView.radius){
//                                || Math.abs(tView.y - bView.getHeight()) >= tView.radius) { // 원이 화면 밖으로 나갈 경우 충돌
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                            alertDialogBuilder.setTitle("Game over "); // AlertDialog 타이틀
                            alertDialogBuilder
                                    .setMessage(" Score : " + count + "\n" + " Retry? ") // 점수와 함께 출력
                                    .setCancelable(false)
                                    .setPositiveButton("게임 종료",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(
                                                        DialogInterface dialog, int id) { // 프로그램 종료
                                                    MainActivity.this.finish();
                                                }
                                            })
                                    .setNegativeButton("다시 하기",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(
                                                        DialogInterface dialog, int id) { // 다이얼로그 취소
                                                    dialog.cancel();
                                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                                    startActivity(intent);
                                                    finish();
                                                    // 재시작
                                                }
                                            });
                            AlertDialog alertDialog = alertDialogBuilder.create(); // 다이얼로그 생성
                            alertDialog.show(); // 다이얼로그 띄우기
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"위치를 먼저 지정해야 합니다.",
                            Toast.LENGTH_LONG).show();
                    tView.detmove = 0;

                }
            }
        });
    }
//
//    private Handler racingHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            if (detStage) {
//                level++;
//            }
//        }
//    }
}