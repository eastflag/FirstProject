package com.eastflag.firstproject.component;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.eastflag.firstproject.R;

public class ImplicityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicity);

        findViewById(R.id.button1).setOnClickListener(mClick);
    }

    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.button1:
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:010-1234-1234"));
                    startActivity(intent);
                    break;
            }
        }
    };
}
