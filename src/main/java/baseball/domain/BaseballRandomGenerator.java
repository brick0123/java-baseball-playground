package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class BaseballRandomGenerator {

    public static List<Ball> randomGeneratorBalls() {
        List<Integer> randomNumber = generateRandomDistinctIntegerList();

        List<Ball> randomBalls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            randomBalls.add(new Ball(i + 1, randomNumber.get(i)));
        }
        return randomBalls;
    }

    private static List<Integer> generateRandomDistinctIntegerList() {
        return ThreadLocalRandom.current()
            .ints(1, 10)
            .distinct()
            .limit(3)
            .boxed()
            .collect(Collectors.toList());
    }
}
