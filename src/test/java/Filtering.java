import beans.Vehicle;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Vehicle> vehicles = database.DB.getVehicleList();
        // SIMPLE FOR EACH LOOP
//        vehicles.forEach(vehicle -> {
//            if(vehicle.getPrice()<15000){
//                if(vehicle.getColor().equals("Yellow")){
//                    System.out.println(vehicle);
//                }
//            }
//        });

        // WITH STREAM FILTERING WITH PREDICATE
        Predicate<Vehicle> vehiclePredicate = vehicle -> vehicle.getPrice() < 15_000.00;
        Predicate<Vehicle> yellow = vehicle -> vehicle.getColor().equals("Yellow");

        List<Vehicle> vehiclesLessThan20k = vehicles.stream()
                .filter(vehiclePredicate)
                .filter(yellow)
                .collect(Collectors.toList());
        vehiclesLessThan20k.forEach(System.out::println);
    }


}
