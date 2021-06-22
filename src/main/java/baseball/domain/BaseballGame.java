package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseballGame {

    private Judge judge;
    private String message;
    private GameStatus gameStatus;
    private Map<BallResult, Integer> result;

    public BaseballGame() {
        setup();
    }

    public void inputProcess(String input) {
        if (gameStatus == GameStatus.ALL_STRIKE) {
            restartOrEnd(input);
            return;
        }

        List<Ball> balls = BallUtils.inputToBalls(input);
        compareBalls(balls);
    }

    private void setup() {
        message = BaseballGameOutputUtils.SELECT_MODE;
        judge = new Judge(BaseballRandomGenerator.randomGeneratorBalls());
        result = new HashMap<>();
        gameStatus = GameStatus.PROCESS;
    }

    private void restartOrEnd(String input) {
        if ("1".equals(input)) {
            setup();
        }

        if ("2".equals(input)) {
            gameStatus = GameStatus.END;
        }
    }

    private void compareBalls(List<Ball> balls) {
        for (Ball ball : balls) {
            result.merge(judge.judge(ball), 1, Integer::sum);
        }
        if (isAllStrike()) {
            gameStatus = GameStatus.ALL_STRIKE;
        }
        message = BaseballGameOutputUtils.resultMessage(result);
        result.clear();
    }

    private boolean isAllStrike() {
        return result.getOrDefault(BallResult.STRIKE, 0) == 3;
    }

    public String flushOutput() {
        return message;
    }

    public boolean isEnd() {
        return gameStatus == GameStatus.END;
    }
}
