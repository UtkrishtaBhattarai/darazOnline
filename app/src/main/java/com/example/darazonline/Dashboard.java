package com.example.darazonline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.darazonline.api.ProductAPI;
import com.example.darazonline.models.Products;
import com.example.darazonline.url.Url;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dashboard extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        recyclerView = findViewById(R.id.recyclerView);
        getProduct();

    }

    // product json
    public void getProduct() {
        ProductAPI retrofitProductAPI = Url.getRetrofit().create(ProductAPI.class);
        Call<List<Products>> ProductsCall = retrofitProductAPI.getallProduct();
        ProductsCall.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                System.out.println("Product list " + response.body());
                ProductsAdapter recyclerviewAdapter = new ProductsAdapter(getApplicationContext(), response.body());
                RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(getApplicationContext(), 3);
                recyclerView.setLayoutManager(mlayoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(recyclerviewAdapter);
                recyclerviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }
}