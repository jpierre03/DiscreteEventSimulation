package ticks;

import simulation.Event;

public class TickEvent implements Event<Ticks> {

    @Override
    public final void invoke(Ticks simulation) {
        double time = simulation.getTime();

        System.out.println("Tick at: " + time);
        simulation.schedule(new TickEvent(), time + Ticks.TICKTIME);
    }
}
