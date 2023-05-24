package racingcar.controller.io;

import java.lang.reflect.Array;
import java.util.List;

public interface GameInput {

    public List<String> readCarNames();
    public int readTrackSize();
}
