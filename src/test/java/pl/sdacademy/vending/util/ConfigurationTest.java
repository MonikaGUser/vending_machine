package pl.sdacademy.vending.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationTest {

    private Configuration testedConfig;
  @Before
  public void init(){
      testedConfig = new Configuration();
  }

    @Test
    public void shouldReturnDefaultStringValueWhenPropertyIsUnknown() {
       // Given
        String unknownPropertyName = "dhiuhdfhff";
        String expectedDefault = "javaIsOk";
       // When
       String propertyValue = testedConfig.getStringProperty(unknownPropertyName, expectedDefault);
       //
       assertEquals(expectedDefault, propertyValue);

    }

   @Test
    public void shouldReturnDefaultLongValueWhenPropertyIsUnknown() {
       // Given
String unknownProperty = "super long";
Long expectedDefault =15L;
       // When
Long propertyValue = testedConfig.getLongProperty(unknownProperty,expectedDefault);
       // Then
       assertEquals(expectedDefault,propertyValue);

    }
   /*@Test

    public void shouldReturnKnownStringProperty() {
       // Given
String propertyName = "test.property.string";
String defaultString = "lala";
       // When
       String propertyValue = testedConfig.getStringProperty(propertyName, defaultString);

       // Then
    assertEquals("qwerty", propertyValue);
    }*/

    @Test

    public void shouldReturnKnownLongProperty() {
        // Given
        String propertyName = "test.property.long";
        Long defaultValue = 333L;
        // When
        Long propertyValue = testedConfig.getLongProperty(propertyName,defaultValue);

        // Then
        assertEquals((Long)7L,propertyValue);
    }
}