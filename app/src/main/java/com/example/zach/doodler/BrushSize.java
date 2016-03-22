package com.example.zach.doodler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.util.Log;


public class BrushSize extends AppCompatActivity {
    static private final String TAG = "doodle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_size);
        final EditText edit = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent ret = new Intent();
                String num = edit.getText().toString();

                ret.putExtra("size", num);
                setResult(RESULT_OK, ret);
                finish();
            }
        });



    }
}
