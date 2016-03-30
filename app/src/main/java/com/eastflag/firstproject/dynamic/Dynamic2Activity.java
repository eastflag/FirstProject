package com.eastflag.firstproject.dynamic;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eastflag.firstproject.R;

public class Dynamic2Activity extends AppCompatActivity {
    Button btnTab1, btnTab2, btnTab3;
    EditText etSend;
    Button btnSend;
    LinearLayout root;

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
        etSend = (EditText) findViewById(R.id.etSend);
        btnSend = (Button) findViewById(R.id.btnSend);
        root = (LinearLayout) findViewById(R.id.rootLayout);

        btnTab1.setSelected(true);

        btnTab1.setOnClickListener(mTabClick);
        btnTab2.setOnClickListener(mTabClick);
        btnTab3.setOnClickListener(mTabClick);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //edittext 내용을 root뷰에 동적으로 생성
               /* TextView tv = new TextView(Dynamic2Activity.this);
                tv.setText(etSend.getText().toString());

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.gravity = Gravity.RIGHT; //layout_gravity
                root.addView(tv, params);*/

                View view = View.inflate(Dynamic2Activity.this, R.layout.item_dynamic2, null);
                TextView tvText = (TextView) view.findViewById(R.id.tvText);
                tvText.setText(etSend.getText().toString());
                root.addView(view);

                //editText clear
                etSend.setText("");
                //키보드 내리기
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        });
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
