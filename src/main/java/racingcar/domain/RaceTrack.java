package racingcar.domain;

import java.util.List;

public class RaceTrack {
    private final List<Car> cars;
    private final int trackSize;

    public RaceTrack(List<Car> cars, int trackSize) {
        this.cars = cars;
        this.trackSize = trackSize;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isGoalInAtLeastOne() {
        return cars.stream().anyMatch(car -> car.getPosition() >= trackSize);
    }
}
