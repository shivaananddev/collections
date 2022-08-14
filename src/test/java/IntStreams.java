import beans.Prisoner;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        System.out.println("with fori");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
        System.out.println("with int stream exclusive");
        IntStream.range(0, 10).forEach(System.out::println);

        System.out.println("with int stream inclusive");
        IntStream.rangeClosed(0, 10).forEach(System.out::println);
    }

    // Loop through prisoner using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Prisoner> prisoner = database.DB.getPrisonersList();
        IntStream.range(0, prisoner.size())
                .forEach(index -> {
                    System.out.println(prisoner.get(index));
                });
    }

    @Test
    public void intStreamIterate()  {
        IntStream.iterate(0, value -> value + 1)
                .limit(11)
                .forEach(System.out::println);
    }
}
