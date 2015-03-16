package ObjectFramework.General;

import ObjectFramework.General.Entity.GameEntity;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import java.util.Observable;
import java.util.Observer;
import ObjectFramework.General.Menu.Menu;


public class MapView implements Observer
{	
	private static MapView instance;

    public static MapView instance() 
    {
        if (instance == null)
            instance = new MapView();

        return instance;
    }

    private static WSwingConsoleInterface csi;

	private MapView()
	{

		csi = null;
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
        csi.print(x, y, renderChar, CSIColor.WHITE);
	}

	public void printMapToScreen(GameEntity[][] curMap)
	{
		for(GameEntity[] gEnts : curMap)
		{
			for(GameEntity gEnt : gEnts) {
                if (gEnt != null)
                {
                    printToScreen(gEnt);
                }
            }
		}
        csi.refresh();

	}

    public void printMenuToScreen()
    {
        //TODO
    }

	public CharKey inKey() {
		CharKey key = csi.inkey();
		return key;
	}

    public void update(Observable subject, Object data) {

        GameEntity[][] update = (GameEntity[][])data;
        printMapToScreen(update);
    }

    public void menuUpdate(Menu menu) {

    }

}