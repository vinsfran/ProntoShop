package py.com.fuentepy.prontoshop.ui.productlist;

import java.util.List;

import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.data.SampleProductData;
import py.com.fuentepy.prontoshop.model.Category;
import py.com.fuentepy.prontoshop.model.Product;

/**
 * Created by vinsfran on 22/08/17.
 */
public class ProductInMemoryRepository implements ProductListContract.Repository {

    public ProductInMemoryRepository() {
    }

    @Override
    public List<Product> getAllProducts() {
        return SampleProductData.getSampleProducts();
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public void deleteProduct(Product product, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void addProduct(Product product, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void updateProduct(Product product, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }
}
