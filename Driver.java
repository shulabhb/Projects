
import java.util.Scanner;

public class Driver {

    private static Location currLocation;
    private static ContainerItem myInventory;

    public static void createWorld(){

        Location kitchen = new Location("Kitchen", "A clean, white room to eat");
        Location closet = new Location("Closet", "A dark room");
        Location bedroom = new Location("Bedroom", "A messy room");
        Location bathroom = new Location("Bathroom", "A clean yet stinky room");

        //--IN HERE FOR NOW---------------------------------------------------------------------
        myInventory = new ContainerItem("Backpack", "Storage", "O' Reliable");

        //-
        kitchen.connect("east", closet);
        kitchen.connect("south", bedroom);

        closet.connect("west", kitchen);
        closet.connect("south", bathroom);

        bathroom.connect("north", closet);
        bathroom.connect("east", bedroom);

        bedroom.connect("north", kitchen);
        bedroom.connect("west", bathroom);

        //--
        Item knife = new Item("Knife", "Utensil", "A sharp, pointy blade");
        Item broom = new Item("Broom", "Tool", "A tool needed for cleaning");
        Item toothbrush = new Item("Toothbrush", "Tool", "A tool needed for good dental health");
        Item lamp = new Item("Lamp", "Electronic", "A light source");

        kitchen.addItem(knife);
        closet.addItem(broom);
        bathroom.addItem(toothbrush);
        bedroom.addItem(lamp);

        //---
        currLocation = kitchen;

    }

    public static void main(String[] args){
        /*-------I believe we can cut all this out---------------
        currLocation = new Location("Kitchen", "A clean kitchen ");
        Item knife = new Item("Knife", "Utensil", "A sharp, pointy blade");
        Item turkey = new Item("Turkey", "Food", "A savory, golden bird");
        Item plate = new Item("Plate", "Dishware", "An empty dish");

        currLocation.addItem(knife);
        currLocation.addItem(turkey);
        currLocation.addItem(plate);
        */

        createWorld();

        //We have a yellow squiggles here, but do not how to fix this
        Scanner myScanner = new Scanner(System.in);

        while (true){

            System.out.println("Enter a command: ");
            String command = myScanner.nextLine();

            //Splits array
            String[] commandArray = command.split(" ");

            switch(commandArray[0].toLowerCase()){
                case"quit":
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                
                case"look":
                    System.out.println(currLocation.getName() + " - " + currLocation.getDescription() + " has the following items: ");
                    for(int i = 0; i<currLocation.numItems();i++){
                        System.out.println(currLocation.getItem(i).getName());

                    }
                    break;
                
                case"examine":
                    if(commandArray.length > 1){
                        commandArray[1].toLowerCase();
                        String toCompare = commandArray[1];
                        Item tempItem = currLocation.getItem(toCompare);
                        //Checks if currLocation is true or false
                        if (currLocation.hasItem(toCompare)){
                            System.out.println(tempItem.toString());
                        }
                        else{
                            System.out.println("Cannot find that item");
                        }

                    }
                    else{
                        System.out.println("Please enter something for me to examine");
                    }
                    break;

                case"go":
                    if(commandArray.length > 1){
                        commandArray[1].toLowerCase();
                        String toCompare = commandArray[1];
                        Location tempDirection = currLocation.getLocation(toCompare);
                        //Checks whether it can move to that new place
                        //!!! has issues with capitalization
                        if(currLocation.canMove(toCompare)){
                            currLocation = tempDirection;
                            System.out.println("Moving " + toCompare); //Serves as a check for us to see
                        }
                        else{
                            System.out.println("Cannot move in that direction");
                        }                    
                    }
                    else{
                        System.out.println("Please enter somewhere to go");
                    }

                    break;
                
                case"inventory":
                    System.out.println(myInventory.toString());
                    break;

                case"take":
                    if(commandArray.length > 1){
                        commandArray[1].toLowerCase();
                        String toCompare = commandArray[1];
                        Item tempItem = currLocation.getItem(toCompare);
                        if(currLocation.hasItem(toCompare)){
                            myInventory.addItem(tempItem);
                            currLocation.removeItem(toCompare);
                            System.out.println(tempItem.getName() + " has been added to your inventory");
                        }
                        else{
                            System.out.println("That item is not here");
                        }

                    }
                    else{
                        System.out.println("Please enter something for me to take");
                    }
                    break;
                
                case"drop":
                    if(commandArray.length > 1){
                        commandArray[1].toLowerCase();
                        String toCompare = commandArray[1];
                        if(myInventory.hasItem(toCompare)){
                            Item tempItem = myInventory.removeItem(toCompare);
                            currLocation.addItem(tempItem);
            
                            System.out.println(tempItem.getName() + " has been dropped from your inventory.");
                        }
                        else{
                            System.out.println("That item is not in your inventory");
                        }
                    }
                    else {
                        System.out.println("Please enter something for me to drop");
                    } 
                
                    break;
                
                case "help":
                    System.out.println("-----Command List-----");
                    System.out.println("quit: Exits the program.");
                    System.out.println("look: You look around the room.");
                    System.out.println("examine: You look closely at an item");
                    System.out.println("go: You move to a different room.");
                    System.out.println("inventory: You checks your inventory.");
                    System.out.println("take: You take an item from the room and put it in your inventory.");
                    System.out.println("drop: You drop an item from your inventory and leave it in the room.");
                    System.out.println("help: Lists all possible commands");
                    break;

                default:{
                    System.out.println("I do not know how to do that");
                }

                
            }


        }

    }


}



