package com.eastflag.firstproject.dynamic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eastflag.firstproject.R;

public class Dynamic3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic3);

        //item_book.xml을 inflate후 rootLayout에 붙이기,
        //제목을 변경
        LinearLayout root = (LinearLayout) findViewById(R.id.rootLayout);

        View view1 = View.inflate(this, R.layout.item_book, null);
        root.addView(view1);
        TextView tvTitle1 = (TextView) view1.findViewById(R.id.tvTitle);
        tvTitle1.setText("안드로이드 정복1");

        View view2 = View.inflate(this, R.layout.item_book, null);
        root.addView(view2);
        TextView tvTitle2 = (TextView) view2.findViewById(R.id.tvTitle);
        tvTitle2.setText("안드로이드 정복2");

        View view3 = View.inflate(this, R.layout.item_book, null);
        root.addView(view3);
        TextView tvTitle3 = (TextView) view3.findViewById(R.id.tvTitle);
        tvTitle3.setText("안드로이드 정복3");
    }
}
