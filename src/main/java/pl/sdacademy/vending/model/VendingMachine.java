package pl.sdacademy.vending.model;

import pl.sdacademy.vending.util.Configuration;

import java.lang.reflect.Array;
import java.util.Optional;
import java.util.Random;

public class VendingMachine {

    private final Configuration configuration;
    private final Long rowsCount;
    private final Long columnsCount;
    private Tray[][] trays;

    public VendingMachine(Configuration configuration) {
        this.configuration = configuration;
        rowsCount = configuration.getLongProperty("machine.size.rows", 6L);
        if (rowsCount <= 0 || rowsCount > 26) {
            throw new IllegalArgumentException("Row count " + rowsCount + " is invalid");
        }
        columnsCount = configuration.getLongProperty("machine.size.columns", 4L);
        if (columnsCount <= 0 || columnsCount > 9) {
            throw new IllegalArgumentException("Column count " + columnsCount + " is invalid");
        }
        trays = new Tray[rowsCount.intValue()][columnsCount.intValue()];

        for (int rowNo = 0; rowNo < rowsCount; rowNo++) {
            for (int columnNo = 0; columnNo < columnsCount; columnNo++) {
                //if (random.nextInt(10)<8){}
                if (Math.random() < 0.8) {//probability 0.8
                    generateTrayAtPosition(rowNo, columnNo);
                }
            }
        }
    }
        private void generateTrayAtPosition(int rowNo, int columnNo){
            Random random = new Random();

            long randomPrice = random.nextInt((901) + 1000);
            char symbolLetter = (char) ('A' + rowNo);
            int symbolNumber = columnNo + 1;
            String symbol = "" + symbolLetter + symbolNumber;
           // Tray tray = Tray.builder(symbol).price(randomPrice).build();
            //trays[rowNo][columnNo] = tray;
            int productProbability = random.nextInt(10);

            Tray.Builder trayBuilder = Tray.builder(symbol).price(randomPrice);

            if (productProbability < 5) {
                trayBuilder = trayBuilder.product(new Product("Product " + symbol));
            }
            if (productProbability<1){
                trayBuilder = trayBuilder.product(new Product("Product "+ symbol));

            }
            trays[rowNo][columnNo] = trayBuilder.build();
        }
        //stworzyc tablice dwuwymiarową
        // do kazdego pola tablicy wpisac nowy obiekt tacki
        // obiekt tacki musi miec ustawiony poprawiony symbol

        public Optional<Tray> getTrayAtPosition ( int rowNo, int columnNo){
            try {
                Tray tray = trays[rowNo][columnNo];
                Optional<Tray> wrappedTray = Optional.ofNullable(tray);
                return wrappedTray;
            } catch (ArrayIndexOutOfBoundsException e) {
                return Optional.empty();
            }
        }

        //zwróć tackę opakowana optional
        // a jezeli nie istnieje, to pusty optional

        public Long rowsCount () {
            return configuration.getLongProperty("machine.size.rows", 6L);
        }

        public Long columnsCount () {
            return configuration.getLongProperty("machine.size.columns", 4L);
        }
    }
