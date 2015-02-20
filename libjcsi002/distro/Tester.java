import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;

public class Tester
{

    public static void main(String[] args) 
    {
        
        //generate a new dungeonModel
        MapModel mModel = new MapModel();
        ConsoleSystemInterface csi = null;
		//csi = tryNewSwing();
		try{
			csi = new WSwingConsoleInterface("My little Java Roguelike - Programming is fun", false);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}

		mModel.drawMap(csi);
    }
   	/*
   	public ConsoleSystemInterface tryNewSwing()
   	{
    	ConsoleSystemInterface csi = null;
		try{
			csi = new WSwingConsoleInterface("My little Java Roguelike - Programming is fun", false);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}
		return csi;
    }
    */
}
