package py.com.fuentepy.prontoshop.ui.addProduct;

import py.com.fuentepy.prontoshop.core.ProntoShopApplication;
import py.com.fuentepy.prontoshop.core.events.ProductListChangedEvent;
import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.models.Category;
import py.com.fuentepy.prontoshop.models.Product;
import py.com.fuentepy.prontoshop.ui.products.ProductListContract;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by vinsfran on 28/08/2017.
 */
public class AddProductPresenter implements AddProductContract.Action, OnDatabaseOperationCompleteListener {
    private final AddProductContract.View mView;
    private long productId = 0;
    @Inject
    ProductListContract.Repository mRepository;
    @Inject
    EventBus mBus;

    public AddProductPresenter(AddProductContract.View view) {
        mView = view;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void onAddProductButtonClick(Product product) {
        if (productId > 0) {
            product.setId(productId);
            updatedProduct(product);
        } else {
            saveProduct(product);
        }
    }


    @Override
    public void checkStatus(long id) {
        if (id > 0) {
            if (mRepository.getProductById(id) != null) {
                productId = id;
                mView.setEditMode(true);
                mView.populateForm(mRepository.getProductById(id));
            }
        }
    }

    @Override
    public void saveProduct(Product product) {
        mRepository.addProduct(product, this);
    }

    @Override
    public void updatedProduct(Product product) {
        mRepository.updateProduct(product, this);
    }

    @Override
    public List<String> getCategoryNames() {
        List<String> categoryNames = new ArrayList<>();
        List<Category> categories = mRepository.getAllCategories();

        for (Category category : categories) {
            categoryNames.add(category.getCategoryName());
        }
        return categoryNames;
    }

    @Override
    public void onSQLOperationFailed(String error) {
        mView.displayMessage("Error: " + error);
    }

    @Override
    public void onSQLOperationSucceded(String message) {
        mView.displayMessage(message);
        mBus.post(new ProductListChangedEvent());
    }
}
