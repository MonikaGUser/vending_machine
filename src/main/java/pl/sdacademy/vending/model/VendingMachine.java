package pl.sdacademy.vending.model;

import pl.sdacademy.vending.util.Configuration;

import java.lang.reflect.Array;
import java.util.Optional;

public class VendingMachine {

private final Configuration configuration;
    private final Long rowsCount;
    private final Long columnsCount;
    private Tray[][] trays;

    public VendingMachine(Configuration configuration){
        this.configuration = configuration;
        rowsCount = configuration.getLongProperty("machine.size.rows", 6L);
        if (rowsCount<=0 || rowsCount > 26){
            throw new IllegalArgumentException("Row count " + rowsCount +" is invalid");
        }
        columnsCount = configuration.getLongProperty("machine.size.columns", 4L);
        if (columnsCount<=0 || columnsCount>9){
            throw new IllegalArgumentException("Column count " + columnsCount + " is invalid");
        }
        trays = new Tray[rowsCount.intValue()][columnsCount.intValue()];
        for (int rowNo = 0; rowNo < rowsCount; rowNo++){
            for (int columnNo = 0; columnNo< columnsCount; columnNo++){
                char symbolLetter = (char) ('A' + rowNo);
            int symbolNumber = columnNo +1;
            String symbol = "" + symbolLetter + symbolNumber;
            trays[rowNo][columnNo] = new Tray (symbol);
            }
        }
        //stworzyc tablice dwuwymiarową
        // do kazdego pola tablicy wpisac nowy obiekt tacki
        // obiekt tacki musi miec ustawiony poprawiony symbol
    }
public Optional<Tray> getTrayAtPosition (int rowNo, int columnNo){
        try {
            Tray tray = trays[rowNo][columnNo];
            Optional<Tray> wrappedTray = Optional.ofNullable(tray);
            return wrappedTray;
        }
        catch (ArrayIndexOutOfBoundsException e){
            return Optional.empty();
        }
        }

        //zwróć tackę opakowana optional
    // a jezeli nie istnieje, to pusty optional

    public Long rowsCount(){
        return  configuration.getLongProperty("machine.size.rows", 6L);
    }

    public  Long columnsCount(){
        return configuration.getLongProperty("machine.size.columns", 4L);
    }
}
