package racingcar;

import java.util.List;

public class JudgementResult {

    private List<String> winnerNames;

    public JudgementResult(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
