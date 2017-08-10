package py.com.fuentepy.prontoshop.ui.checkout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import py.com.fuentepy.prontoshop.R;
import py.com.fuentepy.prontoshop.model.Customer;
import py.com.fuentepy.prontoshop.model.LineItem;

/**
 * Created by vinsfran on 10/08/17.
 */
public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {

    private List<LineItem> mLineItems;
    private final Context mContext;

    public CheckoutAdapter(List<LineItem> mLineItems, Context mContext) {
        this.mLineItems = mLineItems;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shopping_cart_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mLineItems != null) {
            return mLineItems.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        @BindView(R.id.product_image)
        ImageView productImage;
        @BindView(R.id.text_view_product_name)
        TextView productName;
        @BindView(R.id.text_view_product_price)
        TextView price;
        @BindView(R.id.edit_text_qty)
        EditText qtyEditText;
        @BindView(R.id.button_delete)
        Button deleteButton;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            deleteButton.setOnClickListener(this);
            qtyEditText.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //handle the change of Line Item Qty
                    LineItem item = mLineItems.get(getLayoutPosition());
                    updateQtyDialog(item);
                }
            });
        }

        @Override
        public void onClick(View view) {
        }

        @Override
        public boolean onLongClick(View view) {
            return true;
        }
    }

    private void updateQtyDialog(LineItem item) {
    }
}
