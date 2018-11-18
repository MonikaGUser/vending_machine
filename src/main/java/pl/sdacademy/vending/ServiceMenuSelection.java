package pl.sdacademy.vending;

import java.util.Arrays;

public enum ServiceMenuSelection {
    ADD_TRAY(1, "Add new tray to machine"),
    REMOVE_TRAY (2, "Remove tray from machine"),
    ADD_PRODUCTS_FOR_TRAY (3, "Add products for tray"),
    REMOVE_PRODUCTS_FROM_TRAY (4, "Remove products"),
    CHANGE_PRICE (5, "Change price"),
    EXIT (9, "Exit to user menu");


    private final Integer optionNumber;
    private final String optionMessage;

    ServiceMenuSelection(Integer optionNumber, String optionMessage){
        this.optionNumber = optionNumber;
        this.optionMessage = optionMessage;
    }

    public Integer getOptionNumber() {
        return optionNumber;
    }

    public String getOptionMessage() {
        return optionMessage;
    }

    public static ServiceMenuSelection selectionForOptionNumber(Integer requestedOptionNumber){
        return     Arrays.stream(values())
                .filter(enumValue -> enumValue.getOptionNumber().equals(requestedOptionNumber))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException(("Unknown option number: " +requestedOptionNumber)));
        //wzorujac sie na UserMenuSelection zaimplementuj te metode


    }
}
