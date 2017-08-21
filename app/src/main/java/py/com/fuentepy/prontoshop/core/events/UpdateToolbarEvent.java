package py.com.fuentepy.prontoshop.core.events;

import java.util.List;

import py.com.fuentepy.prontoshop.model.LineItem;

/**
 * Created by vinsfran on 21/08/17.
 */
public class UpdateToolbarEvent {
    private final List<LineItem> mLineItems;

    public UpdateToolbarEvent(List<LineItem> mLineItems) {
        this.mLineItems = mLineItems;
    }

    public List<LineItem> getmLineItems() {
        return mLineItems;
    }
}
