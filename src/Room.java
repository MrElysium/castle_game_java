public class Room {
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;

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
    	System.out.print("choose the direction:");
        if(this.northExit != null)
            System.out.print("north ");
        if(this.eastExit != null)
            System.out.print("east ");
        if(this.southExit != null)
            System.out.print("south ");
        if(this.westExit != null)
            System.out.print("west ");
        System.out.println();
    }
    @Override
    public String toString()
    {
        return description;
    }
}
