/**
 * bank_card is the parent class to sub-class debit_card and credit_card. It has five attributes and accepts four parameters.
 * Each attribute has a corresponding accessor method. Different methods like getters, mutators and display method are used to successfully
 * complete the program.
 * @22067063 Sujina Dangal
 * @24 January
 */
public class bank_card
{
    //card_id variable with int data type and private access modifier is created.
    private int card_id;
    //client_name variable with String data type and private access modifier is created.
    private String client_name;
    //issuer_bank variable with String data type and private access modifier is created.
    private String issuer_bank;
    //bank_account variable with String data type and private access modifier is created.
    private String bank_account;
    //balance_amount variable with double data type and private access modifier is created.
    private double balance_amount;
    /*
     * A constructor with public access modifier accepting four parameters, namely, card_id with int data type, issuer_bank with String data type,
     * bank_account with String data type and balance_amount with double data type is created.
     */
    public bank_card(int card_id, String issuer_bank, String bank_account, double balance_amount)
    {
        this.card_id = card_id;
        //An instance variable is assigned to it's parameter card_id.
        this.client_name = "";
        //An instance variable is assigned to it's parameter client_name.
        this.issuer_bank = issuer_bank;
        //An instance variable is assigned to it's parameter issuer_bank.
        this.bank_account = bank_account;
        //An instance variable is assigned to it's parameter bank_account.
        this.balance_amount = balance_amount;
        //An instance variable is assigned to it's parameter balance_amount.
        /*
         * The 'this.' keyword is used to refer to the current object in a method or constructor.
         */
    }
    
    /*
     * Five getters or accessor methods are created 
     * to return the value to instance variable.
     */
    public int getcard_id() 
    {
        return this.card_id;  //It returns the value of card_id in int data type.
    }
    public String getclient_name()
    {
        return this.client_name;  //It returns the value of client_name in String data type.
    }
    public String getissuer_bank()
    {
        return this.issuer_bank;  //It returns the value of issuer_bank in String data type.
    }
    public String getbank_account()
    {
        return this.bank_account;  //It returns the value of bank_account in String data type.
    }
    public double getbalance_amount()
    {
        return this.balance_amount;  //It returns the value of balance_amount in double data type.
    }
    
    // Two setters or mutator methods are created to reset the value of given private variables.
    public void setclient_name(String client_name) //A mutator method named client_name with return type void is created.
    {
        this.client_name = client_name;
    }
    public void setbalance_amount(double balance_amount) //A mutator method named balance_amount with return type void is created.
    {
        this.balance_amount=balance_amount;
    }
    
    // A display method to print the required output is created. 
    public void display()
    {  
        /*
        * The "if-else" statement executes the "if" portion if the requirements are satisfied and the "else" portion if the requirements
        * are not satisfied.
        */
       if (this.client_name == "")
       {
           System.out.println("Client name is not assigned. Please enter the client name");
       }
       else 
       {
           System.out.println("The Client Name is " + this.client_name);
           System.out.println("The Card ID is " + this.card_id);
           System.out.println("The Issuer Bank is " +this.issuer_bank);
           System.out.println("The Bank Account is " +this.bank_account);
           System.out.println("The Balance Amount is " +this.balance_amount);
       }
    }
}