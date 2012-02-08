package ssq;

import simulation.Simulation;
import java.util.Random;

public class SingleServerQueue extends Simulation<SingleServerQueue> {

    private double lim;
    private Random rand;
    private int length = 0;
    static final double SERVICETIME = 0.25;

    public SingleServerQueue(long seed, double lim) {
        this.lim = lim;
        this.rand = new Random(seed);
    }

    @Override
    public final boolean stop() {
        return this.getTime() >= lim;
    }

    @Override
    public final SingleServerQueue getState() {
        return this;
    }

    public final double getRand() {
        return rand.nextDouble();
    }

    public final int getLength() {
        return length;
    }

    public final void setLength(int n) {
        length = n;
    }

    public static void main(String[] args) {
        SingleServerQueue q = new SingleServerQueue(Long.parseLong(args[0]),
                Double.parseDouble(args[1]));

        double firstIATime = q.getRand();

        q.schedule(new SSQArrive(), firstIATime);
        q.schedule(new SSQDepart(), firstIATime + SERVICETIME);
        q.simulate();
        System.out.println("SIMULATION COMPLETE");
    }
}
