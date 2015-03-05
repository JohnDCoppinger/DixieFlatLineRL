import net.slashie.libjcsi.ConsoleSystemInterface;

public class Player{


	private int x;
	private int y;
	private char draw = '@';
	private int color ConsoleSystemInterface.GREEN;
	

	public Player(int x, int y){
		this.x = x; this.y = y
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public char draw(){
		return this.draw;
	}

	public int color(){
		return this.color;
	}
}