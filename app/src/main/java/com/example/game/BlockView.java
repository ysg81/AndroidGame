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

    ArrayList<Block> block_list = new ArrayList<Block>();

    public BlockView(Context context) {
        super(context);
        for (int i = 0; i < 20; i++)
            block_list.add(new Block(Color.BLACK));
    }

    @Override
    public void onDraw(Canvas canvas) {
        for(int i = 0; i < block_list.size(); i++)
            block_list.get(i).draw(canvas);
        invalidate();
    }
}