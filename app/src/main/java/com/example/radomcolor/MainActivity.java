package com.example.radomcolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.graphics.Color;

import java.util.Random;


public class MainActivity extends AppCompatActivity {


    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    TextView txv;
    ConstraintLayout currentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         txv = findViewById(R.id.txv);
        currentLayout = findViewById(R.id.back);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    //ref from:https://stackoverflow.com/questions/6645537/how-to-detect-the-swipe-left-or-right-in-android?fbclid=IwAR2lQ5dvUe3XrpaEcyyJW9HmNfhcagynlLTsB-1OGf1t17aVr3XNIrgdSzU
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;
                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    if (x2 > x1)
                    {

                        Random x = new Random();
                        int red = x.nextInt(256);
                        int green = x.nextInt(256);
                        int blue = x.nextInt(256);

                        currentLayout.setBackgroundColor(Color.rgb(red,green,blue));

                        txv.setText("右移");
                    }

                    else
                    {
                        txv.setText("左移");
                        Random x = new Random();
                        int red = x.nextInt(256);
                        int green = x.nextInt(256);
                        int blue = x.nextInt(256);
                        txv.setTextColor(Color.rgb(red,green,blue));


                    }

                }
                else
                {
                    // consider as something else - a screen tap for example
                }
                break;
        }
        return super.onTouchEvent(event);
    }





}

