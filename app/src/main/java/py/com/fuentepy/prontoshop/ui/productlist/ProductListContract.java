package py.com.fuentepy.prontoshop.ui.productlist;

import java.util.List;

import py.com.fuentepy.prontoshop.model.Category;
import py.com.fuentepy.prontoshop.model.Product;

/**
 * Created by vinsfran on 21/08/17.
 */
public interface ProductListContract {

    public interface View {
        void showProducts(List<Product> products);

        void showAddProductForm();

        void showEditProductForm(Product product);

        void showDeleteProductPrompt(Product product);

        void showGoogleSearch(Product product);

        void showEmptyText();

        void hideEmptyText();

        void showMessage(String message);
    }

    public interface Actions {
        void loadProducts();

        void onAddProductButtonClicked();

        void onAddToCrtButtonClicked();

        Product getProduct();

        void addProduct(Product product);

        void onDeleteProductButtonClicked(Product product);

        void deleteProduct(Product product);

        void onEditProductButtonClicked(Product product);

        void updateProduct(Product product);

        void onGoogleSearchButtonClicked(Product product);
    }

    public interface Repository {
        List<Product> getAllProducts();

        Product getProductById(Long id);

        void deleteProduct(Product product);

        void addProduct(Product product);

        void updateProduct(Product product);

        List<Category> getAllCategories();
    }
}
