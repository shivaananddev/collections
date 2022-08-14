import beans.Prisoner;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {

    @Test
    void collect() throws IOException {
        List<String> emails = database.DB.getPrisonersList()
                .stream()
                .map(Prisoner::getEmail)
                .collect(
                        ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll
                );
        emails.forEach(System.out::println);
    }

    @Test
    public void lazy() throws Exception {
        System.out.println(
                database.DB.getVehicleList()
                        .stream()
                        .filter(Vehicle -> {
                            System.out.println("filter Vehicle " + Vehicle);
                            return Vehicle.getPrice() < 10000;
                        })
                        .map(Vehicle -> {
                            System.out.println("mapping Vehicle " + Vehicle);
                            return Vehicle.getPrice();
                        })
                        .map(price -> {
                            System.out.println("mapping price " + price);
                            return price + (price * .14);
                        })
                        .collect(Collectors.toList())
        );
    }
}