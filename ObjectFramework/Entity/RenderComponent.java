package ObjectFramework.Entity;

import java.util.Vector;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public class RenderComponent {

    private char renderChar;
    private int color;

    public RenderComponent() {}

    public RenderComponent(char renderChar) {

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
