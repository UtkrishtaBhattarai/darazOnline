package com.example.darazonline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.darazonline.models.Products;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder>{

    Context context;
    List<Products> Productss;

    public ProductsAdapter(Context context, List<Products> Productss) {
        this.context = context;
        this.Productss = Productss;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_product_recyclerview,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //// getting data according to position
        final Products Products = Productss.get(position);

        holder.txt_item_product_name.setText(Products.getProduct_name());
        holder.txt_item_product_price.setText(Products.getProduct_price());
       // holder.item_product_image.setTe(Products.getProduct_image());
        // get Product Image
        Picasso.get()
                .load("http://www.piyushp.com.np/sport_fanatic/api/member/image/daraz_image/product/"+Products.getProduct_image())
                .placeholder(R.drawable.ic_launcher_background)
                .resize(220, 220)
                .centerCrop()
                .into(holder.item_product_image);
    }

    @Override
    public int getItemCount() {
        return Productss.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_item_product_name,txt_item_product_price;
        ImageView item_product_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_item_product_name = itemView.findViewById(R.id.txtProductName);
            txt_item_product_price = itemView.findViewById(R.id.txtPrice);
            item_product_image = itemView.findViewById(R.id.imgProduct);
        }
    }
}    