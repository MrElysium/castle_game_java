package castle;

public class Command {
	protected Game game;
	public Command(Game game) {
		this.game = game;
	}

	public void doSomething(String word) {
		
	};
	
	public boolean isBye(){		
		return false;		
	}
}
