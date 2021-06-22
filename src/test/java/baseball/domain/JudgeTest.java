package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgeTest {


    @Test
    @DisplayName("자리가 같고 숫자가 같으면 Strike, 자리가 다르면 Ball 그 외는 Nothing을 반환한다")
    void name() {
        List<Ball> answer = Arrays.asList(new Ball(1, 4), new Ball(2, 8), new Ball(3, 1));
        Judge judge = new Judge(answer);

        BallResult result1 = judge.judge(new Ball(2, 8));
        BallResult result2 = judge.judge(new Ball(1, 8));
        BallResult result3 = judge.judge(new Ball(3, 7));

        assertThat(result1).isEqualTo(BallResult.STRIKE);
        assertThat(result2).isEqualTo(BallResult.BALL);
        assertThat(result3).isEqualTo(BallResult.NOTHING);
    }
}