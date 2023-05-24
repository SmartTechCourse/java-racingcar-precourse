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
        if (names.size() == 0) throw new IllegalArgumentException("입력된 자동차가 없습니다");
        for (String name :
                names) {
            if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이내여야합니다");
        }

        return names;
    }

    @Override
    public int count() {
        try {
            return src.count();
        } catch (Exception e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
        }
    }
}
