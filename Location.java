import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    
    //Member Variables
    private String name;
    private String description;
    private ArrayList<Item> myList = new ArrayList<Item>();
    private HashMap<String, Location> connections;

    //Constructor
    public Location(String name, String description){
        this.name = name;
        this.description = description;
        connections = new HashMap<String, Location>();
    }
    
    //Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Methods
    public void addItem(Item initItem){
        myList.add(initItem);
    }

    public boolean hasItem(String initItem){
        for (int i=0; i<myList.size();i++){
            if((myList.get(i).getName()).equalsIgnoreCase(initItem)){
                return true;
            }
        }
        return false;
    }
    
    public Item getItem(String initName){
        for (int i=0; i<myList.size();i++){
            if((myList.get(i).getName()).equalsIgnoreCase(initName)){
                return myList.get(i);
            }
        }
        return null;
    }

    public Item getItem(int index){
        if(index<=myList.size()){
            return myList.get(index);
        }
        else{
           return null; 
        }
    }

    public int numItems(){
        return myList.size();
    }

    public Item removeItem(String initString){
        for(int i=0; i<myList.size();i++){
            if(myList.get(i).getName().equalsIgnoreCase(initString)){
                Item removeItem = myList.get(i);        //check this
                myList.remove(i);
                return removeItem;
            }  
        }
        return null;
    }

    //Checkpoint 2 Methods
    public void connect(String directionName, Location room){
    
        connections.put(directionName, room);
    }

    public boolean canMove(String directionName){
        return connections.containsKey(directionName);
        
    }

    public Location getLocation(String directionName){
        return connections.get(directionName);
    }

    

}