package pl.sdacademy.vending.model;

import org.junit.Test;
import pl.sdacademy.vending.util.Configuration;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class VendingMachineTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenZeroRowsConfigured() {
        //given
        Configuration config = mock(Configuration.class);
        doReturn(0L)
                .when(config)
                .getLongProperty(
                        eq("machine.size.rows"),
                        anyLong()
                );
        doReturn(4L)
                .when(config)
                .getLongProperty(
                        eq("machine.size.columns"),
                        anyLong()
                );
        //when
        new VendingMachine(config);
        //then
        fail("Exception should be raised");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenZeroColumnsConfigured() {
        //given
        Configuration config = mock(Configuration.class);
        doReturn(0L)
                .when(config)
                .getLongProperty(
                        eq("machine.size.columns"),
                        anyLong()
                );
        doReturn(4L)
                .when(config)
                .getLongProperty(
                        eq("machine.size.rows"),
                        anyLong()
                );
        //when
        new VendingMachine(config);
        //then
        fail("Exception should be raised");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTooManyRowsConfigured() {
        //given
        Configuration config = mock(Configuration.class);
        doReturn(4L).when(config).getLongProperty(eq("machine.size.columns"), anyLong()
                );
        doReturn(27L).when(config).getLongProperty(eq("machine.size.rows"), anyLong()
                );
        //when
        new VendingMachine(config);
        //then
        fail("Exception should be raised");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenTooManyColumnsConfigured() {
        //given
        Configuration config = mock(Configuration.class);
        doReturn(10L).when(config).getLongProperty(eq("machine.size.columns"), anyLong()
        );
        doReturn(2L).when(config).getLongProperty(eq("machine.size.rows"), anyLong()
        );
        //when
        new VendingMachine(config);
        //then
        fail("Exception should be raised");
    }

    @Test
    public void shouldBeSuccessful() {
        //given
        Configuration config = mock(Configuration.class);
        doReturn(4L).when(config).getLongProperty(eq("machine.size.columns"), anyLong()
        );
        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"), anyLong()
        );
        //when
        new VendingMachine(config);
        //then
        System.out.println("Success!");
    }
    @Test
    public void shouldBeAbleToAddTrayToEmptySpot(){
        //given
        Tray tray = Tray.builder("A2").build();
        Configuration config = mock(Configuration.class);
        doReturn(4L).when(config).getLongProperty(eq("machine.size.columns"), anyLong()
        );
        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"), anyLong()
        );
    VendingMachine testedMachine = new VendingMachine(config);
    //when
       boolean placed = testedMachine.placeTray(tray);

       //then
        assertTrue(placed);
        assertEquals(tray, testedMachine.getTrayAtPosition(0,1).get());
    }
    @Test
    public void shouldNotBeAbleToAddTrayToTakenSpot(){
        //given
        Tray tray = Tray.builder("A2").build();
        Tray secondTray = Tray.builder("A2").build();
        Configuration config = mock(Configuration.class);
        doReturn(4L).when(config).getLongProperty(eq("machine.size.columns"), anyLong()
        );
        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"), anyLong()
        );
        VendingMachine testedMachine = new VendingMachine(config);
        //when
        boolean firstTrayPlacementResult = testedMachine.placeTray(tray);
        boolean secondTrayPlacementResult = testedMachine.placeTray(secondTray);

        //then

        assertFalse(secondTrayPlacementResult);
        assertEquals(tray, testedMachine.getTrayAtPosition(0,1).get());
    }
    @Test
    public void shouldNotBeAbleToAddTrayToNotExistingPosition(){
        //given
        Tray tray = Tray.builder("$$").build();

        Configuration config = mock(Configuration.class);
        doReturn(4L).when(config).getLongProperty(eq("machine.size.columns"), anyLong()
        );
        doReturn(6L).when(config).getLongProperty(eq("machine.size.rows"), anyLong()
        );
        VendingMachine testedMachine = new VendingMachine(config);
        //when
        boolean firstTrayPlacementResult = testedMachine.placeTray(tray);


        //then

        assertFalse(firstTrayPlacementResult);

    }

}