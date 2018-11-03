package pl.sdacademy.vending.controller;

import pl.sdacademy.vending.model.VendingMachine;

public class CustomerOperationController {

    private VendingMachine machine;

    public CustomerOperationController() {
        machine = new VendingMachine();
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
        char symbolLetter = (char)('A' +row);
        int symbolNumber = column +1;
        System.out.print("|   " + symbolLetter+ symbolNumber +"   |");
        // System.out.print("|   " + String.valueOf((char)(row+1+64)) + (column+1) + "   |");
    }
    private void printLowerBoundary (int row, int column){
        System.out.print("+--------+");
    }
}
