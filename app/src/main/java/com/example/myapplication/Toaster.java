package com.example.myapplication;

import android.content.res.Resources;

import static com.example.myapplication.MainApplication.getContext;

public class Toaster {

    public static String  toaster(int value){
      return   getContext().getResources().getString(value);
    }
}
