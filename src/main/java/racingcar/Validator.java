package racingcar;

import java.util.Arrays;

import static racingcar.Message.CAR_NAME_LENGTH_ERROR;
import static racingcar.Message.TRIAL_TIMES_NOT_NUMBER_ERROR;

public class Validator {

    public static void checkTypeConverting(String input) {
        if (input == null || !input.matches("[0-9]+")) {
            throw new IllegalArgumentException(TRIAL_TIMES_NOT_NUMBER_ERROR.getBody());
        }
    }

    public static void checkCarNameLength(String[] names) {
        boolean isCarNameLengthOverFive = Arrays.stream(names).anyMatch(it -> it.length() > 5);

        if (isCarNameLengthOverFive) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getBody());
        }
    }
}
