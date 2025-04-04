import java.util.ArrayList;
import java.util.List;

class Pet{
    String petName;
    String petType;

    public Pet(String petName, String petType){
        this.petName=petName;
        this.petType=petType;
    }

    public void showDetails(){
        System.out.println("Pet Name: " + petName);
        System.out.println("Pet Type: " + petType);
    }

}

class Dog extends Pet{
   String favoriteToy;

    public Dog(String petName, String petType, String favoriteToy){
        super(petName,petType);
        this.favoriteToy=favoriteToy;
    }

//at first i created diff method to show details of pet but instead we can go with @override earlier it was public void dogDetails()
@Override
    public void showDetails(){
        //System.out.println("Pet Name: " + petName);
        //System.out.println("Pet Type: " + petType);

        super.showDetails();
        System.out.println("Favorite Toy: " + favoriteToy);
        System.out.println();
    }
}

class Bird extends Pet{
    int wingSpan;

    public Bird(String petName, String petType, int wingSpan){
        super(petName,petType); 
        this.wingSpan=wingSpan;
    }

//at first i created diff method to show details of bird but instead we can go with @override earlier it was public void birdDetails()
@Override
    public void showDetails(){ 
       // System.out.println("Pet Name: " + petName);
       // System.out.println("Pet Type: " + petType);

        super.showDetails();
        System.out.println("WingSpan: " + wingSpan);
        System.out.println();
    }
}

public class FavPet{
    public static void main(String[] args) {
        Dog d1=new Dog("Tommy", "Dog", "Teddy");
        Bird b1=new Bird("chikki", "Bird", 23);
        List<Pet> pets=new ArrayList<>();
        pets.add(d1);
        pets.add(b1);
        //d1.dogDetails();
        //b1.birdDetails();
        for(Pet p:pets){
            p.showDetails();// Calls overridden methods in Dog and Bird
        }
    }
}