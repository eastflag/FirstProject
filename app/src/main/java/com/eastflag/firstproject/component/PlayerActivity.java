package com.eastflag.firstproject.component;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.eastflag.firstproject.R;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        findViewById(R.id.service_start).setOnClickListener(mClick);
        findViewById(R.id.service_end).setOnClickListener(mClick);
    }

    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(PlayerActivity.this, MusicService.class);
            switch (v.getId()) {
                case R.id.service_start:
                    startService(intent);
                    break;
                case R.id.service_end:
                    stopService(intent);
                    break;
            }
        }
    };
}