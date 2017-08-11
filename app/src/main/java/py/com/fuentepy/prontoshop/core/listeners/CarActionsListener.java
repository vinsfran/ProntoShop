package py.com.fuentepy.prontoshop.core.listeners;

import py.com.fuentepy.prontoshop.model.LineItem;

/**
 * Created by vinsfran on 09/08/17.
 */
public interface CarActionsListener {
    void onItemDeletedProduct (LineItem item);
    void onItemQtyChange(LineItem item, int qty);
}
