package castle;

public class CommandMagicDoor extends Command {

	public CommandMagicDoor(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSomething(String word) {
		game.goRandom();		
	}
}
