package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.io.GameInput;

import java.util.Arrays;
import java.util.List;

public class GameInputImpl implements GameInput {

    @Override
    public List<String> readCarNames() {
        String line = Console.readLine();
        return Arrays.asList(line.split(","));
    }

    @Override
    public int count() {
        String line = Console.readLine();
        return Integer.getInteger(line, -1);
    }
}
