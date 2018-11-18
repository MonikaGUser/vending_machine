package pl.sdacademy.vending.repository;

import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.service.repositories.VendingMachineRepository;
import pl.sdacademy.vending.util.Configuration;

import java.io.*;
import java.util.Optional;

public class HardDriveVendingMachineRepository implements VendingMachineRepository {
    private final String repoLocation;
    public HardDriveVendingMachineRepository(Configuration configuration){
        repoLocation= configuration.getStringProperty("repository.harddrive.vm.path",
                "VendingMachine.ser");

    }
    @Override
    public VendingMachine save(VendingMachine machine) {
        try (ObjectOutputStream objectOutputStream =
                     new ObjectOutputStream(new FileOutputStream(repoLocation))) {

            objectOutputStream.writeObject(machine);

        } catch (IOException e) {
            e.printStackTrace();
        }
        // utworz obiekt ObjectOutputStream
        //bazujac na repoLocation
        //zapisać obiekt machine na dysku
       // zrobic ten sam obiekt z metody
        return machine;
    }

    @Override
    public Optional<VendingMachine> load() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream
                (new FileInputStream(repoLocation))) {
            VendingMachine machine = (VendingMachine)objectInputStream.readObject();
       return Optional.ofNullable(machine);

        } catch (IOException e) {
            System.out.println("Vending Machine Repo file not found");

        } catch (ClassNotFoundException e) {
            System.out.println("Could not find Vending machine class");
        }
return Optional.empty();
        // utworz obiekt ObjectInputStream
        //bazujac na repoLocation
        //odczytac obiekt, rzutowac go, i opakowac w optional
        //pliku moze nie byc na dysku
        // jezeli nie ma pliku to Optional.isEmpty

    }
}
