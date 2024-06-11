package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class Easy_peasy extends Activity {
    String ans = new String();
    Circle[] Circles;
    MyView view;
    int i = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new MyView(this);
        setContentView(view);
    }

    void init() {
        Circles= new Circle[4];

        final Random random = new Random();

        for (int j = 0; j < 4; j++) {

            int x = random.nextInt(view.getWidth());
            int y = random.nextInt(view.getHeight());
            int rad = random.nextInt(view.getHeight() / 2);
            int c = random.nextInt(3);
            int d = random.nextInt(4);
            int x1 = random.nextInt(view.getWidth());
            int y1 = random.nextInt(view.getHeight());
            ans=ans+"0";
            ans=ans+(d+"");
            Circle circle = new Circle(x,y,rad,c,d,x1,y1);
            Circles[j]=circle;
        }
        new CountDownTimer(1000 * (Circles.length+1), 1000) {
            public void onTick(long millisUntilFinished) {
                view.invalidate();
                if (i + 1 < Circles.length)
                    i++;
            }
            public void onFinish() {
                Intent intent = new Intent(Easy_peasy.this, Answer.class);
                intent.putExtra("ans", ans);
                startActivity(intent);
            }
        }.start();
    }

    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            init();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRGB(0,0,0);
            if (i < 0) return;

            if (Circles[i].d == 0) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.RED);
                canvas.drawCircle(Circles[i].x, Circles[i].y, Circles[i].rad, paint);
            }
            if (Circles[i].d == 1) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.GREEN);
                canvas.drawCircle(Circles[i].x, Circles[i].y, Circles[i].rad, paint);
            }
            if (Circles[i].d == 2) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.MAGENTA);
                canvas.drawCircle(Circles[i].x, Circles[i].y, Circles[i].rad, paint);
            }
            if (Circles[i].d == 3) {
                Paint paint = new Paint();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.CYAN);
                canvas.drawCircle(Circles[i].x, Circles[i].y, Circles[i].rad, paint);
            }


        }

    }



}
