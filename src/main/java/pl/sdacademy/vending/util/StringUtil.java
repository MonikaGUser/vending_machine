package pl.sdacademy.vending.util;

public class StringUtil {
    public static String adjustText(String text, Integer requiredLength) {
        String expandedText = text;
        while (expandedText.length()<requiredLength){
            expandedText = " "+ expandedText + " ";
        }
            return expandedText.substring(0, requiredLength);
        }

}