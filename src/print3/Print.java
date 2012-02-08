package print3;

import simulation.Event;

public class Print implements Event<Print3> {

    private final int n;

    public Print(int n) {
        this.n = n;
    }

    @Override
    public final void invoke(Print3 simulation) {
        System.out.println("Event " + n + " invoked at time "
                + simulation.getTime());
    }

}
