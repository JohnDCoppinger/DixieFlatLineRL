package ObjectFramework.RL_Map;
import java.util.Date;
import java.util.Random;

/**
 * Created by bcoll_000 on 3/11/2015.
 */

public abstract class ActorMapGenerator
{
    protected long oldseed = 0;

    public abstract char[][] createEntityMap();

    public int getRand(int min, int max)
    {
        Date now = new Date();
        long seed = now.getTime() + oldseed;
        oldseed = seed;

        Random gen = new Random(seed);
        int n = max - min + 1;
        int i = gen.nextInt(n);
        if (i < 0) i = -i;

        return min + i;
    }
}
