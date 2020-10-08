package castle;

public class CommandHelp extends Command{

	public CommandHelp(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSomething(String word) {
		// TODO Auto-generated method stub
        game.printHelp();
	}

}
