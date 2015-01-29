import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import java.util.Properties;
 
public class HelloDungeon{
 
	public static void main(String[] args){
 		
 		//
 		//This block was in the tutorial I was following
 		//But in pracitce the csi's constructor WSwingConsoleInterface()
 		//doesn't init with a properties object, though that's what the 
 		//tutorial had written.  Perhaps it was for an older version of 
 		//libjcsi. I don't know.
		Properties text = new Properties();
		text.setProperty("fontSize","12");
		text.setProperty("font", "Courier");
		//
		//

		ConsoleSystemInterface csi = null;
		try{
			csi = new WSwingConsoleInterface("My little Java Roguelike - Programming is fun", false);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}
		int x = 0;
		int y = 0;
		boolean stop = false;
		while(!stop){
			csi.cls();
			csi.print(x,y, '@', CSIColor.WHITE);
			csi.refresh();
			CharKey dir = csi.inkey();
			if(dir.isUpArrow()&& (y-1 >= 0)){
				y--;
			}
			if(dir.isDownArrow() && (y+1 < 25)){
				y++;
			}
			if(dir.isLeftArrow() && (x-1 >= 0)){
				x--;
			}
			if(dir.isRightArrow() && (x+1 < 80)){
				x++;
			}
			if(dir.code == CharKey.Q){
				stop = true;
			}
		}
		System.exit(0);
	}
 }