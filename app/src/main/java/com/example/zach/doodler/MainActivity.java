package com.example.zach.doodler;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    static private final String TAG = "doodle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton button = (ToggleButton) findViewById(R.id.toggleButton);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DoodleView.getFancy(MainActivity.this.getBaseContext());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.brushsize:
                Intent brushIntent = new Intent(this, BrushSize.class);
                this.startActivityForResult(brushIntent, 1);
                break;
            case R.id.color:
                Intent colorIntent = new Intent(this, ColorChooser.class);
                this.startActivityForResult(colorIntent, 2);
                break;
            case R.id.opacity:
                Intent opacityIntent = new Intent(this, Opacity.class);
                this.startActivityForResult(opacityIntent, 3);
                break;
            case R.id.clear:
                DoodleView.clear();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int size = Integer.parseInt((String) data.getExtras().get("size"));
                Log.i(TAG, String.valueOf(size));

                DoodleView.setBrushSize(size);


            }
        }
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                DoodleView.setColor(data.getExtras().get("color").toString());
            }
        }
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {
                int op = Integer.parseInt((String) data.getExtras().get("op"));
                Log.i(TAG, String.valueOf(op));
                DoodleView.setOpacity(op);

            }
        }
    }
}
