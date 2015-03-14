package ObjectFramework.General;

import java.util.Random;

/**
 * Created by Gallanoth on 3/13/2015.
 */
public class RandomNumber {

    public static RandomNumber instance;

    public static RandomNumber instance() {
        if (instance == null)
            instance = new RandomNumber();

        return instance;
    }

    private Random random;

    private RandomNumber() {
        this.random = new Random();
    }

    public double generate() {
        return this.random.nextDouble();
    }
}
