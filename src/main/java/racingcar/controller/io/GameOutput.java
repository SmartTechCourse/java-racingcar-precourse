package racingcar.controller.io;

public interface GameOutput {

    public void showRaceTrackState();
    public void showWinner();
    public void showError(String errorMessage);
}
