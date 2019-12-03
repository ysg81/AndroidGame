package com.example.game;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

public class Block {

    public Rect block;
    protected Paint paint;
    Random random = new Random();

    int x = random.nextInt(1080);
    int y = random.nextInt(1600);
    int w = random.nextInt(150) + 50;
    int h = random.nextInt(150) + 50;

    public Block(int color){
        paint = new Paint();
        paint.setColor(color);
        block = new Rect();
    }

    public void draw(Canvas canvas){
        block.set(x, y, x + w, y + h);
        canvas.drawRect(block, paint);
    }
}
