package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameOutputUtilsTest {

    @Test
    @DisplayName("볼과 스트라이크 개수에 따른 결과를 출력한다.")
    void ball_strike() {
        Map<BallResult, Integer> result = new HashMap<>();
        result.put(BallResult.BALL, 2);
        result.put(BallResult.STRIKE, 1);

        String message = BaseballGameOutputUtils.resultMessage(result);
        assertThat(message).contains("2볼 1스트라이크");
    }

    @Test
    @DisplayName("Nothing이 3개일 경우에만 Nothing을 출력한다")
    void nothing() {
        Map<BallResult, Integer> result = new HashMap<>();
        result.put(BallResult.NOTHING, 2);

        Map<BallResult, Integer> result2 = new HashMap<>();
        result2.put(BallResult.NOTHING, 3);

        String message = BaseballGameOutputUtils.resultMessage(result);
        String message2 = BaseballGameOutputUtils.resultMessage(result2);
        assertThat(message).contains("");
        assertThat(message2).contains("낫띵");
    }
}