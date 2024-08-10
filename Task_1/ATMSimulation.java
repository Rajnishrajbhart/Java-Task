import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

    public ATMSimulation(int initialPin) {
        this.balance = 0.0;
        this.pin = initialPin;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Checked balance: $" + balance);
    }

    // Method to withdraw cash
    public void withdrawCash(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("You have successfully withdrawn $" + amount);
            transactionHistory.add("Withdrew: $" + amount);
        }
    }

    // Method to deposit cash
    public void depositCash(double amount) {
        balance += amount;
        System.out.println("You have successfully deposited $" + amount);
        transactionHistory.add("Deposited: $" + amount);
    }

    // Method to change PIN
    public void changePIN(int newPin) {
        pin = newPin;
        System.out.println("Your PIN has been successfully changed.");
        transactionHistory.add("PIN changed.");
    }

    // Method to view transaction history
    public void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMSimulation atm = new ATMSimulation(1234);  // Initial PIN set to 1234

        while (true) {
            System.out.println("\nATM Machine");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdrawCash(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.depositCash(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    atm.changePIN(newPin);
                    break;
                case 5:
                    atm.viewTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}