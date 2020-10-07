
import java.util.Scanner;

public class Game {
    private Room currentRoom;
        
    public Game() 
    {
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
        outside.setExits(null, lobby, study, pub);
        lobby.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        study.setExits(outside, bedroom, null, null);
        bedroom.setExits(null, null, null, study);

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

    private void printHelp() 
    {
        System.out.println("Do you lose? you can try three commands: go bye help");
        System.out.println("such as: go east");
    }

    private void goRoom(String direction) 
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
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Game game = new Game();
		game.printWelcome();

        while ( true ) {
        		String line = in.nextLine();
        		String[] words = line.split(" ");
        		if ( words[0].equals("help") ) {
        			game.printHelp();
        		} else if (words[0].equals("go") ) {
        			game.goRoom(words[1]);
        		} else if ( words[0].equals("bye") ) {
        			break;
        		}
        }
        
        System.out.println("see you again!");
        in.close();
	}

}
