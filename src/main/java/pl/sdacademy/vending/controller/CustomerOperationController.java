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
                System.out.print("+--------+");
                //print upper boundary

            }
            System.out.println();
            for (int column = 0; column < machine.columnsCount(); column++) {
                char symbolLetter = (char)('A' +row);
                int symbolNumber = column +1;
                System.out.print("|   " + symbolLetter+ symbolNumber +"   |");
                //print symbol
               // System.out.print("|   " + String.valueOf((char)(row+1+64)) + (column+1) + "   |");

            }
            System.out.println();
            for (int column = 0; column < machine.columnsCount(); column++) {
                //print lower boundary
                System.out.print("+--------+");

            }
            System.out.println();
        }
    }
}
