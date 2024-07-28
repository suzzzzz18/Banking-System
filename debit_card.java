/**
 * debit_card is the sub-class of parent class bank_card. It has four attributes and accepts six parameters.
 * Each attribute has a corresponding accessor method. Different methods like getters, mutators and display method are used to successfully
 * complete the program.
 * @22067063 Sujina Dangal
 * @24 January
 */
public class debit_card extends bank_card
{
    //pin_number variable with int data type and private access modifier is created.
    private int pin_number;
    //withdrawal_amount variable with int data type and private access modifier is created.
    private int withdrawal_amount;
    //date_of_withdrawal variable with String data type and private access modifier is created.
    private String date_of_withdrawal;
    //has_withdrawn variable with boolean data type and private access modifier is created.
    private boolean has_withdrawn;
    
    /*
     * A constructor with public access modifier accepting six parameters, namely, card_id with int data type, client_name with String data type,
     * issuer_bank with String data type, bank_account with String data type, balance_amount with double data type and pin_number with int data
     * type is created.
     */
    public debit_card (int card_id, String client_name, String issuer_bank, String bank_account, double balance_amount, int pin_number)
    {
        super(card_id, issuer_bank, bank_account, balance_amount); //superclass constructor is called with it's four parameters.
        super.setclient_name(client_name);                         //superclass setters method is called with it's parameter.
        this.pin_number=pin_number;                                //An instance variable is assigned to it's parameter pin_number.
        this.has_withdrawn=false;                                  //An instance variable is assigned to it's parameter has_withdrawn.
        //The 'this.' keyword is used to refer to the current object in a method or constructor.
    }
    
    // Four getters or accessor methods are created to return the value to instance variable.
    public int getpin_number()
    {
        return this.pin_number;  //It returns the value of pin_number in int data type.
    }
    public int getwithdrawal_amount()
    {
        return this.withdrawal_amount;  //It returns the value of withdrawal_amount in int data type.
    }
    public String getdate_of_withdrawal()
    {
        return this.date_of_withdrawal;  //It returns the value of date_of_withdrawal in String data type.
    }
    public boolean gethas_withdrawn()
    {
        return this.has_withdrawn;  //It returns the value of has_withdrawn in boolean data type.
    }
    
    // A setters or mutator method is created to reset the value of given private variables.
    public void setwithdrawal_amount(int withdrawal_amount)  //A mutator method named withdrawal_amount with return type void is created.
    {
        this.withdrawal_amount = withdrawal_amount;
    }
    
    /*
     * A display method withdraw accepting three parameters with return type void is created. If pin_number is valid and balance_amount is 
     * more than withdrawal_amount, then it prints desired output and the transaction is successful. If pin_number is invalid it displays a 
     * message.
     */ 
    public void withdraw(int withdrawal_amount, String date_of_withdrawal, int pin_number)
    {
        if (pin_number == this.pin_number)  //Value of instance variable pin_number is called.
        {
            if(withdrawal_amount <= getbalance_amount())
            {
            setbalance_amount(getbalance_amount()-withdrawal_amount);
            this.has_withdrawn=true;  //Value of instance variable has_withdrawn is called.
            this.date_of_withdrawal= date_of_withdrawal;  //Value of instance variable date_of_withdrawn is called.
            this.withdrawal_amount= withdrawal_amount;  //Value of instance variable withdrawal_amount is called.
            System.out.println ("Transaction Successful!");
            System.out.println (withdrawal_amount + " has been Withdrawn from your Account");
            System.out.println ("Your New Balance is: " + super.getbalance_amount()); //Superclass display method is called.
            }
            else 
            {
            System.out.println("No Sufficient Balance in your Account");
            System.out.println("Your Balance Amount is: " + super.getbalance_amount());  //Superclass display method is called.    
            }
        }
        else 
        {
            System.out.println("The PIN Number you Entered is Invalid. Please Enter a Valid PIN Number.");
        }
    }
    
    /*
     * A display method is created to print pin_number, withdrawal_amount and date_of_withdrawal if the amount is withdrawn and balance_amount
     * if the amount is not withdrawn.
     */
    public void display()
    {
        super.display();  //Superclass display method is called.
        if(this.has_withdrawn)  //Value is instance variable has_withdrawn is called.
        {
            System.out.println("The PIN Number is: " + pin_number);
            System.out.println("The Withdrawal Amount is: " +withdrawal_amount);
            System.out.println("The Date of Withdrawal is: " +date_of_withdrawal);
        }
        else
        {
            System.out.println("The Balance Amount is: "+super.getbalance_amount());  //Superclass display method is called.
        }
    }
}
