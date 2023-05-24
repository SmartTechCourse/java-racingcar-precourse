package racingcar.usecase;

import racingcar.domain.Car;
import racingcar.domain.RaceTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetWinnersFromRaceTrackUseCase {

    public List<String> execute(RaceTrack raceTrack) {
        int max = 0;
        ArrayList<String> res = new ArrayList<>();
        for (Car car : raceTrack.getCars()) {
            int position = car.getPosition();
            if (position == max) {
                res.add(car.getName());
            }
            if (position > max) {
                max = position;
                res.clear();
                res.add(car.getName());
            }


        }
        return res;
    }
}
