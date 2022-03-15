package com.example.tuan5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.tuan5.Product;
import com.example.tuan5.R;
import java.util.List;

public class ProductApdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Product> listProduct;
    private int positionSelect = -1;

    public ProductApdapter(Context context, int idLayout, List<Product> listProduct) {
        this.context = context;
        this.idLayout = idLayout;
        this.listProduct = listProduct;
    }



    @Override
    public int getCount() {
        if (listProduct.size() != 0 && !listProduct.isEmpty()) {
            return listProduct.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }
        TextView tvmoTa = convertView.findViewById(R.id.txtAbout);
        TextView tvProductName = (TextView) convertView.findViewById(R.id.txtName);
        TextView tvProductPrice = (TextView) convertView.findViewById(R.id.txtPrice);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);



        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "", Toast.LENGTH_SHORT).show();

                notifyDataSetChanged();
            }
        });


        final Product product = listProduct.get(position);


        if (listProduct != null && !listProduct.isEmpty()) {
            tvmoTa.setText(product.getAbout());
            tvProductName.setText(product.getName());
            imageView.setImageResource(product.getImg());
            tvProductPrice.setText(product.getPrice());
        }
        return convertView;




    }
}

