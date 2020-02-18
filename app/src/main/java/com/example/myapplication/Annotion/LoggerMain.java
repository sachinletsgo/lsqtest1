package com.example.myapplication.Annotion;

import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class LoggerMain {

//    Object obj;
//
//    public LoggerMain(Object object) {
//        Object obj = object;
//    }


    public static void initLogger(Class cls) {
        try {

            for (Method m : cls.getDeclaredMethods()) {

                Annotation aa = m.getAnnotation(Logger.class);
                if (aa != null) {
                    Logger logger = (Logger) aa;

                    Log.d(logger.tag(), logger.value());
                }
            }

//            Annotation aa= cls.getDeclaredMethods()[3].getAnnotation(Logger.class);


        } catch (Exception e) {
            Log.d("MainActivityTEST", "Error " + e.getMessage());
        }
    }
}
