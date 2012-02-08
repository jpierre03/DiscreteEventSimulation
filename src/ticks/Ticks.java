package ticks;

import simulation.Simulation;

public class Ticks extends Simulation<Ticks> {

    private double lim;
    static final double TICKTIME = 1.0;

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
        t.schedule(new TickEvent(), TICKTIME);
        t.simulate();
    }
}
