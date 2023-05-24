package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.io.GameInput;
import racingcar.controller.io.GameOutput;
import racingcar.io.GameInputImpl;
import racingcar.io.GameOutputImpl;
import racingcar.io.proxy.GameInputValidateProxy;

public class Application {
    public static void main(String[] args) {
        GameInput gameInput = new GameInputValidateProxy(new GameInputImpl());
        GameOutput gameOutput = new GameOutputImpl();
        GameController controller = new GameController(gameInput, gameOutput);
        controller.start();
    }
}
