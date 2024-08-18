import java.util.Scanner;

class CashMachine {
    private MoneyAccount account;
    
    public CashMachine(MoneyAccount acc) {
        account = acc;
    }
    
    public void takeOut(double cash) {
        if (account.getMoney() >= cash) {
            account.reduceMoney(cash);
            System.out.println("Money taken out successfully.");
        } else {
            System.out.println("Not enough money in account.");
        }
    }
    
    public void putIn(double cash) {
        account.addMoney(cash);
        System.out.println("Money added successfully.");
    }
    
    public void showMoney() {
        System.out.println("You have $" + account.getMoney() + " in your account.");
    }
}

class MoneyAccount {
    private double money;
    
    public MoneyAccount(double startingMoney) {
        money = startingMoney;
    }
    
    public double getMoney() {
        return money;
    }
    
    public void reduceMoney(double amount) {
        money -= amount;
    }
    
    public void addMoney(double amount) {
        money += amount;
    }
}

public class BankInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MoneyAccount myAccount = new MoneyAccount(500); // Starting money
        CashMachine machine = new CashMachine(myAccount);
        
        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Withdraw  money");
            System.out.println("2. Deposit money");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Exit");
            System.out.print("Type a number: ");
            
            int pick = input.nextInt();
            
            if (pick == 1) {
                System.out.print("How much do you want to withdraw? $");
                double amount = input.nextDouble();
                machine.takeOut(amount);
            } else if (pick == 2) {
                System.out.print("How much do you want to deposit? $");
                double amount = input.nextDouble();
                machine.putIn(amount);
            } else if (pick == 3) {
                machine.showMoney();
            } else if (pick == 4) {
                System.out.println("Thanks for using our bank. Goodbye!");
                break;
            } else {
                System.out.println("That's not a valid choice. Try again.");
            }
        }
        
        input.close();
    }
}
