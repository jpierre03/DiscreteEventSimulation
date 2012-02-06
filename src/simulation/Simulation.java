package simulation;

public abstract class Simulation<S> {

    abstract boolean stop();

    abstract S getState();

    void schedule(Event<S> e, double offset) {

    }

    void simulate() {

    }

}
