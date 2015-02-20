import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
/**
 * This shows a basic output window using the Swing interface.
 * @author Santiago Zapata
 */
public class SCBExample {

    public static void main(String[] args) {
        ConsoleSystemInterface csi = null;
        try {
            csi = new WSwingConsoleInterface("DixieFlatlineRL", false);
        } catch (ExceptionInInitializerError eiie) {
            System.out.println("Fatal Error Initializing Swing Console Box");
            eiie.printStackTrace();
            System.exit(-1);
        }
        int x = 8;
        int y = 8;
        boolean stop = false;
        while(!stop){
            csi.cls();
            csi.print(x,y, '@', CSIColor.RED);
            csi.print(1, 1, "Hello CSCD349!", ConsoleSystemInterface.CYAN);
            csi.print(2, 3, "This is printed using the Java Console System Interface lib. (libjcsi)");
            csi.print(2, 4, "Swing Console Box Implementation", ConsoleSystemInterface.RED);

            csi.print(5, 6, "########", ConsoleSystemInterface.GRAY);
            csi.print(5, 7, "#......#", ConsoleSystemInterface.GRAY);
            csi.print(5, 8, "#......#", ConsoleSystemInterface.GRAY);
            csi.print(5, 9, "####/###", ConsoleSystemInterface.GRAY);

            csi.print(6, 7, "......", ConsoleSystemInterface.BLUE);
            csi.print(6, 8, "......", ConsoleSystemInterface.BLUE);

            csi.print(9, 9, "/", ConsoleSystemInterface.BROWN);
            csi.print(x,y, '@', CSIColor.GREEN);
            csi.refresh();
            
            CharKey dir = csi.inkey();
            if(dir.isUpArrow() && (y-1 >= 7)){
                y--;
            }
            if(dir.isDownArrow() && (y+1 < 9)){
                y++;
            }
            if(dir.isLeftArrow() && (x-1 >= 6)){
                x--;
            }
            if(dir.isRightArrow() && (x+1 < 12)){
                x++;
            }
            if(dir.code == CharKey.Q){
                stop = true;
            }
        }
        System.exit(0);
    }
}
