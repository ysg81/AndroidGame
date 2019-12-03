package com.example.game;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.Random;

public class Block {

    public Rect block;
    protected Paint paint;
    Random random = new Random();

    int x = random.nextInt(1080);
    int y = random.nextInt(1600);
    int d = random.nextInt(150) + 50;

    public Block(int color){
        paint = new Paint();
        paint.setColor(color);
        block = new Rect();
    }

    public void draw(Canvas canvas){
        block.set(x, y, x + d, y + d);
        canvas.drawRect(block, paint);
    }
}
