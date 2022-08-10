import beans.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        // OLD WAY
//        Map<String,List<Vehicle>> vehicleMap=new HashMap<>();
//        List<Vehicle> vehicles=database.DB.getVehicleList();
//        vehicles.forEach(vehicle -> {
//            if(vehicleMap.containsKey(vehicle.getMake())){
//                List<Vehicle> list=vehicleMap.get(vehicle.getMake());
//                list.add(vehicle);
//                vehicleMap.remove(vehicle.getMake());
//                vehicleMap.put(vehicle.getMake(),list);
//            }else{
//                vehicleMap.put(vehicle.getMake(), Arrays.asList(vehicle));
//            }
//        });
//        vehicleMap.forEach((s, vehicleList) -> {
//            System.out.println(s);
//            vehicleList.forEach(v -> {
//                System.out.println(v);
//            });
//        });
        // WITH STREAM POWERFUL API
        Map<String, List<Vehicle>> map = database.DB.getVehicleList()
                .stream()
                .collect(Collectors.groupingBy(Vehicle::getMake));
        map.forEach((s, vehicles) -> {
            System.out.println("Make " + s);
            vehicles.forEach(System.out::println);
            System.out.println("---------------------");
        });

    }

    @Test
    public void groupingAndCounting() throws Exception {
        List<String> names=Arrays.asList(
                "John",
                "John",
                "Mariam",
                "Alexender",
                "Umar",
                "Umar",
                "Vincent",
                "Alexender",
                "Alexender");
        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(), // finding same names
                        Collectors.counting()) // counting the same objects
                );
        System.out.println(map);

    }

}