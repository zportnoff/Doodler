package com.example.zach.doodler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.util.Log;
import android.widget.Toast;


import java.util.Random;
import java.util.jar.Attributes;

/**
 * Created by Zach on 3/10/2016.
 */


public  class DoodleView  extends View{
    static private final String TAG = "doodle";
    static boolean fancy = false;


    public static Paint paintDoodle = new Paint();
    public static Path path = new Path();

    public DoodleView(Context context) {
        super(context);
        init(null,0);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0);
    }
    public DoodleView(Context context, AttributeSet attrs, int defStyle) {
        super(context);
        init(attrs,defStyle);
    }

    private void init( AttributeSet attrs, int defStyle){
        paintDoodle.setColor(Color.RED);
        paintDoodle.setAntiAlias(true);
        paintDoodle.setStyle(Paint.Style.STROKE);
        paintDoodle.setStrokeWidth(10);

    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paintDoodle);

        if(fancy) {
            Log.i(TAG, "TESTTESTSETSETTTESTESTESTTESTTESTESTTESSETTESESTTESSETETS");
            Random rand = new Random();
            switch(rand.nextInt(7)+1){
                case 1:
                    paintDoodle.setColor(Color.BLACK);
                    Log.i(TAG, "Black");
                    break;
                case 2:
                    paintDoodle.setColor(Color.RED);
                    Log.i(TAG, "Red");
                    break;
                case 3:
                    paintDoodle.setColor(Color.GREEN);
                    Log.i(TAG, "Green");
                    break;
                case 4:
                    paintDoodle.setColor(Color.BLUE);
                    Log.i(TAG, "Blue");
                    break;
                case 5:
                    paintDoodle.setColor(Color.MAGENTA);
                    Log.i(TAG, "Mag");
                    break;
                case 6:
                    paintDoodle.setColor(Color.CYAN);
                    Log.i(TAG, "Cyan");
                    break;
                case 7:
                    paintDoodle.setColor(Color.YELLOW);
                    Log.i(TAG, "Yellow");
                    break;
            }

        }



    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
            invalidate();
            return true;

    }
    public static void setBrushSize(int size){
        paintDoodle.setStrokeWidth(size);
       // Log.i(TAG, String.valueOf(size));

    }

    public static void setColor(String color){

        switch (color){
            case "red":
                paintDoodle.setColor(Color.RED);
                break;
            case "green":
                paintDoodle.setColor(Color.GREEN);
                break;
            case "yellow":
                paintDoodle.setColor(Color.YELLOW);
                break;
            case "magenta":
                paintDoodle.setColor(Color.MAGENTA);
                break;
            case "blue":
                paintDoodle.setColor(Color.BLUE);
                break;
            case "black":
                paintDoodle.setColor(Color.BLACK);
                break;



        }

    }

    public static void setOpacity(double op){
        int number = (int)(255 * (op/100));
        paintDoodle.setAlpha(number);
    }

    public static void clear(){
        //paintDoodle = new Paint();
        path = new Path();

    }

    public static void getFancy(Context context){
        fancy = !fancy;
        if (fancy) {
            Toast.makeText(context, "Try Drawing!!!", Toast.LENGTH_LONG).show();
        }

    }

}
