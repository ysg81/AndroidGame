package com.example.game;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class TargetView extends View {

    Paint paint = new Paint();
    private int mViewWidth = 0;
    private int mViewHeight = 0;

    float x = -1, y = -1;// 터치한 곳을 지정할 변수
    float radius = 60;
    int moveable = 0;
    int detmove = 0;

    public TargetView(Context context) {
        super(context);
        initView();
    }
    public TargetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    public TargetView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }
    private void initView() {
        paint.setColor(Color.RED);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mViewWidth = MeasureSpec.getSize(widthMeasureSpec);
        mViewHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(mViewWidth, mViewHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        if(x>0 && y>0)
            canvas.drawCircle(x - 5, y - 5, radius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            if(moveable == 0) { // Button을 누르기 전 위치변경에 대한 x, y값 받기
                x = event.getX();
                y = event.getY();
                invalidate();
                detmove = 1; // 터치를 하면 detmove 1 반환
            }
        }
        return true;
    }
}