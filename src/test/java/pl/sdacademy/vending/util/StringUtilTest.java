package pl.sdacademy.vending.util;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)

public class StringUtilTest {

    @Test
    public void shouldReturnUnmodifiedTextIfLengthMatched() {
        //given
        String textToAdjust = "Ala ma kota";
        Integer expectedLength = 11;
        //when
        String adjustedText = StringUtil.adjustText(textToAdjust, expectedLength);
        //then
        assertEquals("Ala ma kota", adjustedText);
    }

    @Test
    public void shouldTrimTooLongText(){
        String textToAdjust = "Ala ma kota";
        Integer expectedLength =6;
        //when
        String adjustedText = StringUtil.adjustText(textToAdjust, expectedLength);
        //then
        assertEquals("Ala ma", adjustedText);
    }
//"Ala"->8 "   Ala "
    //"ABCD"

    @Test
    public void shouldAddSpacesToEvenText(){
        String textToAdjust = "ABCD";
        Integer expectedLength =8;
        //when
        String adjustedText = StringUtil.adjustText(textToAdjust, expectedLength);
        //then
        assertEquals("  ABCD  ", adjustedText);
    }

    @Test
    public void shouldAddSpacesToUnevenText(){
        String textToAdjust = "Ala";
        Integer expectedLength =8;
        //when
        String adjustedText = StringUtil.adjustText(textToAdjust, expectedLength);
        //then
        assertEquals("   Ala  ", adjustedText);
    }
@Test
    @Parameters
    public void shouldProperlyFormatMoney(Long amountToFormat, String expectedResult){//given
        //when
    String formattedMoney = StringUtil.formatMoney(amountToFormat);
        //then
    assertEquals(expectedResult, formattedMoney);

}
    public Object[] parametersForShouldProperlyFormatMoney(){
        return new Object[]{
              new Object[]{123L, "1,23"},
                new Object[]{0L, "0,00"},
                new Object[] {5L, "0,05"},
                new Object[] {12L, "0,12"},
                new Object[] {1234L, "12,34"},
                new Object[] {12345L, "123,45"},
                new Object[] {123456L, "1 234,56"},
                new Object[] {1234567L, "12 345,67"},
                new Object[] {12345678L, "123 456,78"},
                new Object[] {123456789L, "1 234 567,89"},
                new Object[] {1323455465660845342L, "13 234 554 656 608 453,42"},

        };
    }
}