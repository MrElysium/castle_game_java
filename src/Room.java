package castle;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
	private String description;
    private HashMap<String,Room> exit = new HashMap<String,Room>();
	private ArrayList<Room> rooms = new ArrayList<Room>();
    
	
    public Room(String description) 
    {
        this.description = description;
    }
    
    public void setExit(String dir,Room room) {
    	exit.put(dir, room);
    	rooms.add(room);
    }
    
    private Room randomRoom() {
    	
    	int seed =(int) (Math.random()*rooms.size());
    	Room nextRoom = rooms.get(seed);
		return nextRoom;    	
    	
    }
    
    

    public void printOptions(){
    	StringBuilder sb = new StringBuilder();
    	sb.append("choose the direction: ")
    	// randomRoom()
    	.append("random ");
    	for(String dir : exit.keySet()) {
    		sb.append(dir)
    		.append(" ");
    	}
    	System.out.println(sb.toString());
        System.out.println();
    }
    
    public Room nextRoom(String direction) {
    	Room nextRoom = null;
    	if (direction.equals("random")) {
    		nextRoom = randomRoom();
    	}else {
    		nextRoom =exit.get(direction);
    	}
    	
    	        
		return nextRoom;   	
        
    }
    
    @Override
    public String toString()
    {
        return description;
    }
}
