package com.example.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Dimension;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class BlockView extends View {

    public static final int index = 30;

    float[] px = new float[index]; // Block의 중심 x 좌표
    float[] py = new float[index]; // Block의 중심 y 좌표
    float[] pr = new float[index]; // Block의 반지름

    ArrayList<Block> block_list = new ArrayList<Block>(); // array를 이용한 Block객체 선언

    public BlockView(Context context) {
        super(context);
        for (int i = 0; i < index; i++) {
            block_list.add(new Block(Color.BLACK)); // Block 객체 배열 추가
        }
    } // Block 객체 배열 추가

    @Override
    public void onDraw(Canvas canvas) {
        for(int i = 0; i < block_list.size(); i++) {
            block_list.get(i).draw(canvas); // draw 구현
            px[i] = block_list.get(i).x;
            py[i] = block_list.get(i).y;
            pr[i] = block_list.get(i).r;
        } // 각각의 객체 배열에 대한 px, py, pr의 값을 받아서 저장
        invalidate();
    }
}
