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

import org.w3c.dom.Text;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {

    Context mContext;
    List<Products> productsList;

    public ProductsAdapter(Context mContext, List<Products> productsList) {
        this.mContext = mContext;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_product, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {

        final Products products=productsList.get(position);
        //holder.imageView2.setImageResource(products.getImage());
        holder.tvname.setText(products.getName());
        holder.tvprice.setText(products.getPrice());
        holder.description.setText(products.getDescription());
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView2;
        TextView tvname;
        TextView tvprice;
        TextView description;

        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView2=itemView.findViewById(R.id.imageView2);
            tvname=itemView.findViewById(R.id.tvname);
            tvprice=itemView.findViewById(R.id.tvprice);
            description=itemView.findViewById(R.id.tvdescription);

        }
    }
}


