package py.com.fuentepy.prontoshop.ui.addCustomer;

import py.com.fuentepy.prontoshop.models.Customer;

/**
 * Created by vinsfran on 28/08/2017.
 */
public class AddCustomerContract {
    interface View {
        void populateForm(Customer customer);

        void displayMessage(String message);

        void setEditMode(boolean editMode);

        void clearForm();
    }

    interface Action {
        void onAddCustomerButtonClick(Customer customer);

        void checkStatus(long id);

        void saveCustomer(Customer customer);

        void updatedCustomer(Customer customer);

    }
}
