import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestSimulation {

    @Test
    public void setupTest(){
        Simulation simulation = new Simulation(100);
        simulation.setup(10);
        Assertions.assertEquals(simulation.plane.size(), 10);
    }

    @Test
    public void setupTest2(){
        Simulation simulation = new Simulation(0);
        simulation.setup(-5);
        Assertions.assertEquals(simulation.plane.size(), 0);
    }

    @Test
    public void seatPassengerTest() {
        Simulation simulation = new Simulation(100);
        simulation.plane.remove(Integer.valueOf(5));
        Assertions.assertTrue(simulation.plane.contains(10));
        simulation.seatPassenger(10);
        Assertions.assertFalse(simulation.plane.contains(10));
    }

    @Test
    public void seatPassengerTest2() {
        Simulation simulation = new Simulation(100);
        Assertions.assertTrue(simulation.plane.contains(5));
        simulation.plane.remove(Integer.valueOf(5));
        Assertions.assertFalse(simulation.plane.contains(5));
        simulation.seatPassenger(10);
        Assertions.assertEquals(98, simulation.plane.size());
    }

    @Test
    public void runIterationTest(){
        Simulation simulation = new Simulation(100);
        simulation.runIteration();
        Assertions.assertEquals(simulation.plane.size(), 1);
        Assertions.assertTrue(simulation.plane.get(0) == 100 || simulation.plane.get(0) == 1);
    }

    @Test
    public void runSimulationTest(){
        Simulation simulation = new Simulation(100);
        double probability = simulation.runSimulation(1000);
        Assertions.assertTrue(probability < 1);
        Assertions.assertTrue(probability > 0);
    }
}
