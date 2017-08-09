package py.com.fuentepy.prontoshop.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vinsfran on 09/08/17.
 */
public class Formatter {

    public static String formatCurrency(double amount) {
        NumberFormat baseFormat = NumberFormat.getCurrencyInstance();
        String moneyString = baseFormat.format(amount);
        return moneyString;
    }

    public static String formatDate(long date) {
        String displayDate = new SimpleDateFormat("MMM dd").format(new Date(date));
        return displayDate;
    }
}
