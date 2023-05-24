package racingcar.controller;

import racingcar.controller.io.GameInput;
import racingcar.controller.io.GameOutput;
import racingcar.domain.Car;
import racingcar.domain.RaceTrack;
import racingcar.usecase.CreateTrackUseCase;
import racingcar.usecase.GetWinnersFromRaceTrackUseCase;
import racingcar.usecase.ProceedTurnUseCase;

import java.util.List;

public class GameController {

    private final CreateTrackUseCase createTrackUseCase = new CreateTrackUseCase();
    private final ProceedTurnUseCase proceedTurnUseCase = new ProceedTurnUseCase();
    private final GetWinnersFromRaceTrackUseCase getWinnersFromRaceTrackUseCase = new GetWinnersFromRaceTrackUseCase();
    private final GameInput gameInput;
    private final GameOutput gameOutput;

    public GameController(
            GameInput gameInput,
            GameOutput gameOutput
    ) {
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;
    }

    public void start() {
        RaceTrack raceTrack = createTrackUseCase.execute(readCarNames());
        int count = readCount();
        gameOutput.showResult();
        for (int i = 0; i < count; i++) {
            raceTrack = proceedTurnUseCase.execute(raceTrack);
            gameOutput.showRaceTrackState(raceTrack);
        }
        gameOutput.showWinner(getWinnersFromRaceTrackUseCase.execute(raceTrack));
    }

    private List<String> readCarNames() {
        List<String> carNames = null;
        while (carNames == null) {
            try {
                gameOutput.showCarInputIndicator();
                carNames = gameInput.readCarNames();
            } catch (Exception e) {
                gameOutput.showError(e.getMessage());
            }
        }
        return carNames;
    }

    private int readCount() {
        boolean read = false;
        int count = 0;
        while (!read) {
            try {
                gameOutput.showCountInputIndicator();
                count = gameInput.count();
                read = true;
            } catch (Exception e) {
                gameOutput.showError(e.getMessage());
            }
        }
        return count;
    }
}
