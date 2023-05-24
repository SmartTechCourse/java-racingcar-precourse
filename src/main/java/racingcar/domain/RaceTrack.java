package racingcar.domain;

import java.util.List;

public class RaceTrack {
    private final List<Car> cars;

    public RaceTrack(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
