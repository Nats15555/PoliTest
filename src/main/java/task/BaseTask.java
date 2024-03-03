package task;

/**
 * Класс основных(базовых) задач
 */
public class BaseTask {
    private final Priority priority;
    private State state;
    private static boolean isRunning;

    public BaseTask(Priority priority, State state) {
        this.priority = priority;
        if (state.equals(State.RUNNING) || state.equals(State.READY) || state.equals(State.SUSPENDED)) {
            this.state = state;
            if (state.equals(State.RUNNING)) {
                isRunning = true;
            }
        } else {
            throw new RuntimeException("Было задано невернео состояние для основной(базовой) задачи: " + state.name());
        }
    }

    public Priority getPriority() {
        return priority;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static boolean isIsRunning() {
        return isRunning;
    }

    /**
     * Изменение состояния задачи согласно переданной транзакции
     */
    public void changeState(Transition transition) {
        switch (state) {
            case RUNNING -> {
                if (transition.equals(Transition.TERMINATE)) {
                    this.state = State.SUSPENDED;
                    isRunning = false;
                }
                if (transition.equals(Transition.PREEMPT)) {
                    this.state = State.READY;
                    isRunning = false;
                }
            }
            case SUSPENDED -> {
                if (transition.equals(Transition.ACTIVATE)) {
                    this.state = State.READY;
                }
            }
            case READY -> {
                if (transition.equals(Transition.START)) {
                    this.state = State.RUNNING;
                    isRunning = true;
                }
            }
        }
    }
}
