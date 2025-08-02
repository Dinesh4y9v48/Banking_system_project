
import java.util.HashMap;
import java.util.Scanner;

class User {
    String username;
    String password;
    double balance;

    User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
    }
}

public class BankEaseApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, User> userList = new HashMap<>();
        User currentUser = null;

        while (true) {
            System.out.println("Welcome to Our Simple Bank");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int Choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (Choice) {
                case 1:
                    System.out.print("Enter a username: ");
                    String newUsername = scanner.nextLine();

                    if (userList.containsKey(newUsername)) {
                        System.out.println("Username already exists.");
                    } else {
                        System.out.print("Enter a password: ");
                        String newPassword = scanner.nextLine();
                        userList.put(newUsername, new User(newUsername, newPassword));
                        System.out.println("Registration successful.");
                    }
                    break;

                case 2:
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    if (userList.containsKey(username)) {
                        User user = userList.get(username);
                        if (user.password.equals(password)) {
                            currentUser = user;
                            System.out.println("Login successful.. Welcome, " + currentUser.username );

                            
                            while (true) {
                                System.out.println("Banking Menu ");
                                System.out.println("1. Check Balance");
                                System.out.println("2. Deposit Money");
                                System.out.println("3. Withdraw Money");
                                System.out.println("4. Logout");
                                System.out.print("Choose an option: ");
                                int bankChoice = scanner.nextInt();

                                switch (bankChoice) {
                                    case 1:
                                        System.out.println("Your balance is: " + currentUser.balance);
                                        break;
                                    case 2:
                                        System.out.print("Enter amount to deposit: ");
                                        double depositAmount = scanner.nextDouble();
                                        if (depositAmount > 0) {
                                            currentUser.balance += depositAmount;
                                            System.out.println("Deposited " + depositAmount + " New balance: " + currentUser.balance);
                                        } 
                                        else {
                                            System.out.println("Invalid amount.");
                                        }
                                        break;
                                    case 3:
                                        System.out.print("Enter amount to withdraw: ");
                                        double withdrawAmount = scanner.nextDouble();
                                        if (withdrawAmount > 0 && withdrawAmount <= currentUser.balance) {
                                            currentUser.balance -= withdrawAmount;
                                            System.out.println("Withdrew " + withdrawAmount + " New balance: " + currentUser.balance);
                                        } 
                                        else {
                                            System.out.println(" insufficient balance.");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Logged out successfully.");
                                        currentUser = null;
                                        scanner.nextLine();
                                        break;
                                    default:
                                        System.out.println("Invalid banking option.");
                                }

                                if (currentUser == null) {
                                    break; 
                                }
                            }

                        } 
                        else {
                            System.out.println("Wrong password.");
                        }
                    } 
                    else {
                        System.out.println("User not found.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using OUr Simple Bank.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}