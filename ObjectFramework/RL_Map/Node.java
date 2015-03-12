/**
 * Created by bcoll_000 on 3/9/2015.
 */
package ObjectFramework.RL_Map;
public class Node implements Comparable
{
    private int _x;
    private int _y;
    private Node _parent;
    private float _cost;
    private int _depth;

    public Node(int x, int y)
    {
        _x = x;
        _y = y;
    }

    public int getX()
    {
        return _x;
    }

    public int getY()
    {
        return _y;
    }

    public float getCost()
    {
        return _cost;
    }

    public void setCost(float f)
    {
        _cost = f;
    }

    public int setParent(Node n)
    {
        if(n != null)
        {
            _depth = n._depth + 1;
            _parent = n;
        }

        return _depth;
    }

    public Node getParent()
    {
        return _parent;
    }

    public int compareTo(Object other)
    {
        Node o = (Node) other;

        float f = _cost;
        float of = o._cost;

        if (f < of) {
            return -1;
        } else if (f > of) {
            return 1;
        } else {
            return 0;
        }
    }
}
