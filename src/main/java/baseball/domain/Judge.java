package baseball.domain;

import java.util.List;

public class Judge {

    private final List<Ball> answer;

    public Judge(List<Ball> answer) {
        this.answer = answer;
    }

    public BallResult judge(Ball ball) {
        for (Ball each : answer) {
            if (each.equals(ball)) {
                return BallResult.STRIKE;
            }

            if (each.getNumber() == ball.getNumber()) {
                return BallResult.BALL;
            }
        }
        return BallResult.NOTHING;
    }
}
