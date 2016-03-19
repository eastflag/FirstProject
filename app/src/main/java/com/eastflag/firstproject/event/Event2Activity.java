package com.eastflag.firstproject.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eastflag.firstproject.R;

public class Event2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //토스트 메시지 띄우기
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
    }
}
