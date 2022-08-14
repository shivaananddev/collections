import beans.Vehicle;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class StatisticsWithStreams {

    @Test
    public void count() throws Exception {
        List<Vehicle> Vehicles = database.DB.getVehicleList();
        long count = Vehicles.stream()
                .filter(Vehicle -> Vehicle.getMake().equalsIgnoreCase("Ford"))
                .filter(Vehicle -> Vehicle.getYear() > 2010)
                .count();
        System.out.println(count);
    }

    @Test
    public void min() throws Exception {
        List<Vehicle> Vehicles = database.DB.getVehicleList();
        double min = Vehicles.stream()
                .mapToDouble(Vehicle::getPrice)
                .min()
                .orElse(0);
        System.out.println(min);
    }

    @Test
    public void max() throws Exception {
        List<Vehicle> Vehicles = database.DB.getVehicleList();
        double max = Vehicles.stream()
                .mapToDouble(Vehicle::getPrice)
                .max()
                .orElse(0);
        System.out.println(max);
    }


    @Test
    public void average() throws Exception {
        List<Vehicle> Vehicles = database.DB.getVehicleList();
        double average = Vehicles.stream()
                .mapToDouble(Vehicle::getPrice)
                .average()
                .orElse(0);
        System.out.println(average);
    }

    @Test
    public void sum() throws Exception {
        List<Vehicle> Vehicles = database.DB.getVehicleList();
        double sum = Vehicles.stream()
                .mapToDouble(Vehicle::getPrice)
                .sum();
        System.out.println(BigDecimal.valueOf(sum));
    }

    @Test
    public void statistics() throws Exception {
        List<Vehicle> Vehicles = database.DB.getVehicleList();
        DoubleSummaryStatistics statistics = Vehicles.stream()
                .mapToDouble(Vehicle::getPrice)
                .summaryStatistics();
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(BigDecimal.valueOf(statistics.getSum()));
    }

}