/**
 * credit_card is the sub-class of parent class bank_card. It has six attributes and accepts eight parameters.
 * Each attribute has a corresponding accessor method. Different methods like getters, mutators and display method are used to successfully
 * complete the program.
 * @22067063 Sujina Dangal
 * @24 January
 */
public class credit_card extends bank_card
{
   //cvc_number variable with int data type and private access modifier is created. 
   private int cvc_number;
   //credit_limit variable with double data type and private access modifier is created.
   private double credit_limit;
   //interest_rate variable with double data type and private access modifier is created.
   private double interest_rate;
   //expiration_date variable with String data type and private access modifier is created.
   private String expiration_date;
   //grace_period variable with int data type and private access modifier is created.
   private int grace_period;
   //is-granted variable with boolean data type and private access modifier is created.
   private boolean is_granted;
   
   /*
     * A constructor with public access modifier accepting eight parameters, namely, card_id with int data type, client_name with String data type,
     * issuer_bank with String data type, bank_account with String data type, balance_amount with double data type, cvc_number with int data type,
     * interest_rate with double data type and expiration_date with String data type is created.
     */
   public credit_card (int card_id, String client_name, String issuer_bank, String bank_account, double balance_amount, int cvc_number, 
                       double interest_rate, String expiration_date)
   {
        //calling the constructors using superclass//
        super(card_id, issuer_bank, bank_account, balance_amount); //superclass constructor is called with it's four parameters.
        super.setclient_name(client_name);                         //superclass setters method is called with it's parameter.
        this.cvc_number=cvc_number;                                //An instance variable is assigned to it's parameter cvc_number.
        this.interest_rate=interest_rate;                          //An instance variable is assigned to it's parameter interest_rate.
        this.expiration_date=expiration_date;                      //An instance variable is assigned to it's parameter expiration_date.
        this.is_granted=false;                                     //An instance variable is assigned to it's parameter is_granted.
        //The 'this.' keyword is used to refer to the current object in a method or constructor.
   }   
   
   // Four getters or accessor methods are created to return the value to instance variable.
   public int getcvc_number()
   {
        return this.cvc_number;  //It returns the value of cvc_number in int data type.
   }
   public double getcredit_limit()
   {
        return this.credit_limit;  //It returns the value of credit_limit in double data type.
   }
   public double getinterest_rate()
   {
        return this.interest_rate;  //It returns the value of interest_rate in double data type.
   }
   public String getexpiration_date()
   {
        return this.expiration_date;  //It returns the value of expiration_date in String data type.
   }
   public int getgrace_period()
   {
        return this.grace_period;  //It returns the value of grace_period in int data type.
   }
   public boolean getis_granted()
   {
        return this.is_granted;  //It returns the value of is_granted in boolean data type.
   }
   
   // A setters or mutator method is created to reset the value of given private variables.
   public void setcredit_limit(double credit_limit, int grace_period)
   {
        if(credit_limit <=(2.5*super.getbalance_amount()))  //Superclass display method is called.
        {
           this.credit_limit = credit_limit;  //An instance variable is assigned to it's parameter credit_limit.
           this.grace_period = grace_period;  //An instance variable is assigned to it's parameter grace_period.
           this.is_granted = true;            //An instance variable is assigned to it's parameter is_granted.
        }
        else
        {
           System.out.println("Sorry, the credit cannot be issued.");
           System.out.println("Your credit limit is only upto "+(2.5*super.getbalance_amount()));  //Superclass display method is called.
        }
   }
   
   /*
    * A method accepting four parameters with return type void
    * is created to cancel credit card.
    */ 
   public void cancelcredit_card()
   {
        this.cvc_number = 0;
        this.credit_limit = 0;
        this.grace_period = 0;
        this.is_granted = false;
   }
   
   /*
     * A display method to print the required output is created.
     */ 
   public void display()
   {
        if(is_granted)
        {
           super.display();  //Superclass display method is called.
           System.out.println("Credit Limit: " + this.credit_limit);  
           System.out.println("Grace Period: " + this.grace_period);
        }
        else
        {
           super.display();  //Superclass display method is called.
           System.out.print("CVC Number: " +this.cvc_number);
           System.out.println("Interest rate: " +this.interest_rate);
           System.out.println("Expiration Date: " + this.expiration_date);
        }
   }
}


                   
                   
               