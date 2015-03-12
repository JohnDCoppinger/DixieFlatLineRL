/**
 * Created by Brandon Collins on 2/24/2015.
 */
package ObjectFramework.RL_Map;

public class TownGenerator extends MapGenerator
{
    private char UNUSED = '.';
    private char WALL = '-';
    private char VERTWALL = '|';
    private char FLOOR = ',';
    private char STONEWALL = '#';
    private char CORRIDOR = '#';
    private char DOOR = 'D';
    private char UPSTAIRS = '>';
    private char DOWNSTAIRS = '<';

    private int _objects;
    private int _xsize;
    private int _ysize;
    private int SMALLHOUSESIZE = 7;
    private int LARGEHOUSESIZE = 12;
    private int DOORCHANCE = 25;
    private int TESTING = 1000;

    @Override
    public void createMap(int xMap,int yMap, int objects)
    {
        if (objects < 1)
            _objects = 10;
        else
            _objects = objects;

        if (xMap < 3)
            _xsize = 3;
        else
            _xsize = xMap;

        if (yMap < 3)
            _ysize = 3;
        else
            _ysize = xMap;

        _Map = new char[_xsize][_ysize];


       setup();

        //Create House
        for(int testing = 0; testing < TESTING; testing ++)
            createHouse(getRand(SMALLHOUSESIZE,LARGEHOUSESIZE),getRand(SMALLHOUSESIZE,LARGEHOUSESIZE));

        checkDoorPlacement();
        //Add Downstairs
        placeStairs();
        removeEdge();
    }

    public void placeStairs()
    {
        boolean upstairs = false;
        boolean downstairs = false;
        boolean bothStairs = false;

        while(!bothStairs)
        {
            int x = getRand(0,_xsize-1);
            int y = getRand(0,_ysize-1);

            if (getCell(x, y) == FLOOR)
            {
                if (x - 1 < 0 || x + 1 > _xsize || y - 1 < 0 || y + 1 > _ysize)
                    break;
                else if (getCell(x - 1, y) != DOOR && getCell(x + 1, y) != DOOR && getCell(x, y - 1) != DOOR && getCell(x, y + 1) != DOOR)
                    if (!upstairs)
                    {
                        setCell(x, y, UPSTAIRS);
                        upstairs = true;
                    }
                    else if (!downstairs)
                    {
                        setCell(x, y, DOWNSTAIRS);
                        downstairs = true;
                    }
                else if(upstairs && downstairs)
                        bothStairs = true;
            }
        }
    }

    public void checkDoorPlacement()
    {
        for(int x = 0; x < _xsize; x++)
            for(int y = 0; y < _ysize; y++)
                if(getCell(x,y)== DOOR)
                {
                    if(x - 2 < 0 || y - 2 < 0 || x + 2 > _xsize-1 || y + 2 > _ysize-1)
                        break;
                    else if(getCell(x-1,y) == STONEWALL && getCell(x-2,y) == FLOOR)//Door is blocked by northern wall
                        setCell(x-1,y,FLOOR);
                    else if(getCell(x+1,y) == STONEWALL && getCell(x+2,y) == FLOOR)//Door is blocked by southern wall
                        setCell(x+1,y,FLOOR);
                    else if(getCell(x,y-1) == STONEWALL && getCell(x,y-2) == FLOOR)//Door is blocked by western wall
                        setCell(x,y-1,FLOOR);
                    else if(getCell(x,y+1) == STONEWALL && getCell(x,y+2) == FLOOR)//Door is blocked by eastern wall
                        setCell(x,y+1,FLOOR);
                    else if(getCell(x-1,y) == STONEWALL && getCell(x,y-1) == STONEWALL && getCell(x,y+1) == STONEWALL && getCell(x+1,y) == FLOOR )//Door is blocked by building to north
                    {
                        setCell(x-1,y,UNUSED);
                        if(getCell(x-2,y-1) == FLOOR)
                            setCell(x-2,y-1, STONEWALL);
                        else if(getCell(x-2, y+1) == FLOOR)//y is left to right
                            setCell(x-2,y+1,STONEWALL);
                    }
                    else if(getCell(x-1,y) == FLOOR && getCell(x,y-1) == STONEWALL && getCell(x,y+1) == STONEWALL && getCell(x+1,y) == STONEWALL )//Door is blocked by building to south
                    {
                        setCell(x+1,y,UNUSED);
                        if(getCell(x+2,y-1) == FLOOR)
                            setCell(x+2,y-1, STONEWALL);
                        else if(getCell(x+2, y+1) == FLOOR)
                            setCell(x+2,y+1,STONEWALL);

                    }
                    else if(getCell(x-1,y) == STONEWALL && getCell(x,y-1) == STONEWALL && getCell(x,y+1) == FLOOR && getCell(x+1,y) == STONEWALL )//Door is blocked by building to east
                    {
                        setCell(x,y-1,UNUSED);
                        if(getCell(x-1,y-2) == FLOOR)
                            setCell(x-1,y-2, STONEWALL);
                        else if(getCell(x+1, y-2) == FLOOR)
                            setCell(x+1,y-2,STONEWALL);

                    }
                    else if(getCell(x-1,y) == STONEWALL && getCell(x,y-1) == FLOOR && getCell(x,y+1) == STONEWALL && getCell(x+1,y) == STONEWALL )//Door is blocked by building to west
                    {
                        setCell(x,y+1,UNUSED);
                        if(getCell(x+1,y+2) == FLOOR)
                            setCell(x+1,y+2, STONEWALL);
                        else if(getCell(x-1, y+2) == FLOOR)
                            setCell(x-1,y+2,STONEWALL);
                    }
                }

        //Add checks for door with stonewall on three sides and floor on one side
        //change opposite of floor to unused

    }

