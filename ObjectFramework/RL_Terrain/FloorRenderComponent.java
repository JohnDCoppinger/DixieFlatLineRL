package ObjectFramework.RL_Terrain;

import ObjectFramework.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 * Created by bcoll_000 on 3/12/2015.
 */
public class FloorRenderComponent extends RenderComponent
{
    public FloorRenderComponent()
    {
        super('.', ConsoleSystemInterface.BLACK, ConsoleSystemInterface.BROWN);
    }
}
////Floor extends RenderCompenent
//// floor default constructor and call super pass in char, foreground color, background color
////Colors Door: Brown 6
////StoneWall: Gray 7
////CORRIDOR: 6
////
/*private char UNUSED
private char WALL = '-': brown 6
private char VERTWALL = '|' brown 6
private char FLOOR = '.' brown 6
private char STONEWALL = 'O' gray 8
private char CORRIDOR = '=' gray 7
private char DOOR = 'D' brown 6
private char UPSTAIRS = '>' green 2
private char DOWNSTAIRS = '<' green 2
private char TownWALL = '#'; gray 8
background color = 0

*/
//// BLACK = 0,  DARK_BLUE = 1,  GREEN = 2,  TEAL = 3,  DARK_RED = 4,  PURPLE = 5,  BROWN = 6,  LIGHT_GRAY = 7,  GRAY = 8,  BLUE = 9,  LEMON = 10,  CYAN = 11,  RED = 12