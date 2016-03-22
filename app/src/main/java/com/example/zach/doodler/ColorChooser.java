package com.example.zach.doodler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorChooser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_chooser);

        Button red = (Button) findViewById(R.id.Red);
        Button green = (Button) findViewById(R.id.Green);
        Button yellow = (Button) findViewById(R.id.Yellow);
        Button black = (Button) findViewById(R.id.Black);
        Button blue = (Button) findViewById(R.id.Blue);
        Button magenta = (Button) findViewById(R.id.Magenta);


        red.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ret = new Intent();
                setResult(RESULT_OK, ret);
                finish();
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ret = new Intent();
                ret.putExtra("color","blue");
                setResult(RESULT_OK, ret);
                finish();
            }
        });
        green.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ret = new Intent();
                ret.putExtra("color","green");
                setResult(RESULT_OK, ret);
                finish();
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ret = new Intent();
                ret.putExtra("color","yellow");
                setResult(RESULT_OK, ret);
                finish();
            }
        });
        magenta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ret = new Intent();
                ret.putExtra("color","magenta");
                setResult(RESULT_OK, ret);
                finish();
            }
        });
        black.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ret = new Intent();
                ret.putExtra("color","black");
                setResult(RESULT_OK, ret);
                finish();
            }
        });

    }


}
