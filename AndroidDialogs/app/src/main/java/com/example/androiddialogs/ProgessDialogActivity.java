package com.example.androiddialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class ProgessDialogActivity extends AppCompatActivity {

    Button b1, b2;
    ProgressDialog progressDialog;

 //   Handler handle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progess_dialog);

        b1 = findViewById(R.id.btn_pg);
        b2 = findViewById(R.id.btn_ring_pg);

        listener();
    }




    public void listener(){



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(ProgessDialogActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setTitle("Progess Dialog");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                progressDialog.setCancelable(true);

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(10000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        progressDialog.dismiss();


                    }
                }).start();

            }
        });





       b2.setOnClickListener(new View.OnClickListener() {


           Handler handle = new Handler() {
               public void handleMessage(Message msg) {
                   super.handleMessage(msg);
                   progressDialog.incrementProgressBy(2); // Incremented By Value 2

               }
           };


           @Override
           public void onClick(View view) {
               progressDialog = new ProgressDialog(ProgessDialogActivity.this);
               progressDialog.setMax(100); // Progress Dialog Max Value
               progressDialog.setMessage("Loading..."); // Setting Message
               progressDialog.setTitle("ProgressDialog"); // Setting Title
               progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); // Progress Dialog Style Horizontal
               progressDialog.show(); // Display Progress Dialog
               progressDialog.setCancelable(false);
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           while (progressDialog.getProgress() <= progressDialog.getMax()) {
                               Thread.sleep(200);
                               handle.sendMessage(handle.obtainMessage());
                               if (progressDialog.getProgress() == progressDialog.getMax()) {
                                   progressDialog.dismiss();
                               }
                           }
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
               }).start();
           }







       });




    }










}