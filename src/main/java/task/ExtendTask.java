package task;

/**
 * Класс расширенных задач
 */
public class ExtendTask {
    private final Priority priority;
    private State state;
    private static boolean isRunning;
    //TODO завершена ли задача процессором

    public ExtendTask(Priority priority, State state) {
        this.priority = priority;
        this.state = state;
        if (state.equals(State.RUNNING)) {
            isRunning = true;
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
                if (transition.equals(Transition.WAIT)) {
                    this.state = State.WAITING;
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
            case WAITING -> {
                if (transition.equals(Transition.RELEASE)) {
                    this.state = State.READY;
                }
            }
        }
    }
}
