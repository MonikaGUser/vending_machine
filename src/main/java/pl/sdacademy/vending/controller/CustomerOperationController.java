package pl.sdacademy.vending.controller;
import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.model.Tray;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.util.StringUtil;

import java.util.Optional;

public class CustomerOperationController {

    private final VendingMachine machine;
    private final Integer trayWidth = 12;

    public CustomerOperationController(VendingMachine machine) {
        this.machine = machine;
    }

    public void printMachine() {

        for (int row = 0; row < machine.rowsCount(); row++) {
            for (int column = 0; column < machine.columnsCount(); column++) {
                printUpperBoundary(row, column);
                //print upper boundary
            }
            System.out.println();
            //wyswietl nazwe produktu
            //wyswietl cene
            for (int column = 0; column < machine.columnsCount(); column++) {
                printSymbol(row, column);
                //print symbol
            }
            System.out.println();
            for (int column = 0; column < machine.columnsCount(); column++) {
                printName(row, column);
                //print name
            }
            System.out.println();
            for (int column = 0; column < machine.columnsCount(); column++) {
                printPrice(row, column);
                //print price
            }
            System.out.println();
            for (int column = 0; column < machine.columnsCount(); column++) {
                //print lower boundary
                printLowerBoundary(row, column);
            }
            System.out.println();
        }
    }

    private void printUpperBoundary(int row, int column) {
        System.out.print("+" + StringUtil.duplicateText("-", trayWidth) + "+");
    }

    private void printSymbol(int row, int column) {
        Optional<Tray> tray = machine.getTrayAtPosition(row, column);
        String traySymbol = tray.map(Tray::getSymbol).orElse("--");
        System.out.print("|" + StringUtil.adjustText(traySymbol, trayWidth) + "|");
        // System.out.print("|   " + String.valueOf((char)(row+1+64)) + (column+1) + "   |");
    }

    private void printName(int row, int column) {
        machine.productNameAtPosition(row, column);
        Optional<String> productName = machine.productNameAtPosition(row, column);
        String formattedName = productName.orElse("--");
        System.out.print("|" + StringUtil.adjustText(formattedName, trayWidth) + "|");

}

    private void printPrice(int row, int column) {
        Optional<Tray> tray = machine.getTrayAtPosition(row, column);
        Long price = tray.map(Tray::getPrice).orElse(0L);
        String formattedMoney = StringUtil.formatMoney(price);
        String centredMoney = StringUtil.adjustText(formattedMoney, trayWidth);
        System.out.print("|" + centredMoney + "|");
    }

    private void printLowerBoundary(int row, int column) {
        System.out.print("+" + StringUtil.duplicateText("-", trayWidth) + "+");
    }
}
