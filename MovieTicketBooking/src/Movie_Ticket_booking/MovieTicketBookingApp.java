//package Movie_Ticket_booking;
//
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class MovieTicketBookingApp extends ShowAvailableMovies {
//
//    public static void main(String[] args) throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your choice");
//        System.out.println("1 - Movies Running");
//        System.out.println("2 - Book Ticket");
//        System.out.println("3 - Confirm Booking");
//        System.out.println("4-Cancel the Ticket");
//
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                displayMovies(); 
//                break;
//            case 2:
//                Booking.bookTicket();
//                break;
//            case 3:
//                BookingConfirmation.confirmBooking();
//                break;
//            case 4:
//            	Cancel.cancelTicket();
//            	break;
//            default:
//                System.out.println("Invalid choice");
//                break;
//        }
//        scanner.close();
//    }
//}
















//package Movie_Ticket_booking;
//
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class MovieTicketBookingApp {
//
//    public static void main(String[] args) throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your choice:");
//        System.out.println("1 - Register");
//        System.out.println("2 - Login");
//
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // consume newline
//
//        switch (choice) {
//            case 1:
//                UserRegistration.registerUser();
//                break;
//            case 2:
//                boolean isAdmin = UserLogin.loginUser();
//                if (isAdmin) {
//                    showAdminMenu();
//                } else {
//                    showUserMenu();
//                }
//                break;
//            default:
//                System.out.println("Invalid choice");
//                break;
//        }
//        scanner.close();
//    }
//
//    private static void showAdminMenu() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Admin Menu:");
//        System.out.println("1 - View Movies");
//        System.out.println("2 - Book Ticket");
//        System.out.println("3 - Confirm Booking");
//        System.out.println("4 - Cancel Ticket");
//        System.out.println("5 - cancellation policy");
//        System.out.println("6 - Add New Show");  // New option to add shows
//
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                ShowAvailableMovies.displayMovies();
//                break;
//            case 2:
//                Booking.bookTicket();
//                break;
//            case 3:
//                BookingConfirmation.confirmBooking();
//                break;
//            case 4:
//                Cancel.cancelTicket();
//                break;
//            case 5:
//                Cancel_Booking.CreateCancelBookingProcedure();
//                break;
//            case 6:
//                AddShow.addNewShow();  // Call the method to add new shows
//                break;
//            default:
//                System.out.println("Invalid choice");
//                break;
//        }
//    }
//
//    private static void showUserMenu() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("User Menu:");
//        System.out.println("1 - View Movies");
//        System.out.println("2 - Book Ticket");
//        System.out.println("3 - Confirm Booking");
//        System.out.println("4 - Cancel Ticket");
//
//        int choice = scanner.nextInt();
//        switch (choice) {
//            case 1:
//                ShowAvailableMovies.displayMovies();
//                break;
//            case 2:
//                Booking.bookTicket();
//                break;
//            case 3:
//                BookingConfirmation.confirmBooking();
//                break;
//            case 4:
//                Cancel.cancelTicket();
//                break;
//            default:
//                System.out.println("Invalid choice");
//                break;
//        }
//    }
//}















package Movie_Ticket_booking;

import java.sql.SQLException;
import java.util.Scanner;

public class MovieTicketBookingApp {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    UserRegistration.registerUser();
                    break;
                case 2:
                    boolean isAdmin = UserLogin.loginUser();
                    if (isAdmin) {
                        showAdminMenu();
                    } else {
                        showUserMenu();
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return; // Exit the application
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void showAdminMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1 - View Movies");
            System.out.println("2 - Book Ticket");
            System.out.println("3 - Confirm Booking");
            System.out.println("4 - Cancel Ticket");
            System.out.println("5 - Create Cancel Booking Procedure");
            System.out.println("6 - Add New Show");
            System.out.println("7 - Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ShowAvailableMovies.displayMovies();
                    break;
                case 2:
                    Booking.bookTicket();
                    break;
                case 3:
                    BookingConfirmation.confirmBooking();
                    break;
                case 4:
                    Cancel.cancelTicket();
                    break;
                case 5:
                    Cancel_Booking.CreateCancelBookingProcedure();
                    break;
                case 6:
                    AddShow.addNewShow();
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;         //admin
                
                
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private static void showUserMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1 - View Movies");
            System.out.println("2 - Book Ticket");
            System.out.println("3 - Confirm Booking");
            System.out.println("4 - Cancel Ticket");
            System.out.println("5 - Logout");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ShowAvailableMovies.displayMovies();
                    break;
                case 2:
                    Booking.bookTicket();
                    break;
                case 3:
                    BookingConfirmation.confirmBooking();
                    break;
                case 4:
                    Cancel.cancelTicket();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return; // Exit the user menu
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}

