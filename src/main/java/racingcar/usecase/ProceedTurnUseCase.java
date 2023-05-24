package racingcar.usecase;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.RaceTrack;

public class ProceedTurnUseCase {

    public RaceTrack execute(RaceTrack track) {
        for (Car car :
                track.getCars()) {
            car.setPosition(car.getPosition() + 1);
        }

        return track;
    }

    private boolean goToNext() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
