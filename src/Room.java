
import java.util.HashMap;

public class Room {
	private String description;
    private HashMap<String,Room> exit = new HashMap<String,Room>();
	  
    public Room(String description) 
    {
        this.description = description;
    }
    
    public void setExit(String dir,Room room) {
    	exit.put(dir, room);    	
    }
    
    

    public void printOptions(){
    	StringBuilder sb = new StringBuilder();
    	sb.append("choose the direction: ");
    	for(String dir : exit.keySet()) {
    		sb.append(dir)
    		.append(" ");
    	}
    	System.out.println(sb.toString());
        System.out.println();
    }
    
    public Room nextRoom(String direction) {
    	Room nextRoom =exit.get(direction);;
    	        
		return nextRoom;   	
        
    }
    
    @Override
    public String toString()
    {
        return description;
    }
}
