package py.com.fuentepy.prontoshop.util;

/**
 * Created by vinsfran on 07/08/17.
 */
public class Constants {

    public final static int CART = 1;
    public final static int REPORT = 2;
    public final static int SETTINGS = 3;
    public final static int TRANSACTIONS = 4;
    public final static int PURCHASE = 5;


    public static final String PRODUCT_TABLE = "product";
    public static final String CUSTOMER_TABLE = "customer";
    public static final String LINEITEM_TABLE = "lineitem";
    public static final String CATEGORY_TABLE = "category";
    public static final String TRANSACTION_TABLE = "transactions";


    //Create constants for column names of Customer Table
    public final static String COLUMN_ID = "_id";
    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_EMAIL = "email";
    public final static String COLUMN_WEBSITE = "website";
    public final static String COLUMN_PHONE = "phone";
    public final static String COLUMN_STREET1 = "street1";
    public final static String COLUMN_STREET2 = "street2";
    public final static String COLUMN_CITY = "city";
    public final static String COLUMN_STATE = "state";
    public final static String COLUMN_ZIP = "zip";
    public final static String COLUMN_NOTE = "note";
    public final static String COLUMN_DATE_CREATED = "create_date";
    public final static String COLUMN_LAST_UPDATED = "last_update_date";


    //Create constants for column names of SalesTransaction Table
    public final static String COLUMN_CUSTOMER_ID = "customer_id";
    public final static String COLUMN_SUB_TOTAL_AMOUNT = "sub_total_amount";
    public final static String COLUMN_TAX_AMOUNT = "tax_amount";
    public final static String COLUMN_TOTAL_AMOUNT = "total_amount";
    public final static String COLUMN_LINE_ITEMS = "items";


    //Create constants for column names of Product Table
    public final static String COLUMN_DESCRIPTION = "description";
    public final static String COLUMN_PRICE = "price";
    public final static String COLUMN_IMAGE_PATH = "image_path";
    public final static String COLUMN_CATEGORY_ID = "category_id";

    //Create constants for column names of RetailerService
    public final static String COLUMN_INDUSTRY = "industry";
    public final static String COLUMN_MANUFACTURER = "manufacturer";
    public final static String COLUMN_CONTACT_PERSON = "manager_name";

    public static final String COLUMN_PURCHASE_PRICE = "purchase_price";
    public static final String COLUMN_PROMO_MESSAGE = "promo_message";
    public static final String COLUMN_CATEGORY_NAME = "category_name";
    public static final String COLUMN_CHECKOUT_COMPLETED = "checkout_completed";
    public static final String PREFERENCE_FILE = "preference_file";
    public static final String FIRST_RUN = "first_run";
    public static final String OPEN_CART_EXITS = "open_cart_exists";
    public static final String SERIALIZED_CART_ITEMS = "serialized_cart_items";
    public static final String SERIALIZED_CUSTOMER = "serialized_customer";
    public static final String COLUMN_PAYMENT_TYPE = "payment_type";
    public static final String COLUMN_PAYMENT_STATUS = "payment_status";


    public static final String[] COLUMNS_CATEGORY = {

            Constants.COLUMN_ID,
            Constants.COLUMN_NAME,
            Constants.COLUMN_DATE_CREATED,
            Constants.COLUMN_LAST_UPDATED

    };

    public static final String[] COLUMNS_CUSTOMER = {

            Constants.COLUMN_ID,
            Constants.COLUMN_NAME,
            Constants.COLUMN_EMAIL,
            Constants.COLUMN_IMAGE_PATH,
            Constants.COLUMN_PHONE,
            Constants.COLUMN_STREET1,
            Constants.COLUMN_STREET2,
            Constants.COLUMN_CITY,
            Constants.COLUMN_STATE,
            Constants.COLUMN_ZIP,
            Constants.COLUMN_NOTE,
            Constants.COLUMN_DATE_CREATED,
            Constants.COLUMN_LAST_UPDATED

    };

    public static final String[] COLUMNS_TRANSACTION = {

            Constants.COLUMN_ID,
            Constants.COLUMN_CUSTOMER_ID,
            Constants.COLUMN_SUB_TOTAL_AMOUNT,
            Constants.COLUMN_TAX_AMOUNT,
            Constants.COLUMN_TOTAL_AMOUNT,
            Constants.COLUMN_PAYMENT_STATUS,
            Constants.COLUMN_PAYMENT_STATUS,
            Constants.COLUMN_PAYMENT_TYPE,
            Constants.COLUMN_DATE_CREATED,
            Constants.COLUMN_LAST_UPDATED,
            Constants.COLUMN_LINE_ITEMS

    };


    public static final String[] COLUMNS_PRODUCT = {

            Constants.COLUMN_ID,
            Constants.COLUMN_NAME,
            Constants.COLUMN_DESCRIPTION,
            Constants.COLUMN_PROMO_MESSAGE,
            Constants.COLUMN_PRICE,
            Constants.COLUMN_PURCHASE_PRICE,
            Constants.COLUMN_IMAGE_PATH,
            Constants.COLUMN_CATEGORY_ID,
            Constants.COLUMN_CATEGORY_NAME,
            Constants.COLUMN_DATE_CREATED,
            Constants.COLUMN_LAST_UPDATED

    };


    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_PRODUCT_ID = "product_id";
    public static final String COLUMN_TRANSACTION_ID = "transaction_id";
}
