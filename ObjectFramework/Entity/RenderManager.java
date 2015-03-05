package ObjectFramework.Entity;

import java.util.Vector;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public class RenderManager {

    private char renderChar;
    private int color;

    public RenderManager() {}

    public RenderManager(char renderChar) {

        this.renderChar = renderChar;
    }

    public char getRenderChar() {

        return renderChar;
    }

    public void setRenderChar(char renderChar) {

        this.renderChar = renderChar;
    }

    public int getColor() {

        return this.color;
    }
}
