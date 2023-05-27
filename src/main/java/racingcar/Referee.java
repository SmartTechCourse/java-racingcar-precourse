package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public JudgementResult judge(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(car -> car.getCarState().getPosition()).max().orElse(-1);
        List<String> winnerCarNames = cars.stream().filter(it -> it.getCarState().getPosition() == maxPosition).map(it -> it.getCarState().getName()).collect(Collectors.toList());
        return new JudgementResult(winnerCarNames);
    }
}
