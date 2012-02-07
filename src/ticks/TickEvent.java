package ticks;

import simulation.Event;

public class TickEvent implements Event<Ticks> {

    @Override
    public void invoke(Ticks simulation) {
	final double TICKTIME = 1.0;
	double time = simulation.getTime();

	System.out.println("Tick at: " + time);
	simulation.schedule(new TickEvent(), time + TICKTIME);
    }
}
