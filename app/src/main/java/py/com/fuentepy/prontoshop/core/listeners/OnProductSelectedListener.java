package py.com.fuentepy.prontoshop.core.listeners;

import py.com.fuentepy.prontoshop.models.Product;

/**
 * Created by vinsfran on 09/08/2017.
 */
public interface OnProductSelectedListener {
    void onSelectProduct(Product selectedProduct);

    void onLongClickProduct(Product clickedProduct);
}
