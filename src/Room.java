
public class Room {
	private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
      
    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    public void printOptions(){
    	StringBuilder sb = new StringBuilder();
    	sb.append("choose the direction: ");
        if(this.northExit != null)
        	sb.append("north ");
        if(this.eastExit != null)
        	sb.append("east ");
        if(this.southExit != null)
        	sb.append("south ");
        if(this.westExit != null)
        	sb.append("west ");
        System.out.println(sb.toString());
        System.out.println();
    }
    
    public Room nextRoom(String direction) {
    	Room nextRoom =null;
    	if(direction.equals("north")) {
            nextRoom = this.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = this.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = this.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = this.westExit;
        }
        
		return nextRoom;   	
        
    }
    
    @Override
    public String toString()
    {
        return description;
    }
}
