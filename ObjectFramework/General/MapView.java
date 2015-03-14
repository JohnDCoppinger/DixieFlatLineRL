package ObjectFramework.General;
import  ObjectFramework.Entity.*;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class MapView
{	
	private static MapView instance;

    public static MapView instance() 
    {
        if (instance == null)
            instance = new MapView();

        return instance;
    }

    private WSwingConsoleInterface csi;

	private MapView()
	{
		WSwingConsoleInterface csi = null;
        try {
            csi = new WSwingConsoleInterface("DixieFlatlineRL", false);
        } catch (ExceptionInInitializerError eiie) {
            System.out.println("Fatal Error Initializing Swing Console Box");
            eiie.printStackTrace();
            System.exit(-1);
        }
	}

	private void printToScreen(GameEntity gEnt)
	{
		int x, y, color, bgColor;
		char renderChar;

		x = gEnt.getX();
		y = gEnt.getY();
		color = gEnt.getRender().getColor();
		//bgColor = gEnt.getRender().getBackgroundColor();
		renderChar = gEnt.getRender().getRenderChar();
		csi.print(x, y, renderChar, color);
	}

	public void printMapToScreen(GameEntity[][] curMap)
	{
		for(GameEntity[] gEnts : curMap)
		{
			for(GameEntity gEnt : gEnts)
			{
				printToScreen(gEnt);
			}
		}
	}

	public CharKey inKey()
	{
		CharKey key = csi.inkey();
		return key;
	}

}