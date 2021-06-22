package baseball.domain;

import java.util.Map;

public class BaseballResultMessageGenerator {

    public static String resultMessage(Map<BallResult, Integer> result) {
        StringBuilder sb = new StringBuilder();

        if (result.containsKey(BallResult.BALL)) {
            sb.append(result.get(BallResult.BALL)).append("볼");
        }
        if (result.containsKey(BallResult.STRIKE)) {
            sb.append(" ").append(result.get(BallResult.STRIKE)).append("스트라이크");
        }
        if (result.containsKey(BallResult.NOTHING)) {
            if (result.get(BallResult.NOTHING) == 3) {
                sb.append("낫띵");
            }
        }
        return sb.toString();
    }

}
