package ticks;

import simulation.Simulation;

public class Ticks extends Simulation<Ticks> {

    private double lim;

    public Ticks(double lim) {
	this.lim = lim;
    }

    @Override
    public final Ticks getState() {
	return this;
    }

    @Override
    public final boolean stop() {
	return this.getTime() >= lim;
    }

    public static void main(String[] args) {
	Ticks t = new Ticks(Double.parseDouble(args[0]));
	t.schedule(new TickEvent(), 1.0);
	t.simulate();
    }
}
