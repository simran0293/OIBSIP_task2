import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

interface AtmOperationinterf {
    public void viewBalance();

    public void withdrawAmount(double wthdrawAmount);

    public void depositAmount(double depositAmount);

    public void viewMiniStatement();
}

class AtmOperationImpl implements AtmOperationinterf {
    Map<Double, String> ministat = new HashMap<>();
    Atm atm = new Atm();

    public void viewBalance() {
        System.out.println("Available Balance is : " + atm.getBalance());
    }

    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministat.put(withdrawAmount, "Amount withdraw");
                System.out.println("Collect the cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance!!");
            }
        } else {
            System.out.println("Please enter the amount in multiple of 500");
        }
    }

    public void depositAmount(double depositAmount) {
        ministat.put(depositAmount, "Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }

    public void viewMiniStatement() {
        for (Map.Entry<Double, String> m : ministat.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

    }
}

class Atm {
    double balance;
    double depositAmount;
    double withdrawAmount;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

}

class AtmMachine {
    public static void main(String[] args) {
        AtmOperationinterf op = new AtmOperationImpl();

        int atmnum = 12345;
        int atmPin = 123;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine !!!");
        System.out.print("Enter ATM number : ");
        int atmNumber = sc.nextInt();
        System.out.print("Enter Pin: ");
        int pin = sc.nextInt();
        if (atmNumber == atmnum && atmPin == pin) {
            while (true) {
                System.out.println(
                        "1. View Available Balance\n2.Withdraw Amount\n3.Deposit Money\n4.View Mini Statement\n5.Exit");
                System.out.println("Enter the choice : ");
                int ch = sc.nextInt();
                if (ch == 1) {
                    op.viewBalance();

                } else if (ch == 2) {
                    System.out.println("Enter amount to withdraw : ");
                    double withdrawAmount = sc.nextDouble();
                    op.withdrawAmount(withdrawAmount);

                } else if (ch == 3) {
                    System.out.println("Enter Amount to deposit : ");
                    double depositAmount = sc.nextDouble();
                    op.depositAmount(depositAmount);
                } else if (ch == 4) {
                    op.viewMiniStatement();
                } else if (ch == 5) {
                    System.out.println("Collect your ATM card\nThankyou for using ATM Machine");
                    System.exit(0);
                } else {
                    System.out.println("Enter the correct option");
                }
            }
        } else {
            System.out.println("Incorrect Atm no. or pin");
        }
        sc.close();
    }

}
