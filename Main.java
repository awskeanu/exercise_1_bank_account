import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the account owner's name: ");
    String ownerName = scanner.nextLine().trim();
    while (ownerName.isEmpty()) {
      System.out.print("Owner name cannot be blank. Enter the owner's name: ");
      ownerName = scanner.nextLine().trim();
    }

    BankAccount account = new SavingsAccount(ownerName);
    System.out.println("Account created for " + ownerName + ".");

    boolean running = true;
    while (running) {
      printMenu();
      String choice = scanner.nextLine().trim();
      try {
        switch (choice) {
          case "1":
            System.out.println("");
            System.out.print("Enter amount to deposit: ");
            account.deposit(Double.parseDouble(scanner.nextLine().trim()));
            printBalance(account);
            break;
          case "2":
            System.out.println("");
            System.out.print("Enter amount to withdraw: ");
            account.withdraw(Double.parseDouble(scanner.nextLine().trim()));
            printBalance(account);
            break;
          case "3":
            System.out.println("");
            printBalance(account);
            break;
          case "4":
            account.freezeAccount();
            System.out.println("");
            System.out.println("Account frozen.");
            break;
          case "5":
            account.unfreezeAccount();
            System.out.println("");
            System.out.println("Account unfrozen.");
            break;
          case "0":
            running = false;
            System.out.println("");
            System.out.println("Goodbye.");
            break;
          default:
            System.out.println("Invalid choice. Select an option from the menu.");
            break;
        }
      } catch (NumberFormatException exception) {
        System.out.println("Please enter a valid numeric amount.");
      } catch (IllegalArgumentException | IllegalStateException exception) {
        System.out.println(exception.getMessage());
      }
    }
    scanner.close();
  }

  private static void printMenu() {
    System.out.println();
    System.out.println("1. Deposit");
    System.out.println("2. Withdraw");
    System.out.println("3. Check Balance");
    System.out.println("4. Freeze Account");
    System.out.println("5. Unfreeze Account");
    System.out.println("0. Exit");
    System.out.print("Choose an Option: ");
  }

  private static void printBalance(BankAccount account) {
    System.out.printf("Current Balance: %.2f%n", account.getBalance());
  }
}