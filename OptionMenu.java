import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() {
        int x = 1;
        do {
            try {
                data.put(952141, 191904);
                data.put(989947, 717976);

                System.out.println("Welcome to ATM");
                System.out.println("Enter your Customer Number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN Number");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\n Invalid characters only numbers allowed\n"+e);
                x=2;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();

            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else {
                System.out.println("\nWrong customer number or wrong ping number\n\n");
            }
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select Account Type you want to Access");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Savings Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1 -> getChecking();
            case 2 -> getSaving();
            case 3 -> System.out.println("Thank you for using ATM, BYE BYE");
            default -> System.out.println("\n Invalid Choice \n");
        }
    }

    public void getChecking() {
        System.out.println("Checking Account");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Money");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");

        int selection = menuInput.nextInt();

        // Handles user selection
        switch (selection) {
            case 1 -> {
                // Display balance
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType(); // Return to main menu
            }
            case 2 -> {
                getCheckingWithDrawInput();
                getAccountType();
            }
            case 3 -> {
                getCheckingDepositInput();
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using ATM, BYE BYE");
            default -> {
                System.out.println("\nInvalid Choice\n");
                getChecking();
            }
        }
    }

    public void getSaving() {
        System.out.println("Saving Account");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Money");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        // Handles user selection
        switch (selection) {
            case 1 -> {
                // Display balance
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType(); // Return to main menu
            }
            case 2 -> {
                getSavingWithdrawInput(); // Perform withdrawal
                getAccountType();
            }
            case 3 -> {
                getSavingDepositInput(); // Perform deposit
                getAccountType();
            }
            case 4 -> System.out.println("Thank you for using ATM, Bye\n"); // Exit message
            default -> {
                System.out.println("\nInvalid Choice\n");
                getChecking(); // Re-prompt (note: this may be intended to redirect to saving, consider reviewing)
            }
        }
    }
}

