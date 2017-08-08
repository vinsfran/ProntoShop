package py.com.fuentepy.prontoshop.ui.productlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;

import butterknife.ButterKnife;
import py.com.fuentepy.prontoshop.R;
import py.com.fuentepy.prontoshop.model.Product;

/**
 * Created by vinsfran on 08/08/17.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private List<Product> mProducts;
    private final Context mContext;

    public ProductListAdapter(List<Product> mProducts, Context mContext) {
        this.mProducts = mProducts;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.text_view_product_name) TextView productName;
        @BindView(R.id.text_view_product_category) TextView category;
        @BindView(R.id.text_view_product_description) TextView description;
        @BindView(R.id.image_view_add_to_cart_button) ImageView addToCartButton;
        @BindView(R.id.text_view_product_price) TextView productPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            addToCartButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
