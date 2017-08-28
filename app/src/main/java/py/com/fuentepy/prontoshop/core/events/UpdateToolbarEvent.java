package py.com.fuentepy.prontoshop.core.events;

import java.math.BigDecimal;

/**
 * Created by vinsfran on 28/08/2017.
 */
public class UpdateToolbarEvent {
    private final BigDecimal totalPrice;
    private final int totalQty;


    public UpdateToolbarEvent(BigDecimal totalPrice, int totalQty) {
        this.totalPrice = totalPrice;
        this.totalQty = totalQty;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public int getTotalQty() {
        return totalQty;
    }
}
