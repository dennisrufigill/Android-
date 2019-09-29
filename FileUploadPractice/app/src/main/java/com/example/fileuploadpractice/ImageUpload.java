package com.example.fileuploadpractice;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ImageUpload {


    String BASE_URL = "http://10.0.0.87/file_upload_sample/";


    @Multipart
    @POST("file_upload.php")
        // Call<ResponseBody> uploadImage (@Part("image\"; filename=\"uploaded_file\" ") RequestBody file);

    Call<ResponseBody> uploadImage(@Part MultipartBody.Part file);


}
