package com.example.tema8;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public abstract class MyIntentService extends IntentService {
 private static final String TAG = "MyIntentService";
 public MyIntentService(){
     super("MyIntentService");
 }
 @Override
 protected void onHandleIntent(Intent intent){
     for(int i = 1; i <= 5; i++){
         Log.d(TAG, "Ejecutando tarea: " + i);
         try{
             Thread.sleep(5000);
         }
         catch(InterruptedException e){
             e.printStackTrace();
         }
     }
     Log.d(TAG, "Tarea completada");
 }

 @Override
 public void onDestroy(){
     super.onDestroy();
     Log.d(TAG, "Servicio destruido");
 }
}
