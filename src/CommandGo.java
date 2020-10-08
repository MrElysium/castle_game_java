package castle;

public class CommandGo extends Command {

	public CommandGo(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSomething(String word) {
		game.goRoom(word);
	}
	

}
