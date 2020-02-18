package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Annotion.AnnotationTest;
import com.example.myapplication.Annotion.Logger;
import com.example.myapplication.Annotion.LoggerMain;

import java.lang.annotation.Annotation;

public class MainActivity extends AppCompatActivity {

    //    private CameraKitView cameraKitView;
    String s = "Jai ho ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoggerMain.initLogger(MainActivity.class);
//        cameraKitView = findViewById(R.id.camera);
        (findViewById(R.id.btn_service)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sendWhatsApp();
//                sendWhatsapp2(MainActivity.this);
//                startActivity(new Intent(MainActivity.this, Main2Activity.class));

                AnnotationTest aT = new AnnotationTest();
                Class c = aT.getClass();

                Annotation aa = c.getDeclaredMethods()[0].getAnnotation(Logger.class);

                Logger logger = (Logger) aa;

                logger.value();

                Log.d(logger.tag(), logger.value());

            }
        });

//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }

//    private void captureImage() {
//        cameraKitView.captureImage(new CameraKitView.ImageCallback() {
//            @Override
//            public void onImage(CameraKitView cameraKitView, byte[] capturedImage) {
//                File savedPhoto = new File(Environment.getExternalStorageDirectory(), "photo.jpg");
//                Toast.makeText(MainActivity.this,Environment.getExternalStorageDirectory()+"photo.jpg",Toast.LENGTH_LONG).show();
//                try {
//                    FileOutputStream outputStream = new FileOutputStream(savedPhoto.getPath());
//                    outputStream.write(capturedImage);
//                    outputStream.close();
//                } catch (java.io.IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//
//    }
//
//
//
//    private void sendWhatsapp2(Context context) {
//        boolean isAV =isWhatsAppAvailable(context);
//        String phone = "918802110378,91735305077";
//        String message = "918802110378 jai mata di";
//        PackageManager packageManager = context.getPackageManager();
//        Intent i = new Intent(Intent.ACTION_VIEW);
//
//        try {
//            String url = "https://api.whatsapp.com/send?phone="+ phone +"&text=" + URLEncoder.encode(message, "UTF-8");
//            i.setPackage("com.whatsapp");
//            i.setData(Uri.parse(url));
//            if (i.resolveActivity(packageManager) != null) {
//                context.startActivity(i);
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    private void sendWhatsApp() {
//        String smsNumber = "918802110378"; // E164 format without '+' sign
//        Intent sendIntent = new Intent(Intent.ACTION_SEND);
//        sendIntent.setType("text/plain");
//        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
//        sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
//        sendIntent.setPackage("com.whatsapp.w4b");
//        startActivity(sendIntent);
//    }
//
//    public  boolean isWhatsAppAvailable(Context context) {
//
////        PackageManager packageManager = context.getPackageManager();
////        Intent i = new Intent(Intent.ACTION_VIEW);
////        try {
////            i.setPackage("com.whatsapp");
////            if (i.resolveActivity(packageManager) != null) {
////                return true;
////            }
////        } catch (Exception e){
////            e.printStackTrace();
////        }
////        return false;
//
//        PackageManager pm = getPackageManager();
//        boolean app_installed;
//        try {
//            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES);
//            app_installed = true;
//        }
//        catch (PackageManager.NameNotFoundException e) {
//            app_installed = false;
//        }
//        return app_installed;
//    }
//

    @Logger(tag = "MainActivityTEST", value = "onStart")
    @Override
    protected void onStart() {
        super.onStart();
//        cameraKitView.onStart();

    }

    @Logger(tag = "MainActivityTEST", value = "onResume")
    @Override
    protected void onResume() {
        super.onResume();
//        cameraKitView.onResume();
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void testMethod() {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        cameraKitView.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putString("keys", s + "HO gaya");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        s = savedInstanceState.getString("keys");
    }
}
