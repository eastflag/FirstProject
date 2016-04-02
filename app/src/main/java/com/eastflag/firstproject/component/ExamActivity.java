package com.eastflag.firstproject.component;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.eastflag.firstproject.R;

public class ExamActivity extends Activity {

    public static final int GET_GALLERY = 100;
    private ImageView imgPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        imgPicture = (ImageView) findViewById(R.id.imageView);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 1) 갤러리 호출
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, GET_GALLERY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            switch(requestCode) {
                case GET_GALLERY:
                    // 주소록 데이터 처리
                    //Content Provider를 이용해서 MediaDB 사진 데이터의 실제 path 가져오기
                    Uri selectedImage = data.getData();
                    Log.d("LDK", selectedImage.toString());
                     //content://media/external/images/media/24143
                     String[] filePathColumn = { MediaStore.Images.Media.DATA };
                     //이미지화일의 실제 path 컬럼
                     Cursor cursor = getContentResolver().query(selectedImage,
                             filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    if(columnIndex < 0) // no column index
                        return; // DO YOUR ERROR HANDLING
                    String picturePath = cursor.getString(columnIndex);
                    Log.d("LDK", "file path:" + picturePath);
                    //실제 경로에 접근해서 사진데이터를 가져와서 imageView에 뿌리기
                    Bitmap mBitmap = BitmapFactory.decodeFile(picturePath);
                    imgPicture.setImageBitmap(mBitmap);
                    break;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
