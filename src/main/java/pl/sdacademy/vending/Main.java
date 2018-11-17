package pl.sdacademy.vending;

import pl.sdacademy.vending.controller.CustomerOperationController;
import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    Configuration configuration = new Configuration();
    VendingMachine vendingMachine = new VendingMachine(configuration);
    CustomerOperationController customerOperationController = new CustomerOperationController(vendingMachine);


    private void startApplication() {
        while (true) {
            customerOperationController.printMachine();
            printMenu();
            try {
                UserMenuSelection userSelection = getUserSelection();
                switch (userSelection) {
                    case BUY_PRODUCT:
                        System.out.print(" > Choose tray symbol");
                      String usersProductSymbol =  new Scanner(System.in).nextLine();
                        Optional<Product> boughtProduct= customerOperationController.
                                buyProductForSymbol(usersProductSymbol);
                        if (boughtProduct.isPresent()){
                            System.out.println("You've bought the product: " + boughtProduct.get().getName());
                        }
                        else {
                            System.out.println("Lack of product");
                        }
                        //1. pobierz od uzytkownika symbol tacki
                        //2. wywolac odp metode z kontrolera*
                        // Optional buyProductForSymbol (String traySymbol)
                        //3. jezeli udalo sie kupic produkt to wypisz na ekran potwierdzenie oraz nazwe produktu
                        // jesli nie to wypisz "brak produktu"
                        break;
                    case EXIT:
                        System.out.println("Bye");
                        return;
                    default:
                        System.out.println("Invalid selection");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Blala");
            }
        }
    }

        private void printMenu () {
            UserMenuSelection[] allPossibleSelections = UserMenuSelection.values();
            for (UserMenuSelection menuPosition : allPossibleSelections) {
                System.out.println(menuPosition.getOptionNumber() + ". " + menuPosition.getOptionText());
            }
        }

        private UserMenuSelection getUserSelection () {
            System.out.print("> Your selection: ");
            String userSelection = new Scanner(System.in).nextLine();
            try {
                Integer menuNumber = Integer.valueOf(userSelection);
                return UserMenuSelection.selectionForOptionNumber(menuNumber);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid selection format");
            }
        }

        public static void main (String[]args){
            new Main().startApplication();
        }
    }

