package py.com.fuentepy.prontoshop.ui.customerlist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import py.com.fuentepy.prontoshop.core.listeners.OnDatabaseOperationCompleteListener;
import py.com.fuentepy.prontoshop.data.DatabaseHelper;
import py.com.fuentepy.prontoshop.model.Customer;
import py.com.fuentepy.prontoshop.util.Constants;

/**
 * Created by vinsfran on 25/08/17.
 */
public class CustomerListSQLiteManager implements CustomerListContract.Repository {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private Context mContext;

    public CustomerListSQLiteManager(Context context) {
        mContext = context;
        databaseHelper = DatabaseHelper.newInstance(context);
        database = databaseHelper.getWritableDatabase();
    }

    @Override
    public List<Customer> getAllCustomers() {
        //initialize an empty list of customers
        List<Customer> customers = new ArrayList<>();

        //SQL comman to select all Customers
        String selectQuery = "SELECT * FROM " + Constants.CUSTOMER_TABLE;

        //make sure the database is not null
        if (database != null) {
            //get cursor for all the customers in the database
            Cursor cursor = database.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    //get each customer in the Cursor
                    customers.add(Customer.getCustomerFromCursor(cursor));
                    cursor.moveToNext();
                }
            }
        }

        return customers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return null;
    }

    @Override
    public void onDeleteCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void addCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {

    }

    @Override
    public void updatedCustomer(Customer customer, OnDatabaseOperationCompleteListener listener) {

    }
}

