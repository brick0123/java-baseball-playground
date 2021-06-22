package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BallUtils {

    public static List<Ball> inputToBalls(String input) {
        verify(input);
        final List<Ball> balls = new ArrayList<>();
        generateBalls(input, balls);
        return balls;
    }

    private static void generateBalls(String input, List<Ball> balls) {
        for (int i = 0; i < 3; i++) {
            int num = verify(input.charAt(i) - '0');
            balls.add(new Ball(i + 1, num));
        }
    }

    private static void verify(String input) {
        Objects.requireNonNull(input, "값을 입력하지 않았습니다.");
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 수만 입력 가능합니다");
        }
    }

    private static int verify(int num) {
        if (num < 0 || num > 9) {
            throw new IllegalArgumentException("1 ~ 9까지 숫자만 입력 가능합니다");
        }
        return num;
    }

}
