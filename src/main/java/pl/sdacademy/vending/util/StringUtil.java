package pl.sdacademy.vending.util;

public class StringUtil {
    public static String adjustText(String text, Integer requiredLength) {
        String expandedText = text;
        while (expandedText.length() < requiredLength) {
            expandedText = " " + expandedText + " ";
        }
        return expandedText.substring(0, requiredLength);
    }

    public static String formatMoney(Long amount) {
        return formatMoneyIntegrals(amount) + "," + formatMoneyDecimals(amount);

    }

    //złotówki
    private static String formatMoneyIntegrals(Long amount) {
        String integrals = Long.toString(amount / 100);
        StringBuilder formatMoney = new StringBuilder();
        Integer charactersTillLastSpace = 0;
        for (int charIndex= integrals.length()-1; charIndex>=0; charIndex--){
            charactersTillLastSpace++;
           formatMoney = formatMoney.append(integrals.charAt(charIndex));
            if (charactersTillLastSpace>= 3){
               formatMoney= formatMoney.append(" ");
                charactersTillLastSpace =0;
            }
        }

        return formatMoney.reverse().toString().trim();

    }

    //grosze
    private static String formatMoneyDecimals(Long amount) {
        String decimals = Long.toString(amount % 100);
        if (decimals.length() < 2) {
            decimals = "0" + decimals;
        }
        return decimals;
    }
}