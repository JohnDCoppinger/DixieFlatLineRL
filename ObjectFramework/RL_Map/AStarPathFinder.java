import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by bcoll_000 on 3/6/2015.
 */
public class AStarPathFinder implements PathFinder {

    private int _xStart;
    private int _yStart;
    private int _xEnd;
    private int _yEnd;
    private int _xsize;
    private int _ysize;
    private int MAXSEARCHSIZE = 1000;

    private boolean DIAGONALMOVEMENT = false;
    char[][] _map;
    private ArrayList<Node> open;
    private ArrayList<Node> closed;
    private Node[][] nodes;

    AStarPathFinder(char[][] map, int xStart, int yStart, int xEnd, int yEnd, int xsize, int ysize)
    {
        _xStart = xStart;
        _yStart = yStart;
        _xEnd = xEnd;
        _yEnd = yEnd;
        _map = map;
        _xsize = xsize;
        _ysize = ysize;

        open = new ArrayList<Node>();
        closed = new ArrayList<Node>();

        nodes = new Node[xsize][ysize];

        for (int x = 0; x < xsize; x++)
            for (int y = 0; y < ysize; y++)
                nodes[x][y] = new Node(x, y);
    }

    public void setDiagonalMovement(boolean set)
    {
        DIAGONALMOVEMENT = set;
    }

    @Override
    public Path findPath()
    {
        Path path = new Path();

        return path;
    }

    @Override
    public boolean hasPath()
    {
        open.clear();
        closed.clear();

        open.add(nodes[_xStart][_yStart]);
        nodes[_xEnd][_yEnd].setParent(null);

        int maxDepth = 0;
        while ((maxDepth < MAXSEARCHSIZE) && (open.size() != 0))
        {
            Node current = open.get(0);
            if (current == nodes[_xEnd][_yEnd])
            {
                break;
            }

            open.remove(current);
            closed.add(current);

            for (int x = -1; x < 2; x++)
                for (int y = -1; y < 2; y++)
                {
                   if ((x == 0) && (y == 0))
                        continue;

                    if (!DIAGONALMOVEMENT)
                        if ((x != 0) && (y != 0))
                            continue;

                    int xp = x + current.getX();
                    int yp = y + current.getY();

                    if (isValidLocation(xp, yp))
                    {
                        float nextStepCost = current.getCost() + getMovementCost(current.getX(), current.getY(), _xEnd,_yEnd);
                        Node neighbor = nodes[xp][yp];

                        if (nextStepCost < neighbor.getCost())
                        {
                            if (open.contains(neighbor))
                                open.remove(neighbor);
                            if (closed.contains(neighbor))
                                closed.remove(neighbor);
                        }

                        if (!open.contains(neighbor) && !(closed.contains(neighbor)))
                        {
                            neighbor.setCost(nextStepCost);
                            maxDepth = Math.max(maxDepth, neighbor.setParent(current));
                            open.add(neighbor);
                            Collections.sort(open);
                        }
                    }
                }
        }
        if (nodes[_xEnd][_yEnd].getParent() == null)
            return false;

        return true;
    }



    private float getMovementCost(int x,int y, int xp,int yp)
    {
        //manhattan distance
        return Math.abs(x-xp)+ Math.abs(y-yp);
    }

    private boolean isValidLocation(int x, int y)
    {
        boolean valid =  x >= 0 && x < _xsize && y >= 0 && y < _ysize;

        if(_map[x][y] == '#' || _map[x][y] == 'O')
            valid = false;

        return valid;
    }
}
