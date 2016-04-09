package com.eastflag.firstproject.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.eastflag.FREE_BR")) {
            //사용자 메시지 수신
            Toast.makeText(context, "사용자메시지 수신", Toast.LENGTH_SHORT).show();
        } else if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
            //볼륨업다운
            //Toast.makeText(context, "volume changed", Toast.LENGTH_SHORT).show();
        }


    }
}
