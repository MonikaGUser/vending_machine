package pl.sdacademy.vending.util;

import org.junit.Test;

import static org.junit.Assert.*;

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

}