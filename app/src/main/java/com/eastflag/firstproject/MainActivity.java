package com.eastflag.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.eastflag.firstproject.activity.CctvActivity;
import com.eastflag.firstproject.activity.LinearActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(mClick);
        findViewById(R.id.button2).setOnClickListener(mClick);
    }

    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch (v.getId()) {
                case R.id.button1:
                    intent = new Intent(MainActivity.this, LinearActivity.class);
                    startActivity(intent);
                    break;
                case R.id.button2:
                    intent = new Intent(MainActivity.this, CctvActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
