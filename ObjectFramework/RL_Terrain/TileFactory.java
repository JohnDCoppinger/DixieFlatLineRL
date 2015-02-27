public class TileFactory{
	
	public TileFactory(char ch)
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
}