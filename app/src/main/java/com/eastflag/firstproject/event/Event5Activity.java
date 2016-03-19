package com.eastflag.firstproject.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;

import com.eastflag.firstproject.R;

public class Event5Activity extends AppCompatActivity {
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event5);

        //체크박스를 체크 : '체크되었습니다.
        //체크박스를 체크 해제: '체크가 해제되었습니다.' 라고 표시

        //초기화
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        //이벤트 위임
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    checkBox.setText("체크되었습니다.");
                } else {
                    checkBox.setText("체크가 해제되었습니다.");
                }
            }
        });

        //토글버튼 이벤트 처리 =>하단 텍스트뷰에 체크 유무를 표시

        //DataPicker 이벤트 처리
        DatePicker picker = (DatePicker) findViewById(R.id.datePicker);
        final TextView tv9 = (TextView) findViewById(R.id.textView9);

        //3개 파라메터는 초기 연-월-일 정보, 4번째 파라메터가 리스너
        picker.init(2010, 1, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                tv9.setText(String.format("%d-%02d-%02d", year, monthOfYear, dayOfMonth));
            }
        });
    }
}
