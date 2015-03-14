import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

package ObjectFramework.General;

public class MapController
{

	ConsoleSystemInterface csi;

	public MapController()
	{
		ConsoleSystemInterface csi = null;
        try {
            csi = new WSwingConsoleInterface("DixieFlatlineRL", false);
        } catch (ExceptionInInitializerError eiie) {
            System.out.println("Fatal Error Initializing Swing Console Box");
            eiie.printStackTrace();
            System.exit(-1);
        }
	}

	public void printToScreen(GameEntity gEnt)
	{
		int x, y, color, bgColor;
		char renderChar;

		x = gEnt.getX();
		y = gEnt.getY();
		color = gEnt.getRender().getColor();
		bgColor = gEnt.getRender().getBackgroundColor();
		renderChar = gEnt.getRender().getRenderChar();
		csi.print(x, y, renderChar, color, bgColor);
	}

	public void printMapToScreen(GameEntity[][] curMap)
	{
		for(GameEntity gEnt : curMap)
		{
			printToScreen(gEnt);
		}
	}
}