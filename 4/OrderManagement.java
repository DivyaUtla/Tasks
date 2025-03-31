import java.util.ArrayList;
import java.util.List;

class CustomerOrder{
    int orderID;
    String CustName;
    String CustAddress;
    String orderDate;
    List<String> foodItems;

    public CustomerOrder(int orderID, String CustName, String CustAddress, String orderDate, List<String> foodItems){
        this.orderID = orderID;
        this.CustName = CustName;
        this.CustAddress = CustAddress;
        this.orderDate = orderDate;
        this.foodItems = new ArrayList<>(foodItems);
    }

    public void addFoodItem(String foodItem){ 
        foodItems.add(foodItem);
    }
}

class OnlineOrder extends CustomerOrder{ //ask is to create subclass so i followed inheritence
    String deliveryAddress;
    String trackingNumber;
    String orderType;
    String orderStatus;

    public OnlineOrder(int orderID, String CustName, String CustAddress, String orderDate, List<String> foodItems, String deliveryAddress,  String trackingNumber, String orderType, String orderStatus){
        //since i want all the cust details have used super which will help reffering the parent class i.e., customerorder
        super(orderID, CustName, CustAddress, orderDate, foodItems);
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
    }

    public void orderDetails(){
        System.out.println("Order details of " + orderType + " Order for " + CustName);
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer Name: " + CustName);
        System.out.println("Customer Address: " + CustAddress);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Food Items: " + foodItems);
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Order Type: " + orderType);
        System.out.println("Order Status: " + orderStatus);
        System.out.println();
    }
}

public class OrderManagement{
    public static void main(String[] args) {
        List<String> foodItems1 = new ArrayList<>();
        List<String> foodItems2 = new ArrayList<>();
        foodItems1.add("Pizza");
        foodItems2.add("Biryani");
        foodItems1.add("Tiramisu");
        foodItems2.add("Mango Lassi");

        OnlineOrder order1=new OnlineOrder(23, "Divya", "Seattle", "2025-03-31",foodItems1,"1234 Elm St", "TRK123456", "ONLINE", "Shipped");
        OnlineOrder order2=new OnlineOrder(24, "Chandu", "Jersy", "2025-03-31", foodItems2,"Hawathorne Ave","TRK879", "TAKEAWAY", "Pending");
        order1.orderDetails();
        order2.orderDetails();
    }
}