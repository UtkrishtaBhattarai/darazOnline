package com.example.darazonline;

import androidx.appcompat.app.AppCompatActivity;
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
    List<Products> productsList = new ArrayList<>();
    ProductsAdapter productsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        recyclerView = findViewById(R.id.recyclerView);
        ProductsAdapter productsAdapter = new ProductsAdapter(this, productsList);
        recyclerView.setAdapter(productsAdapter);

        Retrofit retrofit=new Retrofit.Builder().baseUrl(Url.base_url).
                addConverterFactory(GsonConverterFactory.create()).build();

        ProductAPI productAPI=retrofit.create(ProductAPI.class);
        Call<List<Products>> listCall=productAPI.getAllEmployees();

        listCall.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                if (!response.isSuccessful())
                {
                    Toast.makeText(Dashboard.this, "Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                productsList=response.body();
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

                Toast.makeText(Dashboard.this, "Error message dekha", Toast.LENGTH_SHORT).show();
            }
        });

        productsList.add(new Products("Rajesh", "000", "jkaskjsa"));
        productsList.add(new Products("Sanju","2288","jjsa"));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
