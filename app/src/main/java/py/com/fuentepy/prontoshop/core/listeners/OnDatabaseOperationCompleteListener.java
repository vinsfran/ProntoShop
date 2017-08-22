package py.com.fuentepy.prontoshop.core.listeners;

/**
 * Created by vinsfran on 22/08/17.
 */
public interface OnDatabaseOperationCompleteListener {
    void onDatabaseOperationFailed(String error);
    void onDatabaseOperationSucceded(String message);
}
