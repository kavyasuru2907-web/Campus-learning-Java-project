import java.util.*;
public class Communitylibrary
{
    //Display all books
    static void displayBooks(String[] books, int[] years, double[] ratings)
    {
        System.out.println("Books available in the library:");
        for(int i = 0; i < books.length; i++)
        {
            System.out.println((i + 1) + ". " + books[i] + " (Year: " + years[i] + ", Rating: " + ratings[i] + ")");
        }
    }
    //search for books
    static int searchBook(String[] books, String bookName)
    {
        for(int i = 0; i < books.length; i++)
        {
            if(books[i].equalsIgnoreCase(bookName))
            {
                System.out.println("Book found: " + books[i]);
                return i;
            }   
        }
        return -1;

    }   
    //Calculate average rating
    static double AverageRating(double[] ratings) 
    {
        double sum = 0;

        for(int i = 0; i < ratings.length; i++)
        {
            sum += ratings[i];
        }
        return sum / ratings.length;
    }   
    //Display message
    static void showMessage(String message)
    {
        System.out.println(message);
    }
    
    static void showMessage(String message1, String message2)
    {
        System.out.println(message1);
        System.out.println(message2);
    }
    
    //Sort books by year
    static void sortBooksByYear(String[] books, int[] years, double[] ratings)
    {
        for(int i = 0; i < years.length - 1; i++)
        {
            for(int j = 0; j < years.length - i - 1; j++)
            {
                if(years[j] > years[j + 1])
                {
                    // Swap years
                    int tempYear = years[j];
                    years[j] = years[j + 1];
                    years[j + 1] = tempYear;

                    // Swap books
                    String tempBook = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = tempBook;

                    // Swap ratings
                    double tempRating = ratings[j];
                    ratings[j] = ratings[j + 1];
                    ratings[j + 1] = tempRating;
                }
            }
        }
        System.out.println("\nBooks sorted by publication year:");
    }
  
    public static void main(String args[])
    {
        Scanner ss = new Scanner(System.in);
        // 1D - Array
        String[] books ={
            "To Kill a Mockingbird",
            "1984",
            "The Great Gatsby",
            "Pride and Prejudice",
            "The Catcher in the Rye"
        };
        int[] years = 
        {
            1990,2009,2008,2007,1997
        };
        double[] ratings = 
        {
            4.5, 4.8, 5.6, 6.9, 6.7
        };

        //2D-Array
        //Rows = members
        //Columns = books
        // 0 = not borrowed, 1 = borrowed

        int[][] borrowing = new int[3][5];

        //Menu-driven program
        int choice;

        do{
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Calculate average rating");
            System.out.println("4. Sort books by year");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = ss.nextInt();
            
            switch (choice) {

                case 1:
                    displayBooks(books, years, ratings);
                    break;

                case 2:

                    System.out.print("Enter book name to search: ");
                    String key = ss.nextLine();

                    int position = searchBook(books, key);

                    if (position != -1) {
                        System.out.println("Book found!");
                        System.out.println("Position: " + (position + 1));
                    } else {
                        System.out.println("Book not found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter member number (1-3): ");
                    int member = ss.nextInt();

                    System.out.print("Enter book number (1-5): ");
                    int book = ss.nextInt();

                    if (member >= 1 && member <= 3 &&
                        book >= 1 && book <= 5) {

                        if (borrowing[member - 1][book - 1] == 0) {

                            borrowing[member - 1][book - 1] = 1;

                            showMessage("Book borrowed successfully.");

                        } else {

                            System.out.println("This book is already borrowed.");
                        }

                    } else {

                        System.out.println("Invalid member or book number.");
                    }

                    break;

                case 4:

                    System.out.print("Enter member number (1-3): ");
                    member = ss.nextInt();

                    System.out.print("Enter book number (1-5): ");
                    book = ss.nextInt();

                    if (member >= 1 && member <= 3 &&
                        book >= 1 && book <= 5) {

                        if (borrowing[member - 1][book - 1] == 1) {

                            borrowing[member - 1][book - 1] = 0;

                            showMessage("Book returned successfully.", 
                                        "Thank you!");

                        } else {

                            System.out.println("This book was not borrowed.");
                        }

                    } else {

                        System.out.println("Invalid member or book number.");
                    }

                    break;

                case 5:

                    sortBooksByYear(books, years, ratings);
                    displayBooks(books, years, ratings);

                    break;

                case 6:

                    double average = AverageRating(ratings);

                    System.out.printf(
                        "Average Book Rating: %.2f%n", average
                    );

                    break;

                case 7:

                    System.out.println("\n--- Borrowing Records ---");

                    for (int i = 0; i < borrowing.length; i++) {

                        System.out.print("Member " + (i + 1) + ": ");

                        for (int j = 0; j < borrowing[i].length; j++) {

                            System.out.print(borrowing[i][j] + " ");
                        }

                        System.out.println();
                    }

                    break;

                case 8:

                    System.out.println("Thank you for using the library system!");
                    break;

                default:

                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 8);

        ss.close();
    }
}
   

