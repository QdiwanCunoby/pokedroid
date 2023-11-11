package it.cudia.studio.android.pokedroid.utility;

import java.text.DecimalFormat;

public class Utility {
    static public double calcolaPercentuale(double numero, double totale) {
        if (totale == 0) {
            throw new IllegalArgumentException("Il totale non può essere zero.");
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00"); // Two decimal places
        double percentuale = (numero / totale) * 100;
        return Double.valueOf(decimalFormat.format(percentuale));
    }
}
