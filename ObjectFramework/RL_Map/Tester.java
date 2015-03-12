/**
 * Created by bcoll_000 on 2/19/2015.
 */
public class Tester
{
    public static void main(String args[])
    {
        char[][] newMap;
        MapGenerator map = new CaveGenerator();
        map.createMap(50,60,100);
        newMap = map.getMap();

        for (int i = 0; i < newMap.length; i ++)
        {
            for (int j = 0; j < newMap[i].length; j++)
            {
                System.out.print(newMap[i][j]+" ");
            }
            System.out.println();
        }
        //System.out.print(map.showMap());

    }
}