    public void removeEdge()
    {
        for(int x = 0; x < _xsize; x++)
            for(int y = 0; y < _ysize; y++)
                if (y == 0)
                    setCell(x, y, UNUSED);
                else if (y == _ysize-1)
                    setCell(x, y, UNUSED);
                else if (x == 0)
                    setCell(x, y, UNUSED);
                else if (x == _xsize-1)
                    setCell(x, y, UNUSED);
    }

    public boolean checkHousePlacement(int xStart, int yStart, int xsize, int ysize)
    {
        char cellType = ' ';

        for(int x = xStart; x < xsize + xStart && x < _xsize; x++)
            for(int y = yStart; y < ysize + yStart && y < _ysize; y++)
            {
                cellType = getCell(x,y);
                if(cellType == STONEWALL || cellType == FLOOR)
                    return false;
            }

        return true;
    }

    public void placeHouse(int xStart, int yStart, int xSize, int ySize)
    {
        boolean madeDoor = false;
        int count = 0;

        for (int x = xStart;  x < xStart+xSize && x < _xsize; x++)
            //ie, making the borders of unwalkable walls
            for (int y = yStart; y < yStart + ySize && y < _ysize; y++)
                if (x == xStart || x == xStart + xSize - 1 || y == yStart || y == ySize + yStart - 1)
                    if (!madeDoor && wasDoorPlaced(x, y, xStart, yStart, xSize, ySize))
                    {
                        count++;
                        if(count > 1)
                            madeDoor = true;
                    }
                    else
                        setCell(x,y,STONEWALL);


                else
                    setCell(x, y, FLOOR);
    }

    public boolean wasDoorPlaced(int x, int y, int xStart, int yStart, int xSize, int ySize)
    {
        if(x == xStart && y == yStart)
            return false;//top left corner
        else if(x == xStart && y == yStart+ySize-1)
            return false;//top right corner
        else if(x == xStart+xSize-1 && y == yStart)
            return false;//bottom left corner
        else if (x== xStart+xSize-1 && y == yStart+ySize-1)
            return false;//bottom right corner
        else
            if(getRand(0,100) < DOORCHANCE)
            {
                setCell(x,y, DOOR);
                return true;
            }

        return false;
    }

    public void createHouse(int xHouseSize, int yHouseSize)
    {
        int xStart = getRand(0,_xsize);
        int yStart = getRand(0, _ysize);

        boolean makeHouse = checkHousePlacement(xStart, yStart, xHouseSize, yHouseSize);

        if(makeHouse)
            placeHouse(xStart,yStart, xHouseSize, yHouseSize);
    }

    public void setup()
    {
        for (int y = 0; y < _ysize; y++)
        {
            for (int x = 0; x < _xsize; x++)
            {
                //ie, making the borders of unwalkable walls
                if (y == 0)
                    setCell(x, y, STONEWALL);
                else if (y == _ysize-1)
                    setCell(x, y, STONEWALL);
                else if (x == 0)
                    setCell(x, y, STONEWALL);
                else if (x == _xsize-1)
                    setCell(x, y, STONEWALL);

                    //and fill the rest with dirt
                else
                    setCell(x, y, UNUSED);
            }
        }
    }

    @Override
    public String showMap()
    {
        String ret = "";
        for(int x = 0; x < _xsize; x++)
        {
            ret += "\n";
            for(int y = 0; y < _ysize; y++)
                ret += _Map[x][y] + " ";

        }
        return ret;
    }

    @Override
    public void setCell(int x, int y, char cellType)
    {
        _Map[x][y] = cellType;
    }

    @Override
    public char getCell(int x, int y) {
        return _Map[x][y];
    }

    @Override
    public char[][] getMap() {
        return _Map;
    }


}
