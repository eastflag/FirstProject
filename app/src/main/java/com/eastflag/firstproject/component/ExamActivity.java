package com.eastflag.firstproject.component;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eastflag.firstproject.R;

import java.io.File;
import java.io.IOException;

public class ExamActivity extends Activity {

    public static final int GET_GALLERY = 100;
    public static final int GET_CONTACT = 200;
    public static final int GET_CAMERA = 300;
    private ImageView imgPicture;
    private TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        imgPicture = (ImageView) findViewById(R.id.imageView);
        tvDisplay = (TextView) findViewById(R.id.textView);

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
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 주소록 호출
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_PICK);
                intent.setData(ContactsContract.Contacts.CONTENT_URI);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intent, GET_CONTACT);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카메라 호출
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(getTempFile()));
                intent.putExtra("crop", "true");
                intent.putExtra("outputX", 600);
                intent.putExtra("outputY", 600);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                       //intent.putExtra("scale", true);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                startActivityForResult(intent, GET_CAMERA);
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
                    try {
                        Uri selectedImage = data.getData();
                        Log.d("LDK", selectedImage.toString());
                        //content://media/external/images/media/24143
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        //이미지화일의 실제 path 컬럼
                        Cursor cursor = getContentResolver().query(selectedImage,
                                filePathColumn, null, null, null);
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        if (columnIndex < 0) // no column index
                            return; // DO YOUR ERROR HANDLING
                        String picturePath = cursor.getString(columnIndex);
                        Log.d("LDK", "file path:" + picturePath);
                        //실제 경로에 접근해서 사진데이터를 가져와서 imageView에 뿌리기
                        Bitmap mBitmap = BitmapFactory.decodeFile(picturePath);
                        //샘플링 or 압축
                        imgPicture.setImageBitmap(mBitmap);
                    } catch(Exception e) {
                        Log.d("LDK", "error:" + e.getMessage());
                    }
                    break;
                case GET_CONTACT:
                    ContentResolver cr = getContentResolver();
                    Cursor phoneCur = cr.query(data.getData(), new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER,
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME},null, null, null);
                    while (phoneCur.moveToNext()) {
                        String phone = phoneCur.getString(0); //전화번호
                        String name = phoneCur.getString(1); //이름
                        tvDisplay.setText("phone:" + phone);
                        tvDisplay.append(" name:"+ name);
                    }
                    phoneCur.close();
                    break;
                case GET_CAMERA:
                    Bitmap bitmap2 = BitmapFactory.decodeFile(getTempFile().getAbsolutePath());
                    imgPicture.setImageBitmap(bitmap2);
                    break;
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private File getTempFile() {
        File f = new File(Environment.getExternalStorageDirectory(), "temp.jpg");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

}
