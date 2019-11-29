/**
 * Driver class that adds items to the player's inventory
 * and displays the related information of the player's
 * inventory.
 * 
 * @author Taner Davis, references previous code from Dr.Fagg
 * @version 20162708
 */
public class Driver {

    /**
     * The main method which does not utilize args.
     * Simply instantiates two Item objects, adds
     * them to the player's inventory, and then
     * prints out information about the inventory.
     * @param args String array taking command-line arguments
     */
    public static void main(String[] args) 
    {

        /*
         * You don't have to change any of this particular code however you may 
         * find it useful to play around with how the code works here.
         */
        Item a = new Item("Longbow", 23.5, 400); //Create a Longbow Item
        Item b = new Item("Mana Potion", 2.0, 15); //Create a Mana Potion item

        //create an inventory and add the items to it. 
        Inventory playerInventory = new Inventory();
        playerInventory.addItem(a); //Add the longbow
        playerInventory.addItem(b); //Add the mana potion

        //Tell the player what they have
        System.out.println(playerInventory);

    }

}
