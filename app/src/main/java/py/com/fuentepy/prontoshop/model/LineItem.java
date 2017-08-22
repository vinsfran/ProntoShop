package py.com.fuentepy.prontoshop.model;

/**
 * Created by vinsfran on 08/08/17.
 */
public class LineItem extends Product {
    private int qauntity;

    public LineItem(Product product, int quantity) {
        super(product);
        this.setQauntity(quantity);
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    public double getSumPrice() {
        return getSalePrice() * qauntity;
    }
}
