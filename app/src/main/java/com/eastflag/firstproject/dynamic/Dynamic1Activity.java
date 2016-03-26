package com.eastflag.firstproject.dynamic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.eastflag.firstproject.R;

public class Dynamic1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic1);

        //1. 인스턴스 생성
        Button btn = new Button(this);

        //2. 뷰속성 설정

        //3. 배치 속성 설정

        //4. 부모에 배치
        LinearLayout root = (LinearLayout) findViewById(R.id.rootLayout);
        root.addView(btn);
    }
}
