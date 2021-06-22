package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallUtilsTest {

    @Test
    @DisplayName("세 자리의 1~9 숫자를 입력하지 않으면 예외가 발생한다")
    void name() {

        assertThrows(IllegalArgumentException.class,
            () -> BallUtils.inputToBalls(""));

        assertThrows(IllegalArgumentException.class,
            () -> BallUtils.inputToBalls("1-23"));

        assertThrows(IllegalArgumentException.class,
            () -> BallUtils.inputToBalls("ab"));

        assertThrows(IllegalArgumentException.class,
            () -> BallUtils.inputToBalls("abc"));

        assertThrows(IllegalArgumentException.class,
            () -> BallUtils.inputToBalls("abcd"));

        assertThrows(IllegalArgumentException.class,
            () -> BallUtils.inputToBalls("12"));

        assertThrows(IllegalArgumentException.class,
            () -> BallUtils.inputToBalls("1234"));
    }

    @Test
    @DisplayName("입력값의 위치와 숫자를 Ball로 반환한다.")
    void balls() {
      // given
        List<Ball> balls = BallUtils.inputToBalls("123");
        List<Ball> ballsExpected = Arrays.asList(
            new Ball(1, 1),
            new Ball(2, 2),
            new Ball(3, 3)
        );

        List<Ball> balls2 = BallUtils.inputToBalls("479");
        List<Ball> ballsExpected2 = Arrays.asList(
            new Ball(1, 4),
            new Ball(2, 7),
            new Ball(3, 9)
        );

        assertThat(balls).containsAll(ballsExpected);
        assertThat(balls2).containsAll(ballsExpected2);
    }
}