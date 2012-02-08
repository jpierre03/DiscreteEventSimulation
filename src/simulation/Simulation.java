package simulation;

import java.util.PriorityQueue;
import java.util.Queue;

public abstract class Simulation<S> {

    private double time = 0;
    private Queue<ScheduledEvent<S>> diary =
            new PriorityQueue<ScheduledEvent<S>>();

    public abstract boolean stop();

    public abstract S getState();

    public final double getTime() {
        return time;
    }

    public final void schedule(Event<S> e, double offset) {
        ScheduledEvent<S> sE = new ScheduledEvent<S>(e, offset);
        diary.add(sE);
    }

    protected final void simulate() {
        while (diary.size() > 0) {
            ScheduledEvent<S> e = diary.poll();
            time = e.getTime();

            if (!stop()) {
                e.getEvent().invoke(getState());
            } else {
                break;
            }
        }
    }
}
