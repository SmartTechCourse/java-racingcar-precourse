package racingcar.controller.io;

import racingcar.domain.RaceTrack;

import java.util.List;

public interface GameOutput {
    public void showCarInputIndicator();
    public void showCountInputIndicator();
    public void showResult();

    public void showRaceTrackState(RaceTrack raceTrack);
    public void showWinner(List<String> winners);
    public void showError(String errorMessage);
}
