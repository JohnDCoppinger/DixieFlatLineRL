/**
 * Created by bcoll_000 on 2/19/2015.
 */
public class DungeonGenerator extends MapGenerator
{
    private int SMALLESTROOM = 4;
    private int SMALLESTCORRIDOR = 2;

    private int _objects;
    private int TESTING = 1000;

    private char UNUSED = ' ';
    private char WALL = '-';
    private char VERTWALL = '|';
    private char FLOOR = '.';
    private char STONEWALL = 'O';
    private char CORRIDOR = '#';
    private char DOOR = 'D';
    private char UPSTAIRS = '>';
    private char DOWNSTAIRS = '<';

    private char[] _dungeonMap;

    public void createMap(int xMap, int yMap, int objects)
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
        _dungeonMap = new char[_xsize *_ysize];

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


        makeRoom(_xsize / 2, _ysize / 2, 8, 6, getRand(0, 3));
        int currentFeatures = 1;

        for (int tries = 0; tries < 1000; tries++)
        {
            if (currentFeatures == objects)
                break;

            //start with a random wall
            int newx = 0;
            int xmod = 0;
            int newy = 0;
            int ymod = 0;
            int validTile = -1;

            //1000 chances to find a suitable object (room or corridor)..

            for (int testing = 0; testing < TESTING; testing++)
            {
                newx = getRand(1, _xsize - 1);
                newy = getRand(1, _ysize - 1);
                validTile = -1;


                if (getCell(newx, newy) == WALL || getCell(newx, newy) == CORRIDOR ||getCell(newx, newy) == VERTWALL )
                {
                    //check if we can reach the place
                    if (getCell(newx, newy + 1) == FLOOR || getCell(newx, newy + 1) == CORRIDOR)
                    {
                        validTile = 0;
                        xmod = 0;
                        ymod = -1;
                    }
                    else if (getCell(newx - 1, newy) == FLOOR || getCell(newx - 1, newy) == CORRIDOR)
                    {
                        validTile = 1;
                        xmod = +1;
                        ymod = 0;
                    }
                    else if (getCell(newx, newy - 1) == FLOOR || getCell(newx, newy - 1) == CORRIDOR)
                    {
                        validTile = 2;
                        xmod = 0;
                        ymod = +1;
                    }
                    else if (getCell(newx + 1, newy) == FLOOR || getCell(newx + 1, newy) == CORRIDOR)
                    {
                        validTile = 3;
                        xmod = -1;
                        ymod = 0;
                    }

                    if (validTile > -1)
                    {
                        if (getCell(newx, newy + 1) == DOOR) //north
                            validTile = -1;
                        else if (getCell(newx - 1, newy) == DOOR)//east
                            validTile = -1;
                        else if (getCell(newx, newy - 1) == DOOR)//south
                            validTile = -1;
                        else if (getCell(newx + 1, newy) == DOOR)//west
                            validTile = -1;
                    }

                    if (validTile > -1)
                        break;
                }
            }

                if (validTile > -1)
                {
                    //choose what to build now at our newly found place, and at what direction
                    int feature = getRand(0, 100);

                    if (feature <= CHANCEROOM)
                    { //a new room
                        if (makeRoom((newx + xmod), (newy + ymod), 8, 6, validTile))
                        {
                            currentFeatures++; //add to our quota

                            //then we mark the wall opening with a door
                            setCell(newx, newy, DOOR);

                            //clean up infront of the door so we can reach it
                            setCell((newx + xmod), (newy + ymod), FLOOR);
                        }
                    }
                    else if (feature >= CHANCEROOM)
                    { //new corridor
                        if (makeCorridor((newx + xmod), (newy + ymod), 6, validTile))
                        {
                            //same thing here, add to the quota and a door
                            currentFeatures++;
                            setCell(newx, newy, DOOR);
                        }
                    }
                }

        }
        addFeatures();
        saveMap();
    }

    private void addFeatures()
    {

        int newx = 0;
        int newy = 0;
        int ways = 0; //from how many directions we can reach the random spot from
        int state = 0; //the state the loop is in, start with the stairs

        while (state != 10)
        {
            for (int testing = 0; testing < TESTING; testing++)
            {
                newx = getRand(1, _xsize - 1);
                newy = getRand(1, _ysize - 2);


                ways = 4;

                //check if we can reach the spot
                //north
                if (getCell(newx, newy + 1) == FLOOR || getCell(newx, newy + 1) == CORRIDOR)
                    if (getCell(newx, newy + 1) != DOOR)
                        ways--;

                //east
                if (getCell(newx - 1, newy) == FLOOR || getCell(newx - 1, newy) == CORRIDOR)
                    if (getCell(newx - 1, newy) != DOOR)
                        ways--;

                //south
                if (getCell(newx, newy - 1) == FLOOR || getCell(newx, newy - 1) == CORRIDOR)
                    if (getCell(newx, newy - 1) != DOOR)
                        ways--;

                //west
                if (getCell(newx + 1, newy) == FLOOR || getCell(newx + 1, newy) == CORRIDOR)
                    if (getCell(newx + 1, newy) != DOOR)
                        ways--;

                if (state == 0)
                {
                    if (ways == 0)
                    {
                        //we're in state 0, let's place a "upstairs" thing
                        setCell(newx, newy, UPSTAIRS);
                        state = 1;
                        break;
                    }
                }
                    else if (state == 1){
                        if (ways == 0)
                        {
                            //state 1, place a "downstairs"
                            setCell(newx, newy, DOWNSTAIRS);
                            state = 10;
                            break;
                        }
                }
            }
        }
    }

    public void saveMap()
    {
        for(int x = 0; x < _xsize; x ++)
            for(int y = 0; y < _ysize; y++)
            {
                if(getCell(x,y) != STONEWALL)
                    _Map[x][y] = _dungeonMap[x+_xsize * y];
                else
                    _Map[x][y] = UNUSED;
            }
    }

    public char[][] getMap()
    {
        return _Map;
    }

    private boolean makeCorridor(int x, int y, int length, int direction)
    {
        int len = getRand(SMALLESTCORRIDOR, length);
        int xtemp = 0;
        int ytemp = 0;
        int dir = 0;

        if(direction > 0 && direction < 4)
            dir = direction;

        if(x < 0 || x > _xsize)
            return false;
        if(y < 0 || y > _ysize)
            return false;

        switch (dir)
        {
            case 0:
                if(!makeCorridorNorth(x,y, len))
                    return false;
                break;
            case 1:
                if(!makeCorridorEast(x, y, len))
                    return false;
                break;
            case 2:
                if(!makeCorridorSouth(x, y, len))
                    return false;
                break;
            case 3:
                if(!makeCorridorWest(x, y, len))
                    return false;
                break;
        }

        return true;
    }

    private boolean makeCorridorNorth(int x,int y, int length)
    {
        int xtemp = x;
        int ytemp;

        // make sure it's not out of the boundaries
        for (ytemp = y; ytemp > (y-length); ytemp--) {
            if (ytemp < 0 || ytemp > _ysize) return false;
            if (getCell(xtemp, ytemp) != UNUSED) return false;
        }

        //if we're still here, let's start building
        for (ytemp = y; ytemp > (y-length); ytemp--) {
            setCell(xtemp, ytemp, CORRIDOR);
        }
        return true;

    }

    private boolean makeCorridorSouth(int x,int y, int length)
    {
        int ytemp;

        int xtemp = x;

        for (ytemp = y; ytemp < (y+length); ytemp++) {
            if (ytemp < 0 || ytemp > _ysize) return false;
            if (getCell(xtemp, ytemp) != UNUSED) return false;
        }

        for (ytemp = y; ytemp < (y+length); ytemp++) {
            setCell(xtemp, ytemp, CORRIDOR);
        }
        return true;
    }

    private boolean makeCorridorEast(int x,int y, int length)
    {
        int xtemp;
        int ytemp = y;

        for (xtemp = x; xtemp < (x+length); xtemp++) {
            if (xtemp < 0 || xtemp > _xsize) return false;
            if (getCell(xtemp, ytemp) != UNUSED) return false;
        }

        for (xtemp = x; xtemp < (x+length); xtemp++) {
            setCell(xtemp, ytemp, CORRIDOR);
        }
        return true;
    }

    private boolean makeCorridorWest(int x,int y, int length)
    {
        int xtemp;
        int ytemp = y;

        for (xtemp = x; xtemp > (x-length); xtemp--) {
            if (xtemp < 0 || xtemp > _xsize) return false;
            if (getCell(xtemp, ytemp) != UNUSED) return false;
        }

        for (xtemp = x; xtemp > (x-length); xtemp--) {
            setCell(xtemp, ytemp, CORRIDOR);
        }
        return true;
    }

    private boolean makeRoom(int x, int y, int xlength, int ylength, int direction)
    {
        int xlen = getRand(SMALLESTROOM, xlength);
        int ylen = getRand(SMALLESTROOM, ylength);

        int dir = 0;

        if(direction > 0 && direction < 4)
            dir = direction;

        switch(dir)
        {
            case 0:
                if(!makeRoomNorth(x,y,xlen,ylen))
                    return false;
                break;
            case 1:
                if(!makeRoomEast(x,y,xlen,ylen))
                    return false;
                break;
            case 2:
                if(!makeRoomSouth(x,y,xlen,ylen))
                    return false;
                break;
            case 3:
                if(!makeRoomWest(x,y,xlen,ylen))
                    return false;
                break;

        }

        return true;
    }

    private boolean makeRoomNorth(int x, int y, int xlength, int ylength)
    {
        //Check if there's enough space left for it
        for (int ytemp = y; ytemp > (y-ylength); ytemp--) {
            if (ytemp < 0 || ytemp > _ysize) return false;
            for (int xtemp = (x-xlength/2); xtemp < (x+(xlength+1)/2); xtemp++) {
                if (xtemp < 0 || xtemp > _xsize) return false;
                if (getCell(xtemp, ytemp) != UNUSED) return false; //no space left...
            }
        }

        //we're still here, build
        for (int ytemp = y; ytemp > (y-ylength); ytemp--) {
            for (int xtemp = (x-xlength/2); xtemp < (x+(xlength+1)/2); xtemp++) {
                //start with the walls
                if (xtemp == (x-xlength/2)) setCell(xtemp, ytemp, WALL);
                else if (xtemp == (x+(xlength-1)/2)) setCell(xtemp, ytemp, WALL);
                else if (ytemp == y) setCell(xtemp, ytemp, VERTWALL);
                else if (ytemp == (y-ylength+1)) setCell(xtemp, ytemp, VERTWALL);
                    //and then fill with the floor
                else setCell(xtemp, ytemp, FLOOR);
            }
        }
        return true;
    }

    private boolean makeRoomSouth(int x, int y, int xlength, int ylength)
    {
        for (int ytemp = y; ytemp < (y+ylength); ytemp++) {
            if (ytemp < 0 || ytemp > _ysize) return false;
            for (int xtemp = (x-xlength/2); xtemp < (x+(xlength+1)/2); xtemp++) {
                if (xtemp < 0 || xtemp > _xsize) return false;
                if (getCell(xtemp, ytemp) != UNUSED) return false;
            }
        }

        for (int ytemp = y; ytemp < (y+ylength); ytemp++) {
            for (int xtemp = (x-xlength/2); xtemp < (x+(xlength+1)/2); xtemp++) {
                if (xtemp == (x-xlength/2)) setCell(xtemp, ytemp, WALL);
                else if (xtemp == (x+(xlength-1)/2)) setCell(xtemp, ytemp, WALL);
                else if (ytemp == y) setCell(xtemp, ytemp, VERTWALL);
                else if (ytemp == (y+ylength-1)) setCell(xtemp, ytemp, VERTWALL);
                else setCell(xtemp, ytemp, FLOOR);
            }
        }
        return true;
    }

    private boolean makeRoomEast(int x, int y, int xlength, int ylength)
    {
        for (int ytemp = (y-ylength/2); ytemp < (y+(ylength+1)/2); ytemp++) {
            if (ytemp < 0 || ytemp > _ysize) return false;
            for (int xtemp = x; xtemp < (x+xlength); xtemp++) {
                if (xtemp < 0 || xtemp > _xsize) return false;
                if (getCell(xtemp, ytemp) != UNUSED) return false;
            }
        }

        for (int ytemp = (y-ylength/2); ytemp < (y+(ylength+1)/2); ytemp++) {
            for (int xtemp = x; xtemp < (x+xlength); xtemp++) {
                if (xtemp == x) setCell(xtemp, ytemp, WALL);
                else if (xtemp == (x+xlength-1)) setCell(xtemp, ytemp, WALL);
                else if (ytemp == (y-ylength/2)) setCell(xtemp, ytemp, VERTWALL);
                else if (ytemp == (y+(ylength-1)/2)) setCell(xtemp, ytemp, VERTWALL);
                else setCell(xtemp, ytemp, FLOOR);
            }
        }
        return true;
    }

    private boolean makeRoomWest(int x, int y, int xlength, int ylength)
    {
        for (int ytemp = (y-ylength/2); ytemp < (y+(ylength+1)/2); ytemp++) {
            if (ytemp < 0 || ytemp > _ysize) return false;
            for (int xtemp = x; xtemp > (x-xlength); xtemp--) {
                if (xtemp < 0 || xtemp > _xsize) return false;
                if (getCell(xtemp, ytemp) != UNUSED) return false;
            }
        }

        for (int ytemp = (y-ylength/2); ytemp < (y+(ylength+1)/2); ytemp++) {
            for (int xtemp = x; xtemp > (x-xlength); xtemp--) {
                if (xtemp == x) setCell(xtemp, ytemp, WALL);
                else if (xtemp == (x-xlength+1)) setCell(xtemp, ytemp, WALL);
                else if (ytemp == (y-ylength/2)) setCell(xtemp, ytemp, VERTWALL);
                else if (ytemp == (y+(ylength-1)/2)) setCell(xtemp, ytemp, VERTWALL);
                else setCell(xtemp, ytemp, FLOOR);
            }
        }
        return true;
    }

    public String showMap()
    {
        String ret = "";
        for(int x = 0; x < _xsize; x++)
        {
            ret += "\n";
            for(int y = 0; y < _ysize; y++)
                ret += _dungeonMap[x+_xsize * y] + " ";

        }
        return ret;
    }
    public void setCell(int x, int y, char cellType)
    {
        _dungeonMap[x + _xsize * y] = cellType;
    }

    public char getCell(int x, int y)
    {
        return _dungeonMap[x + _xsize * y];
    }
}
