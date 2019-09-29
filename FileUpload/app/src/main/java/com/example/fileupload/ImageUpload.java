package com.example.fileupload;

import org.json.JSONObject;

import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ImageUpload {

    String BASE_URL= "http://www.androidexample.com/";
    String  uploadFileName = "loading.png";


    @Multipart
    @POST("media/UploadToServer.php")
    Call<ResponseBody> uploadImage(@Part("image\"; filename=\"loading.png\" ") RequestBody file, @Part("desc") RequestBody desc);

}



