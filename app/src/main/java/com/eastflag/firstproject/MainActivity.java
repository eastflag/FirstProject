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
import com.eastflag.firstproject.dynamic.Dynamic1Activity;
import com.eastflag.firstproject.dynamic.Dynamic2Activity;
import com.eastflag.firstproject.event.Event1Activity;
import com.eastflag.firstproject.event.Event2Activity;
import com.eastflag.firstproject.event.Event3Activity;
import com.eastflag.firstproject.event.Event4Activity;
import com.eastflag.firstproject.event.Event5Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(mClick);
        findViewById(R.id.button2).setOnClickListener(mClick);
        findViewById(R.id.button3).setOnClickListener(mClick);
        findViewById(R.id.button4).setOnClickListener(mClick);
        findViewById(R.id.button5).setOnClickListener(mClick);
        findViewById(R.id.button6).setOnClickListener(mClick);
        findViewById(R.id.button7).setOnClickListener(mClick);
        findViewById(R.id.button31).setOnClickListener(mClick);
        findViewById(R.id.button32).setOnClickListener(mClick);
        findViewById(R.id.button33).setOnClickListener(mClick);
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
                case R.id.button3:
                    intent = new Intent(MainActivity.this, Event1Activity.class);
                    startActivity(intent);
                    break;
                case R.id.button4:
                    intent = new Intent(MainActivity.this, Event2Activity.class);
                    startActivity(intent);
                    break;
                case R.id.button5:
                    intent = new Intent(MainActivity.this, Event3Activity.class);
                    startActivity(intent);
                    break;
                case R.id.button6:
                    intent = new Intent(MainActivity.this, Event4Activity.class);
                    startActivity(intent);
                    break;
                case R.id.button7:
                    intent = new Intent(MainActivity.this, Event5Activity.class);
                    startActivity(intent);
                    break;
                //버튼 동적 생성
                case R.id.button31:
                    intent = new Intent(MainActivity.this, Dynamic1Activity.class);
                    startActivity(intent);
                    break;
                case R.id.button32:
                    intent = new Intent(MainActivity.this, Dynamic2Activity.class);
                    startActivity(intent);
                    break;
                case R.id.button33:
//                    intent = new Intent(MainActivity.this, Event5Activity.class);
//                    startActivity(intent);
                    break;
            }
        }
    };
}
