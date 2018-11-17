package pl.sdacademy.vending;

public enum UserMenuSelection {
    BUY_PRODUCT (1, "Buy product"),
    EXIT (9, "Exit");

    private final Integer optionNumber;
    private final String optionText;

    UserMenuSelection(Integer optionNumber, String optionText) {
        this.optionNumber = optionNumber;
        this.optionText = optionText;
    }
    public static UserMenuSelection selectionForOptionNumber (Integer requestedOptionNumber){
  //if (BUY_PRODUCT.getOptionNumber().equals(requestedOptionNumber)){
   //   return BUY_PRODUCT;
//  }
       for  (UserMenuSelection menuSelection : values()){
           if (menuSelection.getOptionNumber().equals(requestedOptionNumber)){
               return menuSelection;
           }
       }
        throw new IllegalArgumentException(("Unknown option number: " +requestedOptionNumber));
    }

    public Integer getOptionNumber() {
        return optionNumber;
    }

    public String getOptionText() {
        return optionText;
    }
}
