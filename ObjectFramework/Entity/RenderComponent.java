package ObjectFramework.Entity;

import java.util.Vector;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public class RenderComponent {

    private char renderChar;
    private int color;
    private int background;

    protected RenderComponent() {}

    public RenderComponent(char renderChar, int color, int background) {

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

    public void setColor(int color) {

        this.color = color;
    }

    public int getBackground() {

        return this.background;
    }
}
