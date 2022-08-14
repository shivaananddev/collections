import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UsageOfStream {

    @Test
    @Disabled
    void steams() {
        List<String> names = Arrays.asList("Amigoscode", "Alex", "Zara");
        Stream<String> stream = names.stream();

        Stream<String> namesStream = Stream.of("Amigoscode", "Alex", "Zara");

        long count = stream.limit(2).map(null).sorted(null).dropWhile(null).count();

        String[] namesArray = {};
        Arrays.stream(namesArray);
    }
}
