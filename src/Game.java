
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private class CommandGo extends Command {
        @Override
        public void doSomething(String word) {
            goRoom(word);
        };
    }
    private class CommandBye extends Command{
        @Override
        public boolean isContinue(){
            return false;
        }
    }
    public Game() 
    {
    	commands.put("go",new CommandGo());
    	commands.put("bye",new CommandBye());
    	commands.put("help",new CommandHelp());
    	
        createRooms();

        
    }

    private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
      
        //	make room
        outside = new Room("outside the castle.");
        lobby = new Room("in the lobby");
        pub = new Room("in the pub.");
        study = new Room("in the study.");
        bedroom = new Room("in the bedroom.");
        
        //	loading the exit of the room
        
        outside.setExit("east",lobby);
        outside.setExit("west",study);
        outside.setExit("south", pub);
        lobby.setExit("south", outside);
        pub.setExit("east",outside);
        study.setExit("north",outside);
        study.setExit("east", bedroom);
        bedroom.setExit("south", study);

        currentRoom = outside;  //	the game begin outside the castle
    }
    

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome!");
        System.out.println("It is a boring game.");
        System.out.println("If you need help,please input: help ");
        System.out.println();
        System.out.println(currentRoom);
        currentRoom.printOptions();
    }

    // User command



    protected void goRoom(String direction) 
    {
        Room nextRoom = currentRoom.nextRoom(direction);        

        if (nextRoom == null) {
            System.out.println("wrong direction");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("you are " + currentRoom);
            currentRoom.printOptions();
        }
    }
    public void play() {
    	Scanner in = new Scanner(System.in);
    	boolean ifContinue = true;
    	while (ifContinue) {
    		String line = in.nextLine();
    		String[] words = line.split(" ");
    		String value = "";
    		if (words.length >1) {
    			value = words[1];
    		}
    		Command command = commands.get(words[0]);
    		if (command != null) {
    			command.doSomething(value);
                ifContinue = command.isContinue();
    		}

    	}
    	
    }
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.printWelcome();
		game.play();
        
        
        System.out.println("see you again!");
	}

}
