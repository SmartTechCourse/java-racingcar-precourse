package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Car> cars;

    private Referee referee;

    private int leftTrialTimes;


    public void proceed() {
        initializeProperty();
        doBeforeRun();
        while (leftTrialTimes > 0) {
            run();
        }
        close();
    }

    private void initializeProperty() {
        initializeCar();
        initializeReferee();
        initializeTrialTimes();
    }

    private void initializeCar() {
        View.print(Message.INPUT_CAR_NAME);
        String inputCarNames = Console.readLine();
        String[] carNames = inputCarNames.split(",");

        try {
            Validator.checkCarNameLength(carNames);
            createCars(carNames);
        } catch (IllegalArgumentException e) {
            View.print(e.getMessage());
            initializeCar();
        }
    }

    private void createCars(String[] carNames) {
        cars = new LinkedList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void initializeReferee() {
        referee = new Referee();
    }

    private void initializeTrialTimes() {
        View.print(Message.INQUIRY_TRY_TIMES);
        String inputTryTimes = Console.readLine();

        try {
            Validator.checkTypeConverting(inputTryTimes);
            leftTrialTimes = Integer.parseInt(inputTryTimes);
        } catch (IllegalArgumentException e) {
            View.print(e.getMessage());
            initializeTrialTimes();
        }
    }

    private void doBeforeRun() {
        printInitialMessage();
    }

    private void printInitialMessage() {
        View.print(Message.EXECUTION_RESULT);
    }

    private void run() {
        moveCars();
        printCarStates();
        decreaseTrialTimes();
    }

    private void moveCars() {
        for(Car car: cars) {
            car.move();
        }
    }

    private void printCarStates() {
        List<CarState> carStates = cars.stream().map(it -> it.getCarState()).collect(Collectors.toList());
        View.print(carStates);
    }

    private void decreaseTrialTimes() {
        leftTrialTimes -= 1;
    }

    private void close() {
        JudgementResult judgementResult = referee.judge(cars);
        printWinner(judgementResult);
    }

    private void printWinner(JudgementResult judgementResult) {
        View.print(judgementResult);
    }
}
