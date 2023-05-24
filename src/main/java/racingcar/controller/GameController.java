package racingcar.controller;

import racingcar.controller.io.GameInput;
import racingcar.controller.io.GameOutput;
import racingcar.domain.RaceTrack;
import racingcar.usecase.CreateTrackUseCase;
import racingcar.usecase.GetWinnersFromRaceTrackUseCase;
import racingcar.usecase.ProceedTurnUseCase;

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
        try {
            RaceTrack raceTrack = createTrackUseCase.execute(gameInput.readCarNames());
            int count =  gameInput.count();
            for(int i = 0; i< count; i++){
                raceTrack = proceedTurnUseCase.execute(raceTrack);
                gameOutput.showRaceTrackState(raceTrack);
            }
            gameOutput.showWinner(getWinnersFromRaceTrackUseCase.execute(raceTrack));
        } catch (Exception e) {
            gameOutput.showError(e.getMessage());
        }

    }
}
