package com.eastflag.firstproject.dynamic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eastflag.firstproject.R;

public class Dynamic2Activity extends AppCompatActivity {
    Button btnTab1, btnTab2, btnTab3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic2);

        init();
    }

    private void init() {
        btnTab1 = (Button) findViewById(R.id.btnTab1);
        btnTab2 = (Button) findViewById(R.id.btnTab2);
        btnTab3 = (Button) findViewById(R.id.btnTab3);

        btnTab1.setSelected(true);

        btnTab1.setOnClickListener(mTabClick);
        btnTab2.setOnClickListener(mTabClick);
        btnTab3.setOnClickListener(mTabClick);
    }

    View.OnClickListener mTabClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            btnTab1.setSelected(false);
            btnTab2.setSelected(false);
            btnTab3.setSelected(false);
            switch (v.getId()) {
                case R.id.btnTab1:
                    btnTab1.setSelected(true);
                    break;
                case R.id.btnTab2:
                    btnTab2.setSelected(true);
                    break;
                case R.id.btnTab3:
                    btnTab3.setSelected(true);
                    break;
            }
        }
    };
}
