package py.com.fuentepy.prontoshop.ui.productlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;

import butterknife.ButterKnife;
import py.com.fuentepy.prontoshop.R;
import py.com.fuentepy.prontoshop.core.listeners.OnProductSelectedListener;
import py.com.fuentepy.prontoshop.model.Product;
import py.com.fuentepy.prontoshop.util.Formatter;

/**
 * Created by vinsfran on 08/08/17.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private List<Product> mProducts;
    private final Context mContext;
    private final OnProductSelectedListener mListener;

    public ProductListAdapter(List<Product> mProducts, Context mContext, OnProductSelectedListener mListener) {
        this.mProducts = mProducts;
        this.mContext = mContext;
        this.mListener = mListener;
    }

    public void replaceData(List<Product> products) {
        mProducts = products;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mProducts != null) {
            Product product = mProducts.get(position);
            Picasso.with(mContext)
                    .load(product.getImagePath())
                    .fit()
                    .placeholder(R.drawable.default_image)
                    .into(holder.productImage);
            holder.productName.setText(product.getProductName());
            holder.category.setText(product.getCategoryName());
            holder.productPrice.setText(Formatter.formatCurrency(product.getSalePrice()));
            String productDescription = product.getDescription();
            String shortDescription = productDescription.substring(0, Math.min(productDescription.length(), 70));
            holder.description.setText(shortDescription);
        }
    }

    @Override
    public int getItemCount() {
        if (mProducts != null) {
            return mProducts.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        @BindView(R.id.product_image)
        ImageView productImage;
        @BindView(R.id.text_view_product_name)
        TextView productName;
        @BindView(R.id.text_view_product_category)
        TextView category;
        @BindView(R.id.text_view_product_description)
        TextView description;
        @BindView(R.id.image_view_add_to_cart_button)
        ImageView addToCartButton;
        @BindView(R.id.text_view_product_price)
        TextView productPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            addToCartButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Product selectedProduct = mProducts.get(getLayoutPosition());
            mListener.onSelectedProduct(selectedProduct);
        }

        @Override
        public boolean onLongClick(View view) {
            Product clickedProduct = mProducts.get(getLayoutPosition());
            mListener.onLongClickProduct(clickedProduct);
            return true;
        }
    }
}
