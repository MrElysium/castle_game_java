package castle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private Room currentRoom;
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private ArrayList<Room> rooms = new ArrayList<Room>();
        
    public Game() 
    {
    	commands.put("go",new CommandGo(this));
    	commands.put("bye",new CommandBye(this));
    	commands.put("help",new CommandHelp(this));
    	commands.put("magicDoor",new CommandMagicDoor(this));
    	
        createRooms();

        
    }





	private void createRooms()
    {
        Room outside, lobby, pub, study, bedroom;
              
        //	make room
        outside = new Room("outside the castle.");
        rooms.add(outside);
        lobby = new Room("in the lobby");
        rooms.add(lobby);
        pub = new Room("in the pub.");
        rooms.add(pub);
        study = new Room("in the study.");
        rooms.add(study);
        bedroom = new Room("in the bedroom.");
        rooms.add(bedroom);
        
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

    protected void printHelp(){
    	StringBuilder sb = new StringBuilder();
    	Set<String> key = commands.keySet();
    	sb.append("Do you lose? you can try three commands: ");
    	for(String s: key) {
    		sb.append(s)
    		.append(" ");
    	}
    	System.out.println(sb);		
        System.out.println("such as: go east");
    }
    
    protected void goRandom() {
    	int seed =(int) (Math.random()*rooms.size());
    	currentRoom = rooms.get(seed);
    	System.out.println("you are " + currentRoom);
    	currentRoom.printOptions();
    }

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
    	while ( true ) {
    		String line = in.nextLine();
    		String[] words = line.split(" ");
    		String value = "";
    		if (words.length >1) {
    			value = words[1];
    		}
    		Command command = commands.get(words[0]);
    		if (command != null) {
    			command.doSomething(value);
    			if ( command.isBye() ) {
    				break;
    			}
    		}


    	}
		in.close();
    }
	
	public static void main(String[] args) {
		
		Game game = new Game();
		game.printWelcome();
		game.play();
        
        
        System.out.println("see you again!");
	}

}
