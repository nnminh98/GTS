import java.util.Random;

public class Main {

    public static void main(String[] args){

        Simulation simulation = new Simulation(100);
        System.out.println(simulation.runSimulation(100000));

    }
}
