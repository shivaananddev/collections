import beans.Prisoner;
import beans.PrisonerDTO;
import beans.Vehicle;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Prisoner> prisoners = database.DB.getPrisonersList();

        Function<Prisoner, PrisonerDTO> PrisonerPrisonerDTOFunction = Prisoner ->
                new PrisonerDTO(
                        Prisoner.getId(),
                        Prisoner.getFirstName(),
                        Prisoner.getAge());

        List<PrisonerDTO> dtos = prisoners.stream()
                .filter(Prisoner -> Prisoner.getAge() > 20)
                .map(PrisonerDTO::map)
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);

    }

    @Test
    void mapToDoubleAndFindAverageVehiclePrice() throws IOException {
        List<Vehicle> Vehicles = database.DB.getVehicleList();
        double avg = Vehicles.stream()
                .mapToDouble(Vehicle::getPrice)
                .average()
                .orElse(0);
        System.out.println(avg);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int sum = Arrays.stream(integers).reduce(0, Integer::sum);
        int sub = Arrays.stream(integers).reduce(0, (a, b) -> a - b);
        System.out.println(sum);
        System.out.println(sub);
    }
}

