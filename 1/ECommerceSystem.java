import java.util.ArrayList;
import java.util.List;

class Product{
    int id;
    String name;
    double price;

    public Product(int id, String name, double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public String toString(){ //used toString() to display product details in a readable format
        return "Product: [ "+name+" Price: "+price + " ]";
    }
}

class Cart{
        List<Product> cartList=new ArrayList<>(); // created carList to hold the products

        public void addProduct(Product item){
            cartList.add(item); // adds the products to cart List
        }

        public double calculateTotalBill(){
            double total=0;
            for(Product item:cartList){ // this will through all the items in the Cart List
                total+=item.price; // adds the price of each prod to total and return the same
            }
            return total;
        }
        
        public void showCart(){ // want to show all the products that are added in Cart List
            System.out.println("Cart Items: ");
            for(Product p:cartList){
                System.out.println(p);
            }
        }
}

class Customer{
    int id;
    String name;
    Cart cart;

    public Customer(int id, String name){
        this.id=id;
        this.name=name;
        this.cart=new Cart(); // created cart for customer
    }

    public Order placeOrder(){
        System.out.println("Customer Name : " + name);
        cart.showCart();
        Order newOrder = new Order(this); // created new order for current customer
        System.out.println("Order placed Successfully");
        return newOrder;
    }

}

class Order{
    //int id;
    Customer customer; // The customer placing the order
    List<Product> orderedItems; //list of ordered product items by customer
    double totalBill;
    
    public Order(Customer customer){
        //this.id=customer.id;
        this.customer=customer; 
        this.orderedItems=new ArrayList<>(customer.cart.cartList);
        this.totalBill=customer.cart.calculateTotalBill();
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Product p1=new Product(1,"Laptop",50000);
        Product p2=new Product(2,"Mobile",20000);
        Product p3=new Product(3,"TV",30000);

        Customer c1=new Customer(1,"Divya");
        c1.cart.addProduct(p1);
        c1.cart.addProduct(p2);
        //c1.cart.addProduct(p3);
        //System.out.println(c1.cart);

        Order o1=c1.placeOrder();
        System.out.println("Total Bill: "+o1.totalBill);

    }
}
