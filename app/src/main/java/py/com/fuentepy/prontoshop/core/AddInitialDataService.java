package py.com.fuentepy.prontoshop.core;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import py.com.fuentepy.prontoshop.common.MainActivity;
import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.data.SampleCustomerData;
import py.com.fuentepy.prontoshop.data.SampleProductData;
import py.com.fuentepy.prontoshop.data.sqlite.CustomerSQLiteRepository;
import py.com.fuentepy.prontoshop.data.sqlite.ProductSQLiteRepository;
import py.com.fuentepy.prontoshop.models.Customer;
import py.com.fuentepy.prontoshop.models.Product;

/**
 * Created by vinsfran on 28/08/2017.
 */
public class AddInitialDataService extends IntentService {

    public AddInitialDataService() {
        super("AddInitialDataService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        //Add sample Customers to database
        List<Customer> customers = SampleCustomerData.getCustomers();
        CustomerSQLiteRepository customerRepository = new CustomerSQLiteRepository(getApplicationContext());
        for (Customer customer : customers) {
            customerRepository.addCustomer(customer, new OnDatabaseOperationCompleteListener() {
                @Override
                public void onSQLOperationFailed(String error) {
                    Log.d("Customer", "Error" + error);
                }

                @Override
                public void onSQLOperationSucceded(String message) {
                    Log.d("Customer", "Customer Inserted");
                }
            });
        }

        //Add initial products
        List<Product> products = SampleProductData.getSampleProducts();
        ProductSQLiteRepository productSQLiteRepository = new ProductSQLiteRepository(getApplicationContext());
        for (Product product : products) {
            productSQLiteRepository.addProduct(product, new OnDatabaseOperationCompleteListener() {
                @Override
                public void onSQLOperationFailed(String error) {
                    Log.d("First Run", "Error: " + error);
                }

                @Override
                public void onSQLOperationSucceded(String message) {
                    Log.d("First Run", "Success: " + message);
                }
            });
        }

        //Add sample categories
        List<String> categories = new ArrayList<>();
        categories.add("Electronics");
        categories.add("Computers");
        categories.add("Toys");
        categories.add("Garden");
        categories.add("Kitchen");
        categories.add("Clothing");
        categories.add("Health");

        for (String category : categories) {
            productSQLiteRepository.createOrGetCategoryId(category, new OnDatabaseOperationCompleteListener() {
                @Override
                public void onSQLOperationFailed(String error) {

                }

                @Override
                public void onSQLOperationSucceded(String message) {

                }
            });
        }

        Intent restartIntent = new Intent(this, MainActivity.class);
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(restartIntent);


    }

}