import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;
/**
 * Created by Gallanoth on 1/14/2015.
 */
public class BadGuy implements Observer {

    private Observable eye;
    private String name;
    private ArrayList<GoodGuy> eyeReport;

    public BadGuy(Observable eye, String name) {

        this.eye = eye;
        this.name = name;

        eye.addObserver(this);
    }

    public void update(Observable subject, Object args ) {

        eyeReport = new ArrayList<GoodGuy>((ArrayList<GoodGuy>) args);
        report();
    }

    public void defeated() {

        eye.deleteObserver(this);
    }

    public void report() {

        System.out.print(this.name + " now knows about ");

        for (GoodGuy enemy : eyeReport) {

            if (enemy == eyeReport.get(eyeReport.size() - 1))
                System.out.println("and " + enemy.report() + ".");

            else
                System.out.print(enemy.report() + ", ");
        }
    }
}