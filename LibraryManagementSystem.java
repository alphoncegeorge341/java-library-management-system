import java.util.Scanner;

public class LibraryManagementSystem {

    static String[] books = new String[100];
    static boolean[] borrowed = new boolean[100];
    static int bookCount = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    if (bookCount < books.length) {
                        System.out.print("Enter book title: ");
                        books[bookCount] = input.nextLine();
                        borrowed[bookCount] = false;
                        bookCount++;

                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("Library is full.");
                    }
                    break;

                case 2:
                    System.out.print("Enter book number to borrow: ");
                    int borrowNumber = input.nextInt();

                    if (borrowNumber > 0 && borrowNumber <= bookCount) {
                        if (!borrowed[borrowNumber - 1]) {
                            borrowed[borrowNumber - 1] = true;
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Book is already borrowed.");
                        }
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;

                case 3:
                    System.out.print("Enter book number to return: ");
                    int returnNumber = input.nextInt();

                    if (returnNumber > 0 && returnNumber <= bookCount) {
                        if (borrowed[returnNumber - 1]) {
                            borrowed[returnNumber - 1] = false;
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Book is already available.");
                        }
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;

                case 4:
                    System.out.println("\n===== AVAILABLE BOOKS =====");

                    boolean found = false;

                    for (int i = 0; i < bookCount; i++) {
                        if (!borrowed[i]) {
                            System.out.println((i + 1) + ". " + books[i]);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No books are currently available.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        input.close();
    }
}
