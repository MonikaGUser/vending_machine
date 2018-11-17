package pl.sdacademy.vending.service.repositories;

import pl.sdacademy.vending.controller.service.EmployeeService;
import pl.sdacademy.vending.model.Tray;
import pl.sdacademy.vending.model.VendingMachine;
import pl.sdacademy.vending.util.Configuration;

import java.util.Optional;

public class DefaultEmployeeService implements EmployeeService {

    private final VendingMachineRepository machineRepository;
    private final Configuration configuration;

    public DefaultEmployeeService(VendingMachineRepository machineRepository, Configuration configuration) {
        this.machineRepository = machineRepository;
        this.configuration = configuration;
    }

    @Override
    public Optional<String> addTray(Tray tray) {
        Optional<VendingMachine> loadedMachine = machineRepository.load();
        VendingMachine vendingMachine = loadedMachine.orElseGet(() -> new VendingMachine(configuration));

        if (vendingMachine.placeTray(tray)) {
            machineRepository.save(vendingMachine);
        } else {
            return Optional.of("Couldn't set up tray, please check provided value");
        }
            //zaladuj VendingMachine
            // dodaj tacke
            // sprawdz czy sie udalo dodac tacke
            // jesli sie udalo zapisujemy automat vendingowy, jak nie to zwroc komunikat bledu
            return Optional.empty();
        }
    }

