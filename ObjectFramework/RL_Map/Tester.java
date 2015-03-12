/**
 * Created by bcoll_000 on 2/19/2015.
 */
package ObjectFramework.RL_Map;
public class Tester
{
    public static void main(String args[])
    {
        char[][] newMap, entityMap;
        MapGenerator map = new CaveGenerator();

        map.createMap(50,60,100);
        newMap = map.getMap();
        EntityMap eMap = new CaveEntityMap(newMap, 10);
        entityMap = eMap.createEntityMap();

        for (int i = 0; i < newMap.length; i ++)
        {
            for (int j = 0; j < newMap[i].length; j++)
            {
                System.out.print(newMap[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < entityMap.length; i ++)
        {
            for (int j = 0; j < entityMap[i].length; j++)
            {
                System.out.print(entityMap[i][j]+" ");
            }
            System.out.println();
        }
        //System.out.print(map.showMap());

    }
}
