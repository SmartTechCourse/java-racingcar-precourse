package racingcar.domain;

public class Car {
    private final String name;
    private final int position;

    public Car(String name) {
        this.position = 0;
        this.name = name;
    }
    public Car(String name, int position) {
        this.position = position;
        this.name = name;
    }
    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
