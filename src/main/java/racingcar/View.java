package racingcar;

import java.util.List;

public class View {

    public static void print(String message) {
        System.out.println(message);
    }
    public static void print(Message message) {
        System.out.println(message.getBody());
    }

    public static void print(List<CarState> carStates) {
        for (CarState carState : carStates) {
            System.out.println(carState);
        }
        System.out.println();
    }

    public static void print(JudgementResult judgementResult) {
        String winnerMessage = "최종 우승자 : " + String.join(", ", judgementResult.getWinnerNames());
        System.out.println(winnerMessage);
    }
}
