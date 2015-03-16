package ObjectFramework.Entity;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public class RenderComponent {

    private char renderChar;
    private int color;
    private int backgroundColor;
    private String name;

    protected RenderComponent() {}

    public RenderComponent(char renderChar, int color, int backgroundColor) {

        this.renderChar = renderChar;
        this.color = color;
        this.backgroundColor = backgroundColor;
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

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
