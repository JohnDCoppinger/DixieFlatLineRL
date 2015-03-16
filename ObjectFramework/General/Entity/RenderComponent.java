package ObjectFramework.General.Entity;

import net.slashie.libjcsi.CSIColor;

/**
 * Created by Gallanoth on 3/3/2015.
 */
public class RenderComponent {

    private char renderChar;
    private CSIColor color;
    private CSIColor backgroundColor;
    private String name;

    protected RenderComponent() {}

    public RenderComponent(char renderChar, CSIColor color, CSIColor backgroundColor) {

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

    public CSIColor getColor() {

        return this.color;
    }

    public CSIColor getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(CSIColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setColor(CSIColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
