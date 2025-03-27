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

    public String toString(){
        return "Product: [ "+name+" Price: "+price + " ]";
    }
}

class Cart{
        List<Product> cartList=new ArrayList<>();

        public void addProduct(Product item){
            cartList.add(item);
        }

        public double calculateTotalBill(){
            double total=0;
            for(Product item:cartList){
                total+=item.price;
            }
            return total;
        }
        
        public void showCart(){
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
        this.cart=new Cart();
    }

    public Order placeOrder(){
        System.out.println("Customer Name : " + name);
        cart.showCart();
        Order newOrder = new Order(this);
        System.out.println("Order placed Successfully");
        return newOrder;
    }

}

class Order{
    //int id;
    Customer customer;
    List<Product> orderedItems;
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
