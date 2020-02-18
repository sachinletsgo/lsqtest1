package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import static com.example.myapplication.Toaster.toaster;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SERVICE", Toaster.toaster(R.string.show_service_oncrete));
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        Log.d("SERVICE", Toaster.toaster(R.string.show_service_oncrete));
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
