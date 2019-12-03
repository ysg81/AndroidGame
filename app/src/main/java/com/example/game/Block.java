package com.example.game;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.Random;

public class Block {

    public RectF block;
    protected Paint paint;
    Random random = new Random();

    float x = random.nextInt(1080);
    float y = random.nextInt(1600);
    float r = random.nextInt(150) + 50;

    public Block(int color){
        paint = new Paint();
        paint.setColor(color);
        block = new RectF();
    }

    public void draw(Canvas canvas){
        canvas.drawCircle(x, y, r, paint);
    }
}
