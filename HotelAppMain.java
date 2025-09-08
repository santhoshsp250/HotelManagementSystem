package hba;
import java.util.*;
public class HotelAppMain{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BookingService service = new BookingService();

    int choice;
    do {
        System.out.println("\n--- Hotel Booking Menu ---");
        System.out.println("1. Add Room");
        System.out.println("2. View Availability");
        System.out.println("3. Create Booking");
        System.out.println("4. Cancel Booking");
        System.out.println("5. Daily Report");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1: 
                System.out.print("Enter Room No: ");
                int roomNo = sc.nextInt();
                System.out.print("Enter Room Type (1-Standard, 2-Deluxe, 3-Suite): ");
                int typeChoice = sc.nextInt();
                System.out.print("Enter Base Price: ");
                double price = sc.nextDouble();

                if (typeChoice == 1) {
                    service.addRoom(new Room(roomNo, "Standard", price));
                } else if (typeChoice == 2) {
                    System.out.print("Has MiniBar? (true/false): ");
                    boolean minibar = sc.nextBoolean();
                    service.addRoom(new DeluxeRoom(roomNo, price, minibar));
                } else if (typeChoice == 3) {
                    System.out.print("Has Living Room? (true/false): ");
                    boolean living = sc.nextBoolean();
                    service.addRoom(new SuiteRoom(roomNo, price, living));
                } else {
                    System.out.println("Invalid room type.");
                }
                System.out.println("Room added successfully!");
                break;

            case 2: 
                service.viewAvailability();
                break;

            case 3: 
                System.out.print("Enter Room No to book: ");
                int bookRoomNo = sc.nextInt();
                System.out.print("Enter number of nights: ");
                int nights = sc.nextInt();
                service.createBooking(bookRoomNo, nights);
                break;

            case 4: 
                System.out.print("Enter Room No to cancel: ");
                int cancelNo = sc.nextInt();
                service.cancelBooking(cancelNo);
                break;

            case 5: 
                service.dailyReport();
                break;

            case 6:
                System.out.println("Exiting... Thank you!");
                break;

            default:
                System.out.println("Invalid choice, try again.");
        }
    } while (choice != 6);
    sc.close();
}
}
