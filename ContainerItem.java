import java.util.ArrayList;

public class ContainerItem extends Item {
    
    //Member Variables
    private ArrayList<Item> items;

    //Constructor
    public ContainerItem(String name, String type, String description) {
        super(name, type, description);
        items = new ArrayList<Item>();
        
    }

    //Methods
    public void addItem(Item itemToAdd){
        items.add(itemToAdd);
    }

    public boolean hasItem(String itemName){
        for (int i=0; i<items.size();i++){
            if((items.get(i).getName()).equalsIgnoreCase(itemName)){
                return true;
            }
        }
        return false;
    }

    public Item removeItem(String itemName){
        for(int i=0; i<items.size(); i++){
            if((items.get(i).getName()).equalsIgnoreCase(itemName)){
                Item removeItem = items.get(i);
                items.remove(i);
                return removeItem;
            }
        }
        return null;
    }

    @Override
    public String toString(){

        StringBuilder temp = new StringBuilder();
        temp.append(super.toString());
        temp.append(" that contains:\n");
        for(Item i:items)
        {
            temp.append("+");
            temp.append(i.getName());
            temp.append("\n");
        }

        return temp.toString();
        

    }

    




}
