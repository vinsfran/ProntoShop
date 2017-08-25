package py.com.fuentepy.prontoshop.model;

import android.database.Cursor;

import py.com.fuentepy.prontoshop.util.Constants;

/**
 * Created by vinsfran on 07/08/17.
 */
public class Product {

    private long id;
    private String productName;
    private String description;
    private String promoMessage;
    private double salePrice;
    private double purchasePrice;
    private String imagePath;
    private long categoryId;
    private String categoryName;
    private long dateAdded;
    private long dateOfLastTransaction;

    public Product() {
    }

    public Product(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.promoMessage = product.getPromoMessage();
        this.salePrice = product.getSalePrice();
        this.purchasePrice = product.getPurchasePrice();
        this.imagePath = product.getImagePath();
        this.categoryId = product.getCategoryId();
        this.categoryName = product.getCategoryName();
        this.dateAdded = product.getDateAdded();
        this.dateOfLastTransaction = product.getDateOfLastTransaction();
    }

    public static Product getProductFromCursor(Cursor cursor) {
        long id = cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_NAME));
        String description = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_DESCRIPTION));
        String promoMessage = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_PROMO_MESSAGE));
        Double salePrice = cursor.getDouble(cursor.getColumnIndex(Constants.COLUMN_PRICE));
        Double purchasePrice = cursor.getDouble(cursor.getColumnIndex(Constants.COLUMN_PURCHASE_PRICE));
        String imagePath = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_IMAGE_PATH));
        long catId = cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_CATEGORY_ID));
        String catName = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_CATEGORY_NAME));
        long dateCreated = cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_DATE_CREATED));
        long dateLastUpdated = cursor.getLong(cursor.getColumnIndex(Constants.COLUMN_LAST_UPDATED));

        Product product = new Product();
        product.setId(id);
        product.setProductName(name);
        product.setDescription(description);
        product.setPromoMessage(promoMessage);
        product.setSalePrice(salePrice);
        product.setPurchasePrice(purchasePrice);
        product.setImagePath(imagePath);
        product.setCategoryId(catId);
        product.setCategoryName(catName);
        product.setDateAdded(dateCreated);
        product.setDateOfLastTransaction(dateLastUpdated);

        return product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPromoMessage() {
        return promoMessage;
    }

    public void setPromoMessage(String promoMessage) {
        this.promoMessage = promoMessage;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
