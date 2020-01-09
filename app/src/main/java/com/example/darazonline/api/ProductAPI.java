package com.example.darazonline.api;

import com.example.darazonline.models.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {

    @GET("daraz_products")
    Call<List<Products>> getallProduct();
}
