package py.com.fuentepy.prontoshop.core.listeners;

/**
 * Created by vinsfran on 22/08/2017.
 */
public interface OnDatabaseOperationCompleteListener {
    void onSQLOperationFailed(String error);

    void onSQLOperationSucceded(String message);
}
