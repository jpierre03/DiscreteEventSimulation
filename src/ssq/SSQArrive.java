package ssq;

import simulation.Event;

public class SSQArrive implements Event<SingleServerQueue> {

    @Override
    public final void invoke(SingleServerQueue simulation) {
        double time = simulation.getTime();
        double newIATime = simulation.getRand();

        simulation.schedule(new SSQArrive(), time + newIATime);

        if (simulation.getLength() == 0) {
            simulation.schedule(new SSQDepart(), time
                    + SingleServerQueue.SERVICETIME);
        }

        simulation.setLength(simulation.getLength() + 1);

        System.out.println("Arrival at: " + time + ", new population = "
                + simulation.getLength());
    }

}
