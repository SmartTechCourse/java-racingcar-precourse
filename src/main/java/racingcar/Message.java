package racingcar;

public enum Message {

    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),

    INQUIRY_TRY_TIMES("시도할 회수는 몇회인가요?"),

    EXECUTION_RESULT("실행 결과"),

    CAR_NAME_LENGTH_ERROR("[ERROR] 자동차 이름은 5자 이하만 가능하다."),
    TRIAL_TIMES_NOT_NUMBER_ERROR("[ERROR] 시도 횟수는 숫자여야 한다.");


    private String body;

    Message(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }
}
