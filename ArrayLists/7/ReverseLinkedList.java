// ASK : Reverse the elements of a LinkedList without using built-in reverse methods.

class SingleNode{  // I have created a single node in linked list.
    //As we know that each node will have data and pointer which reference to next node
    int data;
    SingleNode next;

    SingleNode(int data){ //created constructor to initialize a node with value
        this.data=data; //here i have assigned the value
        this.next=null; // here i have kept null since no next node initially (single node)
    }
}

class LinkedList{
    public static SingleNode reverseList(SingleNode head){
        SingleNode prev=null;
        SingleNode current=head; 
        SingleNode next=null;

        while(current!=null){ //it will loop through all nodes until there is no next node i.e., null
            next=current.next; // asigning to next node. example: list: 1->2->3 current=1 so next=2
            current.next=prev; // here i/m reversing the link by pointing current node to previous node. Now 1.next point to prev 1->null
            prev=current; //moving previous to current. prev=1
            current=next; //moving current pointer to the next node in the original list. current=2;
        }
    return prev;
    }
}

public class ReverseLinkedList {

    public static void printList(SingleNode head){ // Method to print the entire linked list
        SingleNode current=head;
        while(current!=null){ //it will loop through all nodes until there is no next node i.e., null
            System.out.print(current.data+"->"); // Print the data of the current node followed by an arrow
            current=current.next; // Move to the next node in the list
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SingleNode head=new SingleNode(1);
        head.next=new SingleNode(2);
        head.next.next=new SingleNode(3);
        head.next.next.next=new SingleNode(4);
        head.next.next.next.next=new SingleNode(5);

        System.out.println("Original Linked List : ");
        printList(head);                                                                                                                                         

        head=LinkedList.reverseList(head);

        System.out.println("Reversed Linked List : ");
        printList(head);
    }
}



//Reverse the elements of a LinkedList using built-in reverse methods.
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
//class LinkedListist{
//    public static List<Integer> Listreverse(List<Integer> list){
//        List<Integer> reverseList=new ArrayList<>(list);
//        Collections.sort(reverseList, Collections.reverseOrder());//Collections.reverseOrder() used to sort in reverse order
//    return reverseList;
//    }
//}
//
//public class ReverseLinkedList {
//    public static void main(String[] args) {
//        List<Integer> list=List.of(1,2,3,4,5);
//        List<Integer> reverseList=LinkedListist.Listreverse(list);
//        System.out.println(reverseList);
//    }
//}