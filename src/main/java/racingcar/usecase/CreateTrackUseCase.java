package racingcar.usecase;

import racingcar.domain.Car;
import racingcar.domain.RaceTrack;

import java.util.List;
import java.util.stream.Collectors;

public class CreateTrackUseCase {
    public RaceTrack execute(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new RaceTrack(cars);
    }
}
