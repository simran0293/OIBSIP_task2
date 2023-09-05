
public class AtmOperationImpl implements AtmOperationinterf {
    Atm atm=new Atm();
    public void viewBalance()
    {
        System.out.println("Available Balance is : "+ atm.getBalance());
    }

    public void withdrawAmount(double withdrawAmount)
    {

    }
    public void depositAmount(double depositAmount)
    {
        System.out.println(depositAmount+" Deposited Successfully");
        atm.setBalance(atm.getBalance()+ depositAmount);
        viewBalance();
    }
    public void viewMiniStatement()
    {

    }
}
