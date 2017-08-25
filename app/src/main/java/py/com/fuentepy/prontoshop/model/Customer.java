package py.com.fuentepy.prontoshop.model;

import android.database.Cursor;

import py.com.fuentepy.prontoshop.util.Constants;

/**
 * Created by vinsfran on 07/08/17.
 */
public class Customer {
    private long id;
    private String customerName;
    private String emailAddress;
    private String phoneNumber;
    private String profileImagePath;
    private String streetAddrss;
    private String streetAddrss2;
    private String city;
    private String state;
    private String postalCode;
    private String note;
    private long dateAdded;
    private long dateOfLastTransaction;

    public Customer() {
        id = 0;
        customerName = "";
        emailAddress = "";
        phoneNumber = "";
        profileImagePath = "empty";
        streetAddrss = "";
        streetAddrss2 = "";
        city = "";
        state = "";
        postalCode = "";
        note = "";
        dateAdded = 0L;
        dateOfLastTransaction = 0L;
    }

    public Customer(long id, String customerName, String emailAddress, String phoneNumber, String profileImagePath,
                    String streetAddrss, String streetAddrss2, String city, String state, String postalCode, String note,
                    long dateAdded, long dateOfLastTransaction) {
        this.id = id;
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.profileImagePath = profileImagePath;
        this.streetAddrss = streetAddrss;
        this.streetAddrss2 = streetAddrss2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.note = note;
        this.dateAdded = dateAdded;
        this.dateOfLastTransaction = dateOfLastTransaction;
    }

    public static Customer getCustomerFromCursor(Cursor cursor) {
        long id = cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_NAME));
        String email = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_EMAIL));
        String phone = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_PHONE));
        String imagePath = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_IMAGE_PATH));
        String street1 = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_STREET1));
        String street2 = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_STREET2));
        String city = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_CITY));
        String state = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_STATE));
        String zip = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_ZIP));
        String note = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_NOTE));
        long createdDate = cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_DATE_CREATED));
        long modifiedDate = cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_LAST_UPDATED));

        Customer customer = new Customer(id, name, email, phone, imagePath, street1, street2, city, state, zip, note, createdDate, modifiedDate);

        return customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }

    public String getStreetAddrss() {
        return streetAddrss;
    }

    public void setStreetAddrss(String streetAddrss) {
        this.streetAddrss = streetAddrss;
    }

    public String getStreetAddrss2() {
        return streetAddrss2;
    }

    public void setStreetAddrss2(String streetAddrss2) {
        this.streetAddrss2 = streetAddrss2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public long getDateOfLastTransaction() {
        return dateOfLastTransaction;
    }

    public void setDateOfLastTransaction(long dateOfLastTransaction) {
        this.dateOfLastTransaction = dateOfLastTransaction;
    }

}
