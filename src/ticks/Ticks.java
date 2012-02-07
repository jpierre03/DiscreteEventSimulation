package ticks;

import simulation.Simulation;

public class Ticks extends Simulation<Ticks> {

    @Override
    public Ticks getState() {
	return this;
    }

    @Override
    public boolean stop() {
	return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}