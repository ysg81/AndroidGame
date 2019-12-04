package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TargetView tView = findViewById(R.id.tview);
        final BlockView bView = new BlockView(this);
        LayoutInflater inflater = getLayoutInflater();
        addContentView(bView, new LinearLayout.LayoutParams(1080, 1920));

        Button blow_btn = (Button) findViewById(R.id.blow_btn); // 버튼 선언
        blow_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: // 버튼을 꾹 누르고 있을 경우
                        mHandler = new Handler();
                        mHandler.postDelayed(mAction, 5);
                        break;
                    case MotionEvent.ACTION_UP: // 버튼에서 손을 뗄 경우
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        break;
                }
                return false;
            }
            Runnable mAction = new Runnable() {
                @Override public void run() {
                    if (tView.detmove == 1) { // 버튼 누르기 가능
                        int a = 0;
                        a += 6;
                        tView.radius = tView.radius + a;
                        tView.invalidate();
                        tView.moveable = 1; // 버튼이 누르고 난 후 위치변경 불가
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
                            } else
                                count += 1; // socre 카운트
                        }
                    } else { // 버튼을 먼저 누를 경우 위치 지정 알림 메세지
                        Toast.makeText(getApplicationContext(), "위치를 먼저 지정해야 합니다.",
                                Toast.LENGTH_LONG).show();
                        tView.detmove = 0;
                        mHandler.postDelayed(this, 500);
                    }
                    mHandler.postDelayed(this, 10);
                }
            };
        });
    }
//        blow_btn.setOnClickListener(new View.OnClickListener() { // Listener 함수
//            @Override
//            public void onClick(View v) {
//                if (tView.detmove == 1) { // 버튼 누르기 가능
//                    int a = 0;
//                    a += 8;
//                    tView.radius = tView.radius + a;
//                    tView.invalidate();
//                    tView.moveable = 1; // 버튼이 누르고 난 후 위치변경 불가
//                    for (int i = 0; i < 30; i++) {
//                        if (Math.sqrt((Math.pow(tView.x - bView.px[i], 2) + Math.pow(tView.y - bView.py[i], 2)))
//                                <= tView.radius + bView.pr[i]) { // 원이 접할 경우 충돌
////                                  || Math.abs(tView.x - bView.getWidth()) >= tView.radius){
////                                || Math.abs(tView.y - bView.getHeight()) >= tView.radius) { // 원이 화면 밖으로 나갈 경우 충돌
//                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
//                            alertDialogBuilder.setTitle("Game over "); // AlertDialog 타이틀
//                            alertDialogBuilder
//                                    .setMessage(" Score : " + count + "\n" + " Retry? ") // 점수와 함께 출력
//                                    .setCancelable(false)
//                                    .setPositiveButton("게임 종료",
//                                            new DialogInterface.OnClickListener() {
//                                                public void onClick(
//                                                        DialogInterface dialog, int id) { // 프로그램 종료
//                                                    MainActivity.this.finish();
//                                                }
//                                            })
//                                    .setNegativeButton("다시 하기",
//                                            new DialogInterface.OnClickListener() {
//                                                public void onClick(
//                                                        DialogInterface dialog, int id) { // 다이얼로그 취소
//                                                    dialog.cancel();
//                                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                                                    startActivity(intent);
//                                                    finish();
//                                                    // 재시작
//                                                }
//                                            });
//                            AlertDialog alertDialog = alertDialogBuilder.create(); // 다이얼로그 생성
//                            alertDialog.show(); // 다이얼로그 띄우기
//                        }
//                        else
//                            count += 1; // socre 카운트
//                    }
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"위치를 먼저 지정해야 합니다.",
//                            Toast.LENGTH_LONG).show();
//                    tView.detmove = 0;
//
//                }
//            }
//        });
//    }
}