package com.example.fileuploadpractice;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;

    Uri selectedImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn_upload);
        button2 = findViewById(R.id.btn_sendData);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                // intent.putExtra("path",selectedImage);
                //intent.putExtra("path",)
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //    Toast.makeText(getApplicationContext(), "Clicked",Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 100);

            }
        });

//        try {
//            throw new NullPointerException("Testing NPE");
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        //requestCode == 100 && resultCode == RESULT_OK && data != null
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

            // Uri selectedImage = data.getData();

            selectedImage = data.getData();

            Toast.makeText(getApplicationContext(), "" + selectedImage.toString(), Toast.LENGTH_SHORT).show();


            uploadFile(selectedImage);


        }
    }

    private void uploadFile(Uri fileUri) {

        File file = new File(getRealPathFromURI(fileUri));

        RequestBody requestFile = RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), file);

        RequestBody in = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("uploaded_file", file.getName(), in);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ImageUpload.BASE_URL)
                .build();

        ImageUpload imageUpload = retrofit.create(ImageUpload.class);

        Call<ResponseBody> call = imageUpload.uploadImage(body);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {

                    try {
                        String resp = response.body().string();
                        Log.e("Success", "response" +response );

                        try {
                            JSONObject jsonObject = new JSONObject(resp);

                            if (jsonObject.has("status")) {
                                String status = jsonObject.getString("status");

                                if (status.equalsIgnoreCase("true")) {

                                    Toast.makeText(getApplicationContext(), "File Uploaded Successfully", Toast.LENGTH_SHORT).show();
                                    if (jsonObject.has("link")) {
                                        String link = jsonObject.getString("link");
                                        Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                                        intent.putExtra("key", link);
                                        startActivity(intent);
                                    }

                                } else {


                                    Toast.makeText(getApplicationContext(), "File NOT Uploaded ", Toast.LENGTH_SHORT).show();
                                    Log.e("Success", "Response Error");

                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    } catch (IOException e) {
                        e.printStackTrace();

                        Log.e("Success", "Response Error");

                    }

//                    Gson gson = new Gson();
//                    gson.fromJson(path,MainActivity.class);
//


                }

//               String path =  response.toString();
//
//                Gson gson = new Gson();
//             //  gson.fromJson(path);


                else {
                    try {
                        if (response.errorBody() != null && response.errorBody().string() != null) {
                            Toast.makeText(MainActivity.this, "Error Reason" + response.errorBody().string(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Error Reasons are unknown", Toast.LENGTH_SHORT).show();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error Reason unknown ", Toast.LENGTH_SHORT).show();
                    }

                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("error", "onFailure :" + t.toString());
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
