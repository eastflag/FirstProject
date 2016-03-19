package com.eastflag.firstproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.eastflag.firstproject.R;

public class LinearActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        img = (ImageView) findViewById(R.id.imageView);
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(mClick);
        findViewById(R.id.button2).setOnClickListener(mClick);
        findViewById(R.id.button3).setOnClickListener(mClick);
    }

    //리스너 생성 & imageView의 src 속성을 change 하는 setter 함수로 속성을 변경
    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.button1:
                    //coffee1번 이미지로 교체
                    img.setImageResource(R.drawable.coffee1);
                    break;
                case R.id.button2:
                    //coffee2번 이미지로 교체
                    img.setImageResource(R.drawable.coffee2);
                    break;
                case R.id.button3:
                    //coffee3번 이미지로 교체
                    img.setImageResource(R.drawable.coffee3);
                    break;
            }
        }
    };

}
