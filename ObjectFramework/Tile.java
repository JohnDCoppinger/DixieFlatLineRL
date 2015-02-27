import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;

public class Tile{

	char draw;
	int  x;
	int  y;
	int color;

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

	public int color()
	{return this.color;}

	private char setDraw(int id)
	{
		char draw;
		switch(id)
		{
			case 0: draw = ' '; break;
	        case 1: draw = '#'; break;
	        case 2: draw = '.'; break;
	        case 3: draw = 'O'; break;
	        case 4: draw = '.'; break;
	        case 5: draw = '/'; break;
	        case 6: draw = '<'; break;
	        case 7: draw = '>'; break;
	        case 8: draw = '*'; break;
	        default: draw = ' '; break;
	    }
	    return draw;
	}

	private int setColor(int id)
	{
		int color = ConsoleSystemInterface.RED; 
		return color;
	}

}