package pl.sdacademy.vending.controller;

import pl.sdacademy.vending.model.Tray;
import pl.sdacademy.vending.model.VendingMachine;

import java.util.Optional;

public class CustomerOperationController {

    private final VendingMachine machine;

    public CustomerOperationController(VendingMachine machine) {
     this.machine = machine;
    }

    public void printMachine() {

        for (int row = 0; row < machine.rowsCount(); row++) {

                for (int column =0; column<machine.columnsCount(); column++){
              printUpperBoundary(row, column);
                //print upper boundary

            }
            System.out.println();
            for (int column = 0; column < machine.columnsCount(); column++) {
               printSymbol(row, column);
                //print symbol


            }
            System.out.println();
            for (int column = 0; column < machine.columnsCount(); column++) {
                //print lower boundary
                printLowerBoundary(row, column);

            }
            System.out.println();
        }
    }
    private void printUpperBoundary (int row, int column){
        System.out.print("+--------+");
    }
    private void printSymbol (int row, int column){
        Optional<Tray> tray = machine.getTrayAtPosition(row, column);
        String traySymbol = tray.map(Tray::getSymbol).orElse("--");
        System.out.print("|   " + traySymbol +"   |");
        // System.out.print("|   " + String.valueOf((char)(row+1+64)) + (column+1) + "   |");
    }
    private void printLowerBoundary (int row, int column){
        System.out.print("+--------+");
    }
}
