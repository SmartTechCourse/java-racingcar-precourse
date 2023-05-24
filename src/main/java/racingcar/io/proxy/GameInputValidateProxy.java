package racingcar.io.proxy;

import racingcar.controller.io.GameInput;

import java.util.List;

public class GameInputValidateProxy implements GameInput {
    private final GameInput src;

    public GameInputValidateProxy(GameInput gameInput) {
        this.src = gameInput;
    }

    @Override
    public List<String> readCarNames() {
        List<String> names = src.readCarNames();
        if (names.size() == 0) throw new IllegalArgumentException();
        for (String name :
                names) {
            if (names.size() > 5) throw new IllegalArgumentException();
        }

        return names;
    }

    @Override
    public int count() {
        int size = src.count();
        if (size < 0) throw new IllegalArgumentException();
        return size;
    }
}
