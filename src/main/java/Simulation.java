import java.util.ArrayList;
import java.util.Random;

public class Simulation {
    public ArrayList<Integer> plane;
    private final Random rand = new Random();
    private final int seatNum;

    public Simulation(int seatNumber){
        if (seatNumber < 0) seatNumber = 0;
        this.seatNum = seatNumber;
        this.setup(seatNumber);
    }

    public void setup(int seatNumber){
        if (seatNumber < 0) seatNumber = 0;
        this.plane = new ArrayList<>();
        for (int i = 1; i <= seatNumber; i++){
            plane.add(i);
        }
    }

    public void seatPassenger(int i) {
        if (plane.contains(i)){
            plane.remove(Integer.valueOf(i));
            return;
        }
        int randomNumber = rand.nextInt(plane.size());
        plane.remove(randomNumber);
    }

    public boolean runIteration(){
        plane.remove(Integer.valueOf(rand.nextInt(seatNum) + 1));
        for (int i = 2; i <= seatNum - 1; i++){
            seatPassenger(i);
        }
        return plane.contains(seatNum);
    }

    public double runSimulation(int n){
        if (n < 1) return 1.0;
        int success = 0;
        for (int i = 0; i < n; i++){
            this.setup(seatNum);
            if (runIteration()){
                success++;
            }
        }
        return (double)success / n;
    }
}
