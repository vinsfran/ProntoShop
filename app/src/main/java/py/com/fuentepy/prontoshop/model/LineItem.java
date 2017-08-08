package py.com.fuentepy.prontoshop.model;

/**
 * Created by vinsfran on 08/08/17.
 */
public class LineItem extends Product{
    private int qauntity;

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    private double getSumPrice(){
        return getSalePrice() * qauntity;
    }
}
