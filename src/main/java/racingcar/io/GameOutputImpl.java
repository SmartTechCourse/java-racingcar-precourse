package racingcar.io;

import racingcar.controller.io.GameOutput;
import racingcar.domain.Car;
import racingcar.domain.RaceTrack;

import java.util.List;

public class GameOutputImpl implements GameOutput {
    @Override
    public void showCarInputIndicator() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void showCountInputIndicator() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public void showResult() {

    }

    @Override
    public void showRaceTrackState(RaceTrack raceTrack) {
        for (Car car :
                raceTrack.getCars()) {
            printCarPosition(car);
        }
        System.out.print('\n');
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for(int i = 0; i < car.getPosition() ; i++) {
            System.out.print("-");
        }
        System.out.println('\n');
    }

    @Override
    public void showWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for(int i = 0 ; i < winners.size(); i++){
            System.out.print(winners.get(i));
            if(i != winners.size() -1) System.out.print(',');
        }

        System.out.print('\n');
    }

    @Override
    public void showError(String errorMessage) {

    }
}
