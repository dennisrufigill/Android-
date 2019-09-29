package com.example.fileupload;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.buttton_file);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);
            }
        });

        try {
            throw new NullPointerException("Testing NPE");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        {
            if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
                //the image URI
                Uri selectedImage = data.getData();
                Toast.makeText(getApplicationContext(),""+selectedImage.toString(), Toast.LENGTH_SHORT).show();

                //calling the upload file method after choosing the file
                uploadFile(selectedImage, "My Image");
            }
        }
    }

    private void uploadFile(Uri fileUri, String desc){


        File file = new File(getRealPathFromURI(fileUri));


        RequestBody requestFile = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), file);
        RequestBody descBody = RequestBody.create(MediaType.parse("text/plain"), desc);


//        Gson gson = new GsonBuilder()
//                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ImageUpload.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ImageUpload imageUpload = retrofit.create(ImageUpload.class);

        Call<ResponseBody> call = imageUpload.uploadImage(requestFile,descBody);


        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (!response.body()) {
//                    Toast.makeText(getApplicationContext(), "File Uploaded Successfully...", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Some error occurred...", Toast.LENGTH_LONG).show();
//                }
                if(response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "File Uploaded Successfully...", Toast.LENGTH_LONG).show();
                    try {
                        Log.e("Success", "response: "+response.body().string() );
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("Success", "response unknown");
                    }
                }else{
                    try {
                        if(response.errorBody()!= null && response.errorBody().string()!=null) {
                            Toast.makeText(MainActivity.this, "Error Reason: "+response.errorBody().string(), Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Error Reason unknown ", Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error Reason unknown ", Toast.LENGTH_SHORT).show();
                    }


                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("error", "onFailure: "+t.toString() );
            }
        });

    }


    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(this, contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }




}


