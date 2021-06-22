import baseball.domain.BaseballGame;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        Scanner sc = new Scanner(System.in);
        loop(baseballGame, sc);
    }

    private static void loop(BaseballGame baseballGame, Scanner sc) {
        while (!baseballGame.isEnd()) {
            System.out.print(baseballGame.flushOutput());
            baseballGame.inputProcess(sc.nextLine());
        }
    }

}
