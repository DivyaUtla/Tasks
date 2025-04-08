import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TicketBooking {
    int availableTickets;
    List<Integer> bookings;

    public TicketBooking(int availableTickets){   // Constructor to initialize ticket count
        this.availableTickets=availableTickets;
        this.bookings=new ArrayList<>();
    }

    public synchronized void bookTicket(int tickets){
        if(availableTickets>=tickets){
            availableTickets-=tickets;
            bookings.add(tickets); // added the booking
            System.out.println(tickets + " ticket(s) booked. Remaining: " + availableTickets);
        }else{
            System.out.println("Not enough tickets available");
        }
    }

    public synchronized void cancelTicket(int tickets){    // Cancel ticket - only if the booking exists
        if(bookings.contains(tickets)){
            bookings.remove(Integer.valueOf(tickets));// removing the exact object, not by index
            availableTickets+=tickets; //added the canceled tickets to available
            System.out.println(tickets + " ticket(s) canceled. Remaining: " + availableTickets);
        }else{
            System.out.println("No such booking found to cancel");
        }
    }

    public synchronized int checkRemainingTickets(){     // to View remaining tickets
        return availableTickets;
    }

    public synchronized void viewAllBookings(){     // To View all the bookings
        if(bookings.isEmpty()){
            System.out.println("No bookings made yet");
        }else{
            System.out.println("All bookings made: " +bookings);
        }
    }
}

class BookingThread extends Thread{ // Thread class for booking tickets
    TicketBooking ticketBooking;
    int tickets;

    BookingThread(TicketBooking ticketBooking,int tickets){//BookingThread receives TicketBooking instance and number of tickets to book
        this.ticketBooking=ticketBooking;
        this.tickets=tickets;
    }
@Override
    public void run(){// This method will be called when the thread is started using .start()
        ticketBooking.bookTicket(tickets);// Calls the booking method with the number of tickets requested
    }
}

public class TicketManager{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter no of available tickets : ");
        int availableTickets=sc.nextInt();
        TicketBooking ticketBooking = new TicketBooking(availableTickets);

        // Creating 3 threads for booking different number of tickets
        BookingThread thread1=new BookingThread(ticketBooking, 5);
        BookingThread thread2=new BookingThread(ticketBooking, 6);
        BookingThread thread3=new BookingThread(ticketBooking, 4);

        thread1.start();// Start first thread
        try {
            thread1.join();// wait until thread1 finishes before starting thread2
        } catch (Exception e) {
            e.printStackTrace();
        }

        thread2.start();// Start second thread
        
        try {
            thread2.join();// wait until thread1 finishes before starting thread3
        } catch (Exception e) {
            e.printStackTrace();
        }

        thread3.start(); // Start third thread

        try {
            thread3.join();// wait until thread3 finishes before continuing
        } catch (Exception e) {
            e.printStackTrace();
        }

  
//tried this but thread3 is executing before 2 so individually joined make sure flow will be 1,2,3
      
        //try {
        //    thread1.join();
        //    thread2.join();
        //    thread3.join();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        System.out.println("\nRemaining tickets: " + ticketBooking.checkRemainingTickets());
        ticketBooking.viewAllBookings();

        System.out.println("\nAttempting to Cancel booking of tickets.");
        ticketBooking.cancelTicket(4);
        ticketBooking.cancelTicket(3);

        ticketBooking.viewAllBookings();
    }
}