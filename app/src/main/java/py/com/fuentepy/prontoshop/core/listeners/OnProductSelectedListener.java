package py.com.fuentepy.prontoshop.core.listeners;

import py.com.fuentepy.prontoshop.model.Product;

/**
 * Created by vinsfran on 09/08/17.
 */
public interface OnProductSelectedListener {
    void onSelectedProduct(Product selectedProduct);
    void onLongClickProduct(Product clickedProduct);
}
