//This is the seperate file of interface implementation code for your help

public class AtmOperationImpl implements AtmOperationinterf {
    Atm atm=new Atm();
    public void viewBalance()
    {
        System.out.println("Available Balance is : "+ atm.getBalance());
    }

    public void withdrawAmount(double withdrawAmount)
    {
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
    public void depositAmount(double depositAmount)
    {
        ministat.put(depositAmount, "Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }
    public void viewMiniStatement()
    {
        for (Map.Entry<Double, String> m : ministat.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
