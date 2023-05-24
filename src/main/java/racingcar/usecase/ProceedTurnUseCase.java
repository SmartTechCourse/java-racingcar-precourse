package racingcar.usecase;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.RaceTrack;

import java.util.List;
import java.util.stream.Collectors;

public class ProceedTurnUseCase {

    public RaceTrack execute(RaceTrack track) {
        return new RaceTrack(getNewPositioningCars(track));
    }

    private List<Car> getNewPositioningCars(RaceTrack track) {
        return track.getCars()
                .stream()
                .map(this::getNewPositioningCar)
                .collect(Collectors.toList());
    }

    private Car getNewPositioningCar(Car car) {
        if (!goToNext()) return car;
        return new Car(car.getName(), car.getPosition() + 1);
    }


    private boolean goToNext() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
