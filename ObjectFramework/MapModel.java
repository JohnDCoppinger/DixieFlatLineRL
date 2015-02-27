import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;

public class MapModel
{
	Dungeon dungeon;
	int     dX   = 80; 
	int     dY   = 25;
	int     dObj = 50;
	Tile[]  map;   
    public MapModel()
	{
		this.dungeon = new Dungeon();
		dungeon.createDungeon(dX, dY, dObj);

		int[] tempDungeon = dungeon.handOffDungeon();
		map = parseRawDungeon(tempDungeon, dX, dY);
	}

	private Tile[] parseRawDungeon(int[] dungeon, int dX, int dY)
	{
		int loc = 0;
		Tile[] map = new Tile[dX * dY];
		for(int i = 0; i < dY; i++)
		{
			for(int j = 0; j < dX; j++)
			{
				map[loc] = new Tile(dungeon[loc], j, i);
				loc++;
			}
		}
		return map;
	}

	public void drawMap(ConsoleSystemInterface csi)
	{
		for(Tile tl : map)
		{
			csi.print(tl.getX(), tl.getY(), tl.draw(), tl.color() );
		}
		csi.refresh();
	}
} 
/*
class Tile{

	char draw  = ' ';
	int  x     = 0;
	int  y     = 0;
	int  color = 0;

	public Tile(int id, int x, int y)
	{
		this.x     = x;
		this.y     = y;
		this.draw  = setDraw(id);
		this.color = setColor(id);
	}

	public int getX()
	{return this.x;}

	public int getY()
	{return this.y;}

	public char draw()
	{return this.draw;}

	public int  color()
	{return this.color;}

	private char setDraw(int id)
	{
		char draw;
		switch(id)
		{
			case  0: draw = ' '; break;
	        case  1: draw = '#'; break;
	        case  2: draw = '.'; break;
	        case  3: draw = 'O'; break;
	        case  4: draw = '.'; break;
	        case  5: draw = '/'; break;
	        case  6: draw = '<'; break;
	        case  7: draw = '>'; break;
	        case  8: draw = '*'; break;
	        default: draw = ' '; break;
	    }
	    return draw;
	}

	private int setColor(int id)
	{
		int color = ConsoleSystemInterface.WHITE; 
		return color;
	}

}
*/