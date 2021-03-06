package com.eastflag.firstproject.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eastflag.firstproject.R;

public class Event1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1);

        Button btn1 = (Button) findViewById(R.id.button1);

        //1-2 리스너 생성 : myClick
        MyClick myClick = new MyClick();

        //2. 이벤트 발생자가 리스너에게 일을 위임
        btn1.setOnClickListener(myClick);

    }

    //1-1. 리스너(OnClickListener) 생성
    class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //토스트 메시지 띄우기
            Toast.makeText(Event1Activity.this, "clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
