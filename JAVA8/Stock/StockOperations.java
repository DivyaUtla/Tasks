
import java.util.HashMap;

public class StockOperations {

    HashMap<String,Integer> map=new HashMap<>();

    public void AddOrUpdate(String items, int quantity){   // Method to add or update the stock of an item
        if(map.containsKey(items)){ // Checking if the item already exists in the map
            map.put(items, map.get(items)+quantity); // If the item exists, update the quantity by adding the new quantity to the existing one
        }else{
            map.put(items, quantity);  // If the item doesn't exist, add it to the map with the given quantity
        }
    }

    public void Delete(String item,int quantity){
        if(!map.containsKey(item)){ //// Check if the item exists in the inventory
            System.out.println(item + "No item found");
        }

        int currentItem=map.get(item); // Get the current stock

        if(quantity>currentItem){ // If trying to delete more than available stock
            System.out.println("Not enough quantity");
        }else if(quantity==currentItem){ // If the quantity to delete equals current stock, remove the item
            map.remove(item);// Removes item completely if stock becomes 0
            System.out.println(item + " stock is now 0 and has been removed from stock.");
        }else{
            map.put(item,currentItem-quantity);  // If there is enough stock, reduce the stock value
            System.out.println("Reduced " + quantity + " from " + item + ". New stock: " + (currentItem - quantity));
        }
    }

    //public int getStock(String item) {
    //    // it will return 0 if the item is not found in the inventory
    //    return map.getOrDefault(item, 0);
    //}

    public void fetchDetails(){
        for(String item:map.keySet()){ // it will Loop through each item in the map
            System.out.println(item + ": " + map.get(item) + " in stock"); // Print the item and its quantity in stock
        }
    }

    public static void main(String[] args) {
        StockOperations map=new StockOperations();
        map.AddOrUpdate("Mango", 25);
        map.AddOrUpdate("BlueBerry", 10);
        map.AddOrUpdate("Grapes", 50);

        map.AddOrUpdate("Mango", 30);
    
        map.Delete("BlueBerry", 5);    

        map.fetchDetails();
    }
}
