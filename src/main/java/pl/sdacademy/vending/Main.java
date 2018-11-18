package pl.sdacademy.vending;

import pl.sdacademy.vending.controller.CustomerOperationController;
import pl.sdacademy.vending.controller.EmployeeOperationController;
import pl.sdacademy.vending.controller.service.EmployeeService;
import pl.sdacademy.vending.model.Product;
import pl.sdacademy.vending.repository.HardDriveVendingMachineRepository;
import pl.sdacademy.vending.service.repositories.DefaultEmployeeService;
import pl.sdacademy.vending.service.repositories.VendingMachineRepository;
import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    Configuration configuration = new Configuration();
    VendingMachineRepository vendingMachineRepository = new HardDriveVendingMachineRepository(configuration);
    EmployeeService employeeService = new DefaultEmployeeService(vendingMachineRepository, configuration);
    EmployeeOperationController employeeOperationController = new EmployeeOperationController(employeeService);

    CustomerOperationController customerOperationController = new CustomerOperationController(vendingMachineRepository);


    private void startApplication() {
        while (true) {
            customerOperationController.printMachine();
            printMenu();
            try {
                UserMenuSelection userSelection = getUserSelection();
                switch (userSelection) {
                    case BUY_PRODUCT:
                        System.out.print(" > Choose tray symbol");
                        String usersProductSymbol = new Scanner(System.in).nextLine();
                        Optional<Product> boughtProduct = customerOperationController.
                                buyProductForSymbol(usersProductSymbol);
                        if (boughtProduct.isPresent()) {
                            System.out.println("You've bought the product: " + boughtProduct.get().getName());
                        } else {
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
                    case SERVICE_MENU:
                        handleServiceUser();
                        break;
                    default:
                        System.out.println("Invalid selection");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Blala");
            }
        }
    }


    private void printMenu() {

        UserMenuSelection[] allPossibleSelections = UserMenuSelection.values();
        for (UserMenuSelection menuPosition : allPossibleSelections) {
            System.out.println(menuPosition.getOptionNumber() + ". " + menuPosition.getOptionText());
        }
    }

    private void handleServiceUser() {
        while (true) {
            customerOperationController.printMachine();
            printServiceMenu();
            try {
                ServiceMenuSelection serviceSelection = getServiceSelection();
                switch (serviceSelection) {
                    case ADD_TRAY:
                        employeeOperationController.addTray();
                        break;
                    case REMOVE_TRAY:
                        break;
                    case ADD_PRODUCTS_FOR_TRAY:
                        break;
                    case REMOVE_PRODUCTS_FROM_TRAY:
                        break;
                    case CHANGE_PRICE:
                        break;
                    case EXIT:
                    System.out.println("See you soon");
                    return;
                    default:
                        System.out.println("Invalid selection");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Blala");
            }
            ServiceMenuSelection[] allPossibleSelections = ServiceMenuSelection.values();
            for (ServiceMenuSelection menuPosition : allPossibleSelections) {
                System.out.println(menuPosition.getOptionNumber() + ". " + menuPosition.getOptionMessage());
            }

            //wyswietlic menu uzytkownika serwisowego
            //odczytac ktora opcje wybral serwsant
            // mozna wzrorowac sie mna getUserselection
            //Za pomoca switch casea obluzyc jego wybor
            //dla case ADD_TRAY trzeba wywolac metode addTray zanajdujaca sie w kontrolerze dla serwisanta

        }
    }


    private void printServiceMenu() {

        ServiceMenuSelection[] allPossibleSelections = ServiceMenuSelection.values();
        for (ServiceMenuSelection menuPosition : allPossibleSelections) {
            System.out.println(menuPosition.getOptionNumber() + ". " + menuPosition.getOptionMessage());
        }
    }

    private UserMenuSelection getUserSelection() {
        System.out.print("> Your selection: ");
        String userSelection = new Scanner(System.in).nextLine();
        try {
            Integer menuNumber = Integer.valueOf(userSelection);
            return UserMenuSelection.selectionForOptionNumber(menuNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid selection format");
        }
    }

    private ServiceMenuSelection getServiceSelection() {
        System.out.print("> Your selection: ");
        String serviceSelection = new Scanner(System.in).nextLine();
        try {
            Integer menuNumber = Integer.valueOf(serviceSelection);
            return ServiceMenuSelection.selectionForOptionNumber(menuNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid selection format");
        }
    }

    public static void main(String[] args) {
        new Main().startApplication();
    }
}

