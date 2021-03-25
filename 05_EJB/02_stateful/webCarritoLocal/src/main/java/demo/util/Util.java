package demo.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Félix
 */
public class Util {
    
    
    
    public static String getFormatted(double _value, int _numDecimals){
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.FRANCE));
        df.setMaximumFractionDigits(_numDecimals);
        return df.format(_value);
    }

    public static String getNumberFormatted(double _value, String _pattern){
        DecimalFormat myFormatter = new DecimalFormat(_pattern);
        return myFormatter.format(_value);
    }
     
}
