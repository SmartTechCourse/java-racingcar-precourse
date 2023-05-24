package racingcar.controller.io;

import racingcar.domain.RaceTrack;

import java.util.List;

public interface GameOutput {

    void showCarInputIndicator();

    void showCountInputIndicator();

    void showResult();

    void showRaceTrackState(RaceTrack raceTrack);

    void showWinner(List<String> winners);

    void showError(String errorMessage);
}
