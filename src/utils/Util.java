package utils;

import java.text.*;

public class Util {

    public static String formaterMontant(double valeur) {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setGroupingSeparator('\'');
        dfs.setDecimalSeparator('.');
        DecimalFormat formatter = new DecimalFormat("#,##0.00", dfs);
        return formatter.format(valeur);
    }
}
