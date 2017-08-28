package py.com.fuentepy.prontoshop.core.listeners;

import py.com.fuentepy.prontoshop.models.LineItem;

/**
 * Created by vinsfran on 09/08/2017.
 */
public interface CartActionsListener {
    void onItemDeleted(LineItem item);

    void onItemQtyChange(LineItem item, int qty);

}
