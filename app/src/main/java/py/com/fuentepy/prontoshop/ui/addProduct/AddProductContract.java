package py.com.fuentepy.prontoshop.ui.addProduct;

import py.com.fuentepy.prontoshop.models.Product;

import java.util.List;

/**
 * Created by vinsfran on 28/08/2017.
 */
public class AddProductContract {
    interface View {
        void populateForm(Product product);

        void displayMessage(String message);

        void setEditMode(boolean editMode);

        void clearForm();
    }

    interface Action {
        void onAddProductButtonClick(Product product);

        void checkStatus(long id);

        void saveProduct(Product product);

        void updatedProduct(Product product);

        List<String> getCategoryNames();
    }
}
