import beans.Prisoner;
import beans.Vehicle;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingSteamOfElements() throws IOException {
        List<Prisoner> prisoners = database.DB.getPrisonersList();
        List<String> sorted = prisoners.stream()
                .map(Prisoner::getFirstName)
                .sorted()
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfElementsReverse() throws IOException {
        List<Prisoner> prisoner = database.DB.getPrisonersList();

        List<String> sorted = prisoner.stream()
                .map(Prisoner::getFirstName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingSteamOfObjects() throws IOException {
        // SORTING STREAM OBJECT USING COMPARATOR
        List<Prisoner> prisoners = database.DB.getPrisonersList();

        Comparator<Prisoner> comparing = Comparator
                .comparing(Prisoner::getEmail)
                .reversed()
                .thenComparing(Prisoner::getFirstName);

        List<Prisoner> sort = prisoners.stream()
                .sorted(comparing)
                .collect(Collectors.toList());
        sort.forEach(System.out::println);
    }

    @Test
    public void topTenMostExpensiveBlueVehicles() throws IOException {
        List<Vehicle> vehicles = database.DB.getVehicleList();
        List<Vehicle> topTen = vehicles.stream()
                .filter(Vehicle -> Vehicle.getColor().equalsIgnoreCase("blue"))
                .sorted(Comparator.comparing(Vehicle::getPrice).reversed())
                .limit(10)
                .collect(Collectors.toList());
        topTen.forEach(System.out::println);
    }

}
