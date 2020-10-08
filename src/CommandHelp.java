package castle;

public class CommandHelp extends Command{

	public CommandHelp(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doSomething(String word) {
		// TODO Auto-generated method stub
        System.out.println("Do you lose? you can try three commands: go bye help");
        System.out.println("such as: go east");
	}

}
