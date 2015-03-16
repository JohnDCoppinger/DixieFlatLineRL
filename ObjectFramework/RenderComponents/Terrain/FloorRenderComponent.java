package ObjectFramework.RenderComponents.Terrain;

import ObjectFramework.General.Entity.RenderComponent;
import net.slashie.libjcsi.ConsoleSystemInterface;

public class FloorRenderComponent extends RenderComponent
{
    public FloorRenderComponent()
    {
        super(',', ConsoleSystemInterface.BLACK, ConsoleSystemInterface.GRAY);
    }
}

//// BLACK = 0,  DARK_BLUE = 1,  GREEN = 2,  TEAL = 3,  DARK_RED = 4,  PURPLE = 5,  BROWN = 6,  LIGHT_GRAY = 7,  GRAY = 8,  BLUE = 9,  LEMON = 10,  CYAN = 11,  RED = 12