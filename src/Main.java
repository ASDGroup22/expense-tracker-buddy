
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<String> categories = new ArrayList(Arrays.asList(
            "Groceries", "Housing", "Utilities", "Transportation", "Entertainment",
            "Miscellaneous"));

    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        expenseTrackerCLI();
    }

    private static void expenseTrackerCLI() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main menu:");
            System.out.println("1. View recent transactions");
            System.out.println("2. Add a new transaction");
            System.out.println("3. Edit a transaction");
            System.out.println("4. Delete a transaction");
            System.out.println("5. View categories");
            System.out.println("6. Add a new category");
            System.out.println("7. Set budget");
            System.out.println("8. View budget progress");
            System.out.println("9. Quit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // View recent transactions
                    // Print the table header
                    System.out.println("+------------+------------+------------+--------------------+-------------------------------+");
                    System.out.println("| Date       | Amount     | Type       | Category           | Is Recurring | Note           |");
                    System.out.println("+------------+------------+------------+--------------------+-------------------------------+");
                    for (int i = 0; i < transactions.size(); i++) {
                        Transaction transaction = transactions.get(i);
                        System.out.println(transaction.toString());
                    }
                    // Print the table footer
                    System.out.println("+------------+------------+------------+--------------------+--------------------+");
                    break;
                case 2:
                    // Add a new transaction
                    addTransaction(scanner);
                    break;
                case 3:
                    // Edit a transaction
                    editTransaction(scanner);
                    break;
                case 4:
                    // Delete a transaction
                    break;
                case 5:
                    // View categories

                    for (String category : categories) {
                        System.out.println(" - " + category);
                    }
                    break;

                case 6:
                    // Add a new category
                    System.out.println("Enter the name of the new category:");
                    String newCategory = scanner.nextLine();
                    categories.add(newCategory);
                    break;

                case 7:
                    // Set budget
                    break;
                case 8:
                    // View budget progress
                    break;
                case 9:
                    // Quit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void editTransaction(Scanner scanner) {
        System.out.print("Enter the transaction date (dd/MM/yyyy): ");
        String dateString = scanner.next();

        // Parse the string into a Date object using a SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Unable to parse the provided date. Please try again.");
            addTransaction(scanner);
        }

        System.out.println("Enter the amount of the transaction:");
        double amount = scanner.nextDouble();

        System.out.println("Is this an income or an expense? (I/E)");
        char type = scanner.next().charAt(0);
        boolean isIncome = (type == 'I');

        System.out.println("Enter the category of the transaction:");
        String category = scanner.next();

        System.out.println("Enter a note for the transaction (optional):");
        String note = scanner.nextLine();

        System.out.println("Is this a recurring transaction? (Y/N)");
        char recurring = scanner.next().charAt(0);
        boolean isRecurring = (recurring == 'Y');

        transactions.add(new Transaction(amount, isIncome, category, note, date, isRecurring));
    }

    private static void addTransaction(Scanner scanner) {
        System.out.print("Enter the transaction date (dd/MM/yyyy): ");
        String dateString = scanner.next();

        // Parse the string into a Date object using a SimpleDateFormat
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Unable to parse the provided date. Please try again.");
            addTransaction(scanner);
        }

        System.out.println("Enter the amount of the transaction:");
        double amount = scanner.nextDouble();

        System.out.println("Is this an income or an expense? (I/E)");
        char type = scanner.next().charAt(0);
        boolean isIncome = (type == 'I');

        System.out.println("Enter the category of the transaction:");
        String category = scanner.next();

        System.out.println("Enter a note for the transaction (optional):");
        String note = scanner.nextLine();

        System.out.println("Is this a recurring transaction? (Y/N)");
        char recurring = scanner.next().charAt(0);
        boolean isRecurring = (recurring == 'Y');

        transactions.add(new Transaction(amount, isIncome, category, note, date, isRecurring));
    }
}
