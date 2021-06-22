package baseball.domain;

import java.util.Map;

public class BaseballGameOutputUtils {

    public static final String SELECT_MODE = "숫자를 입력해 주세요 : ";
    public static final String ALL_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public static String resultMessage(Map<BallResult, Integer> result) {
        StringBuilder sb = new StringBuilder();

        if (isAllStrike(result)) {
            return sb.append(ALL_STRIKE).toString();
        }

        if (isAllNothing(result)) {
            sb.append("낫띵");
        }

        if (result.containsKey(BallResult.BALL)) {
            sb.append(result.get(BallResult.BALL)).append("볼").append(" ");
        }

        if (result.containsKey(BallResult.STRIKE)) {
            sb.append(result.get(BallResult.STRIKE)).append("스트라이크");
        }

        sb.append("\n").append(SELECT_MODE);
        return sb.toString();
    }

    private static boolean isAllStrike(Map<BallResult, Integer> result) {
        return result.getOrDefault(BallResult.STRIKE, 0) == 3;
    }

    private static boolean isAllNothing(Map<BallResult, Integer> result) {
        return result.getOrDefault(BallResult.NOTHING, 0) == 3;
    }

}
