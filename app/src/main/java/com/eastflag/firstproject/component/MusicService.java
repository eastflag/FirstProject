package com.eastflag.firstproject.component;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.eastflag.firstproject.R;

import java.io.IOException;

public class MusicService extends Service {
    private MediaPlayer mMediaPlayer;
    private NotificationManager nm;

    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //미디어플레이어를 초기화
        nm = (NotificationManager) MusicService.this.getSystemService(Context.NOTIFICATION_SERVICE);
        mMediaPlayer = new MediaPlayer();

        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mMediaPlayer.start();
                startNoti();
            }
        });
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer arg0) {
                stopSelf();//서비스 종료
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            public void run() {
                try{
                    //미디어플레이어 재생
                    AssetFileDescriptor afd = getAssets().openFd("exid.mp3");
                    mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    mMediaPlayer.prepareAsync();
                } catch(IOException e) {
                    e.printStackTrace();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "service destroy..", Toast.LENGTH_SHORT).show();
        if(mMediaPlayer!= null && mMediaPlayer.isPlaying()){
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
        stopNoti();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void startNoti() {
        Intent i = new Intent(getApplicationContext(), PlayerActivity.class);
        int requestID = (int) System.currentTimeMillis();
        PendingIntent mPending = PendingIntent.getActivity(getApplicationContext(), requestID, i, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(getApplicationContext());
        Notification noti = builder.setContentTitle("Random Music Player")
                .setContentText("Music Service") //제목
                .setTicker("Music Service")
                .setSmallIcon(R.drawable.ic_stat_playing)
                .setContentIntent(mPending)
                .setOngoing(true)
                .build();
        nm.notify(9999, noti);
    }

    private void stopNoti() {
        nm.cancel(9999);
    }
}
