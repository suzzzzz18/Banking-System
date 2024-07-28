/**
 * BankGUI is a subclass of the parent class bank_card which creates a GUI for the banking transactions.
 * It has five methods. 
 * @Sujina Dangal
 * @May 7
 */

// Importing all the necessary java GUI packages.
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class BankGUI implements ActionListener
{   
    //Declaring the instance variables of JFrame
    private JFrame frame1, frame2, frame3;
    //Declaring the instance variables of JPanel
    private JPanel panel1, panel2, panel3;
    //Declaring the instance variables of JLabel
    private JLabel title, title1, title2, title3, title4;
    private JLabel CardID_dc, BalanceAmount_dc, BankAccount_dc, IssuerBank_dc, ClientName_dc, PinNumber_dc, WithdrawalAmount_dc, 
                   DateOfWithdrawal_dc, CardID_cc, BalanceAmount_cc, BankAccount_cc, IssuerBank_cc, ClientName_cc, CvcNumber_cc, InterestRate_cc,
                   CreditLimit_cc, GracePeriod_cc, ExpirationDate_cc;
    ////Declaring the instance variables of JButton
    private JButton DebitCard, CreditCard, AddDebitCard_dc, CreditCard_dc, GoBack_dc, Withdraw_dc, Display_dc, Clear_dc, AddCreditCard_cc,
                    CancelCreditCard_cc, SetCreditLimit_cc, Clear_cc, Display_cc, GoBack_cc, DebitCardcc;
    //Declaring the instance variables of JTextfield
    private JTextField CardID_dcfield, BalanceAmount_dcfield, BankAccount_dcfield, IssuerBank_dcfield, ClientName_dcfield, PinNumber_dcfield,
                       WithdrawalAmount_dcfield, CardID_ccfield, BalanceAmount_ccfield, BankAccount_ccfield, IssuerBank_ccfield, CvcNumber_ccfield,
                       ClientName_ccfield, InterestRate_ccfield, CreditLimit_ccfield, GracePeriod_ccfield;
    //Declaring the instance variables of JComboBox
    private JComboBox DateOfWithdrawal_boxdc1, DateOfWithdrawal_boxdc2, DateOfWithdrawal_boxdc3,
                      ExpirationDate_boxcc1, ExpirationDate_boxcc2, ExpirationDate_boxcc3;
    //the concept of generics
    private ArrayList<bank_card> Array = new ArrayList <bank_card>();
    ////Declaring the instance variables of Debit Interface
    private String addbank_Account;
    private String addclient_Name;
    private String addissuer_Bank;
    private String addpin_Number;
    private String addcard_Id;
    private String addbalance_Amount;
    private String withdraw_date,addwithdraw_Amount1;
    //Declaring the instance variables of Credit Interface
    private String ccbank_Account;
    private String ccissuer_Bank, ccclient_Name;
    private String ccadd_cvc, ccaddcard_id, ccaddbalance_amount, gracePeriod_SCL, creditLimit_SCL;
    //object of debit_card created as static
    public static debit_card debit_obj, var;
    //object of debit_card created as static
    public static credit_card credit_obj, var1;
    
    
    public void actionPerformed(ActionEvent e)
    {   
        
        if(e.getSource() == DebitCard)
        {
             DebitInterface();      //DebitInterface is called
        }
        
        if(e.getSource() == CreditCard)
        {
             CreditInterface();     //CreditInterface is called
        }
        
        //Go Back Button of Debit Card
        if(e.getSource() == GoBack_dc)
        {
             this.bank();
             frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             frame2.dispose();
        }
         
        //Switch to Credit Card Button of Debit Card
        if(e.getSource() == CreditCard_dc)
        {
             CreditInterface();
             frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             frame2.dispose();
        }
         
        //Switch to Debit Card Button of Credit Card
        if(e.getSource() == DebitCardcc)
        {
             DebitInterface();
             frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             frame3.dispose();
        }
         
        //Go Back Button of Credit Card
        if(e.getSource() == GoBack_cc)
        {
             this.bank();
             frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             frame3.dispose();
        }
        
        //Clear Button of Debit Card
        if(e.getSource() == Clear_dc)
        {
            //variable.setText method with empty parameters is called 
             CardID_dcfield.setText("");
             BalanceAmount_dcfield.setText("");
             BankAccount_dcfield.setText("");
             IssuerBank_dcfield.setText("");
             ClientName_dcfield.setText("");
             PinNumber_dcfield.setText("");
             WithdrawalAmount_dcfield.setText("");
        }
         
        //Clear Button of Credit Card
        if(e.getSource() == Clear_cc)
        {
             //variable.setText method with empty parameters is called 
             CardID_ccfield.setText("");
             BalanceAmount_ccfield.setText("");
             BankAccount_ccfield.setText("");
             IssuerBank_ccfield.setText("");
             CvcNumber_ccfield.setText("");
             ClientName_ccfield.setText("");
             InterestRate_ccfield.setText("");
             CreditLimit_ccfield.setText("");
             GracePeriod_ccfield.setText("");
        }
        
        //Add Debit Card Button of Debit Card
        if(e.getSource() == AddDebitCard_dc)
        {
            if((  BalanceAmount_dcfield.getText().equals("") || CardID_dcfield.getText().equals("") || BankAccount_dcfield.getText().equals("") 
            || IssuerBank_dcfield.getText().equals("") || ClientName_dcfield.getText().equals("") || PinNumber_dcfield.getText().equals("")))
            {
            
            JOptionPane.showMessageDialog(panel2,"Please enter all the required fields.");
            
            
            }
            else
            {
                addbank_Account = BankAccount_dcfield.getText();
                //variablName = textfield.getText();
                addissuer_Bank = IssuerBank_dcfield.getText();
                addclient_Name = ClientName_dcfield.getText(); 
                boolean ISCARDID = true;
                try
                {
                    addpin_Number =PinNumber_dcfield.getText();
                    int addPinNumber = Integer.parseInt(addpin_Number);         //String value is converted to int
                    try{
                            addcard_Id = CardID_dcfield.getText();
                            int addCardId = Integer.parseInt(addcard_Id);       //String value is converted to int
                            try{
                            
                                addbalance_Amount = BalanceAmount_dcfield.getText();
                                double addBalanceAmount = Double.parseDouble(addbalance_Amount);        //String value is converted to double
                                
                                //Creating a for loop to check whether entered Debit Card already exists.
                                for(bank_card id1 : Array)
                                {   if(id1.getcard_id() == (addCardId))
                                    { 
                                        ISCARDID = false;
                                        JOptionPane.showMessageDialog(panel2,"A Debit Card has already been issued with this Card ID","Error!",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                
                                if(ISCARDID == true)
                                {
                                    //The Debit Card constructor is called. 
                                    debit_obj = new debit_card(addCardId, addclient_Name, addissuer_Bank, addbank_Account, addBalanceAmount, addPinNumber);
                                    Array.add(debit_obj);
                                    String dcMsg = "\nCard ID: " + addcard_Id + "\nIssuer Bank: " + addissuer_Bank + "\nClient Name: "+addclient_Name +"\nBank Account: "+addbank_Account + "\nBalance Amount: " + addBalanceAmount + "\nPIN Number: ****" ; 
                                    JOptionPane.showMessageDialog(panel2,"A Debit Card has been successfully created." + dcMsg,"Congratulations!",JOptionPane.INFORMATION_MESSAGE );
                                    
                                }
                                
                                
                            }
                            catch(NumberFormatException h)
                            {
                                JOptionPane.showMessageDialog(panel2,"Please enter the balance amount in double format.");
                            
                            }
                    }
                    catch(NumberFormatException h)
                    {
                     JOptionPane.showMessageDialog(panel2,"Please enter the Card ID in numbers.");   
                    }
                }catch(NumberFormatException h)
                {
                    JOptionPane.showMessageDialog(panel2,"Please enter a valid PIN Number only.");
                }
            }
        }
         
        
        //Add Credit Card Button of Credit Card
        if(e.getSource() == AddCreditCard_cc)
        {
            if(( CardID_ccfield.getText().equals("") || BalanceAmount_ccfield.getText().equals("") || BankAccount_ccfield.getText().equals("") 
            || IssuerBank_ccfield.getText().equals("") || ClientName_ccfield.getText().equals("") || CvcNumber_ccfield.getText().equals("") || InterestRate_ccfield.getText().equals("") ))
            {
            
            JOptionPane.showMessageDialog(panel3,"Please enter all the required fields.");
             
            
            }
            else
            {
                ccbank_Account =  BankAccount_ccfield.getText();
                //variablName = textfield.getText();
                ccissuer_Bank = IssuerBank_ccfield.getText();
                ccclient_Name =  ClientName_ccfield.getText(); 
                boolean ISCARDID1 = true;
                String monthcc = ExpirationDate_boxcc2.getSelectedItem().toString();
                String yearcc = ExpirationDate_boxcc3.getSelectedItem().toString();
                String daycc = ExpirationDate_boxcc1.getSelectedItem().toString();
            
                String Expiry_date = yearcc+"-"+monthcc+"-"+daycc;
            
                try
                {
                    ccadd_cvc = CvcNumber_ccfield.getText();
                    int ccaddCvc = Integer.parseInt(ccadd_cvc);     //String value is converted to int
                    try{
                            ccaddcard_id = CardID_ccfield.getText();
                            int ccaddcardId = Integer.parseInt(ccaddcard_id);       //String value is converted to int
                            try{
                            
                                ccaddbalance_amount = BalanceAmount_ccfield.getText();
                                double ccaddbalanceAmount = Double.parseDouble(ccaddbalance_amount);        //String value is converted to double
                                String ccaddinterest_rate = InterestRate_ccfield.getText();
                                double ccaddinterestRate = Double.parseDouble(ccaddinterest_rate);      //String value is converted to double
                                //Creating a for loop to check whether entered Credit Card already exists.
                                for(bank_card id3 : Array)
                                {   if(id3.getcard_id() == (ccaddcardId))
                                    { 
                                        ISCARDID1 = false;
                                        JOptionPane.showMessageDialog(panel3,"A Credit Card has already been issued with this Card ID.","Error!",JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                if(ISCARDID1 == true)
                                {
                                    //The Credit Card constructor is called.
                                    credit_obj=new credit_card(ccaddcardId,ccclient_Name,ccissuer_Bank,ccbank_Account,ccaddbalanceAmount,ccaddCvc,ccaddinterestRate,Expiry_date);
                                    Array.add(credit_obj);
                                    String dcMsg1 = "\nCard ID: " + ccaddcard_id + "\nIssuer Bank: " + ccissuer_Bank + "\nClient Name: "+ccclient_Name +"\nBank Account: "+ccbank_Account +
                                                    "\nBalance Amount: " + ccaddbalanceAmount + "\nCVC Number: " +ccaddCvc +"\nInterest Rate: " + ccaddinterest_rate+ "\nExpiration Date: " + Expiry_date; 
                                    JOptionPane.showMessageDialog(panel3,"A Credit Card has been successfully created." + dcMsg1,"Congratulations!",JOptionPane.INFORMATION_MESSAGE );
                                    
                                }
                            }
                            catch(NumberFormatException h)
                            {
                                JOptionPane.showMessageDialog(panel3,"Please enter the Balance Amount and Interest Rate in double format.");
                            
                            }
                    }
                    catch(NumberFormatException h)
                    {
                     JOptionPane.showMessageDialog(panel3,"Please enter the Card ID in numbers.");   
                    }
                }catch(NumberFormatException h)
                {
                    JOptionPane.showMessageDialog(panel3,"Please enter a valid CVC number only.");
                }
            }
        }
        
       
        //Withdraw Button of Debit Card
        if(e.getSource() == Withdraw_dc)
        { 
            if(( CardID_dcfield.getText().equals("") ||WithdrawalAmount_dcfield.getText().equals("") || PinNumber_dcfield.getText().equals("") ))
            {
            
            JOptionPane.showMessageDialog(panel2,"Please enter all the required fields.","Error!",JOptionPane.ERROR_MESSAGE);
            
            
            }
            
            else
            {
           
            String month = DateOfWithdrawal_boxdc2.getSelectedItem().toString();
            String year = DateOfWithdrawal_boxdc3.getSelectedItem().toString();
            String day = DateOfWithdrawal_boxdc1.getSelectedItem().toString();
            
            withdraw_date = year+"-"+month+"-"+day;
            int addwithdrawAmount1 = 0;
            try
            {
                addpin_Number = PinNumber_dcfield.getText();
                int addpinNumber1 = Integer.parseInt(addpin_Number);        //string value is converted to int
                try
                {
                            addcard_Id =  CardID_dcfield.getText();
                            int addcardId1 = Integer.parseInt(addcard_Id);      //String value is converted to int
                            try
                            {
                        
                                addwithdraw_Amount1 = WithdrawalAmount_dcfield.getText();
                                addwithdrawAmount1 = Integer.parseInt(addwithdraw_Amount1);     //String value is converted to double
                                int loop = 0;
                                //Creating a for loop to check whether entered Debit Card  already exists.
                                for(bank_card id2: Array)
                                {
                                        if(id2 instanceof debit_card)
                                        {   
                                            var= (debit_card) id2; //Value assigned to id2
                        
                                            if(var.getcard_id() == addcardId1)  
                                            {   
                                                if(addpinNumber1 == var.getpin_number())
                                                {
                                                    loop = loop +1;
                                                    if(addwithdrawAmount1 <= var.getbalance_amount()) 
                                                    {
                                                            //Withdraw method called from Debit Card
                                                            var.withdraw(addwithdrawAmount1,withdraw_date,addpinNumber1);
                                                            String dcMsg1 = "\nCard ID: " + addcard_Id + "\nPin Number: *****" + "\nDate Of Withdrawal: " + 
                                                                withdraw_date + "\n Withdrawal Amount:" + addwithdraw_Amount1;
                                                            JOptionPane.showMessageDialog(panel2,"The amount has been withdrawan successfully." + dcMsg1,"Transaction Successful!",JOptionPane.INFORMATION_MESSAGE );
                                                
                                                            break;
                                                        
                                                    }
                                                    else 
                                                    {
                                                       JOptionPane.showMessageDialog(panel2,"You do not have sufficient balance in your account." ,"Error!",JOptionPane.INFORMATION_MESSAGE ); 
                                                       break;
                                                    }
                                                }
                                                else 
                                                {
                                                   JOptionPane.showMessageDialog (panel2,"Incorrect details. The amount could not be withdrawan." ,"Error!",JOptionPane.INFORMATION_MESSAGE ); 
                                                   break;
                                                }
                                            }           
                                      }
                                }
                                if(loop == 0)
                                {
                                    JOptionPane.showMessageDialog (panel2,"Invalid Card ID" ,"Error!",JOptionPane.INFORMATION_MESSAGE );
                                }
                            }
                            catch(NumberFormatException h)
                                {
                                JOptionPane.showMessageDialog(panel2,"Please enter the desired Withdrawal Amount in number only.");
                                }
                }
                catch(NumberFormatException h)
                {
                     JOptionPane.showMessageDialog(panel2,"Please enter the Card ID in number only.");
                }
            }
            catch(NumberFormatException h)
            {
                     JOptionPane.showMessageDialog(panel2,"Please enter a valid PIN Number only.");
            }
          }
        }
        
        //Set Credit Limit Button of Credit Card
        if(e.getSource() == SetCreditLimit_cc)
         {
            if(CardID_ccfield.getText().equals("") || CreditLimit_ccfield.equals("") ||  GracePeriod_ccfield.equals(""))
            {
             
                JOptionPane.showMessageDialog(panel3,"Please enter all the required fields.","Error!",JOptionPane.ERROR_MESSAGE);
            
            }
            else
            {
                try
                {
                    ccaddcard_id= CardID_ccfield.getText();
                    int addcardId1SCL = Integer.parseInt(ccaddcard_id);     //String value is converted to int
                    gracePeriod_SCL = GracePeriod_ccfield.getText();
                    int gracePeriodSCL = Integer.parseInt(gracePeriod_SCL);     //String value is converted to int
                    try
                    {
                         creditLimit_SCL = CreditLimit_ccfield.getText();
                         double creditLimitSCl = Double.parseDouble(creditLimit_SCL);       //String value is converted to double
                         //Creating a for loop to check whether entered Credit Card already exists.
                        for(bank_card id4: Array)
                        {
                                        if(id4 instanceof credit_card)
                                        {   
                                            credit_card SCL= (credit_card) id4; //Value assigned to id4
                        
                                            if(SCL.getcard_id() == addcardId1SCL)  
                                            {
                                                if(creditLimitSCl<= (SCL.getbalance_amount()*2.5))
                                                {
                                                    //Set Credit Limit method called
                                                    SCL.setcredit_limit(creditLimitSCl,gracePeriodSCL);
                                                    String SCLmsg = "\nCard ID: " + ccaddcard_id + "\nGrace Period: "+ gracePeriod_SCL + "\nCredit Limit: " +  creditLimit_SCL;
                                                    JOptionPane.showMessageDialog(panel3,"Congratulations!, the Credit Limit has been set."+SCLmsg ,"Successful!",JOptionPane.INFORMATION_MESSAGE);
                                                    break;
                                                }
                                                else 
                                                {
                                                   JOptionPane.showMessageDialog(panel3,"The Credit Limit could not be set." ,"Error!",JOptionPane.ERROR_MESSAGE ); 
                                                   break;
                                                }
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(panel3,"Please enter a valid Card ID." ,"Error!",JOptionPane.ERROR_MESSAGE ); 
                                            
                                            }
                                        }           
                        }
                    }
                    catch(NumberFormatException h)
                    {
                        JOptionPane.showMessageDialog(panel3,"Please enter the Credit Limit in double format.","Error!",JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(NumberFormatException h)
                {
                     JOptionPane.showMessageDialog(panel3,"Please enter all the required fields.","Error!",JOptionPane.ERROR_MESSAGE);
                }            
            }
        }
        
        //Cancel Credit Card Button of Credit Card
        if(e.getSource() == CancelCreditCard_cc)
        {
            if(CardID_ccfield.getText().equals("") )
            {
                JOptionPane.showMessageDialog(panel3,"Please enter all the required fields.","Error!",JOptionPane.ERROR_MESSAGE);
            
            }
            else
            {
                try
                {
                     ccaddcard_id= CardID_ccfield.getText();
                     int addcardIDCCC = Integer.parseInt(ccaddcard_id);
                     //Creating a for loop to check whether entered Credit Card already exists.
                     for(bank_card id5 : Array)
                     {
                        if(id5 instanceof credit_card)
                        {
                            credit_card ccc = (credit_card) id5;        //Value assigned to id5
                            if(id5.getcard_id() == addcardIDCCC)
                            {
                                ccc.cancelcredit_card();
                                JOptionPane.showMessageDialog(panel3,"The Credit Card is successfully cancelled.","Successful!",JOptionPane.INFORMATION_MESSAGE);
                                
                            }
                            /*else
                            {
                                JOptionPane.showMessageDialog(panel3,"Please enter a valid Card ID.","Error!",JOptionPane.ERROR_MESSAGE);
            
                                
                            }*/
                        
                        }
                        
                     }
                }
                catch(NumberFormatException h)
                {
                    JOptionPane.showMessageDialog(panel3,"Please enter the Card ID","Error!",JOptionPane.ERROR_MESSAGE);
                }
            }
         }
         
        //Display Button of Debit Card
        if(e.getSource() == Display_dc)
        {
            if(Array.isEmpty())
            {
                JOptionPane.showMessageDialog(panel2,"Please enter all the required fields.");   
            }
            else
            {   //A loop is created to check weather the object already exists in they arraylist or not.
                for(bank_card dCard: Array)
                {
                    if(dCard instanceof debit_card)
                    {
                        System.out.println("\n");
                        bank_card sus = (debit_card) dCard;     //Downcasting the object of bank_card.
                        sus.display();      //Display method is called.
                        String debimsg = "\nCard ID: " + addcard_Id + "\nWithdrawal Amount: " + addwithdraw_Amount1 + "\nDate of Withdrawal: "+withdraw_date
                                                + "\nPIN Number: " +addpin_Number + "\nBalance Amount: " +addbalance_Amount;
                        JOptionPane.showMessageDialog(panel2,"Debit Card Details:" + debimsg);
                    }
                }
            }
        }
         
        //Display Button of Credit Card
        if(e.getSource() == Display_cc)
        {
            if(Array.isEmpty())
            {
                JOptionPane.showMessageDialog(panel3,"Please enter all the required fields.");   
            }
            else
            {   //A loop is created to check weather the object already exists in they arraylist or not.
                for(bank_card newCreditCard: Array)
                    {
                    if(newCreditCard instanceof credit_card)
                    {
                        System.out.println("\n");
                        bank_card obj0 = (credit_card) newCreditCard;       //Downcasting the object of bank_card.
                        obj0.display();     //Display method is called.
                        String display_cc = "\nCard ID: "+ccaddcard_id+ "\nIssuer Bank: " +ccissuer_Bank + "\nBank Account:" +ccbank_Account+ "\nCredit Limit: " +creditLimit_SCL+
                        "\nGrace Period: "+gracePeriod_SCL+"\nCVC Number:"+ccadd_cvc+ "\nBalance Amount: " + ccaddbalance_amount;
                        
                        JOptionPane.showMessageDialog(panel3,"Credit Card Details:" + display_cc );
                    }
                }
            }
        }
    }
    
    
   
    public void bank()
    {
       // JFrame for Bank GUI
       frame1 = new JFrame("Citizen's Bank");
       frame1.setBounds(380, 150, 670, 550);
       frame1.setResizable(false);
       frame1.setLayout(null);
       
       
       // JPanel for Bank GUI
       panel1 = new JPanel();
       panel1.setBounds(0, 0,670, 530);
       Color color1 = new Color (245, 217, 186);
       panel1.setBackground(color1);
       panel1.setLayout(null);
       
       
       // JLabel adding text
       title = new JLabel("WELCOME!");
       title.setBounds(235,50,400,30);
       title.setFont(new Font("Chalkboard", Font.ITALIC,40));
       panel1.add(title);
       
       
       // JLabel adding text
       title1 = new JLabel("Citizen's Bank");
       title1.setBounds(250,130,400,30);
       title1.setFont(new Font("TimesRoman", Font.BOLD,26));
       panel1.add(title1);
       
       
       // JLabel adding text
       title4 = new JLabel("Thank you for visiting!");
       title4.setBounds(210,400,400,30);
       title4.setFont(new Font("Chalkboard", Font.ITALIC,24));
       panel1.add(title4);
       
       
       // JButton for Debit Card
       DebitCard = new JButton("DEBIT CARD");
       DebitCard.setBounds(230,190,200,75);
       DebitCard.setFont(new Font("Cochin", Font.BOLD,22));
       panel1.add(DebitCard);
       DebitCard.addActionListener(this);
        
       
       // JButton for Credit Card
       CreditCard = new JButton("CREDIT CARD");
       CreditCard.setBounds(230,280,200,75);
       CreditCard.setFont(new Font("Cochin", Font.BOLD,22));
       panel1.add(CreditCard);
       CreditCard.addActionListener(this);
       
       
       // Adding to the JPanel 
       frame1.add(panel1);
       frame1.setVisible(true);
    }
        
        
        
        
    public void DebitInterface() 
    {
        // JFrame of Debit Card     
        frame2 = new JFrame("Debit Card");
        frame2.setBounds(380, 150, 870, 650);
        frame2.setResizable( false);
        frame2.setLayout( null);
        
        
        // JPanel of Debit Card
        panel2 = new JPanel();
        panel2.setBounds(0, 0,870, 630);
        Color color2 = new Color (217, 175, 128);
        panel2.setBackground(color2);
        panel2.setLayout(null);
        
        
        // JLabel adding text
        title2 = new JLabel("Debit Card");
        title2.setBounds(380,20,400,35);
        title2.setFont(new Font("Eurostile", Font.BOLD,22));
        panel2.add(title2);
        

        // JLabel of Card ID
        CardID_dc = new JLabel("Card ID");
        CardID_dc.setBounds(40,120,80,35);
        CardID_dc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel2.add(CardID_dc);
        
        
        // JTextField of Card ID
        CardID_dcfield = new JTextField();
        CardID_dcfield.setBounds(220,120,145,35);
        panel2.add(CardID_dcfield);
        
        
        // JLabel of Balance Amount
        BalanceAmount_dc = new JLabel("Balance Amount");
        BalanceAmount_dc.setBounds(40,180,150,35);
        BalanceAmount_dc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel2.add(BalanceAmount_dc);
        
        
        // JTextField of Balance Amount
        BalanceAmount_dcfield = new JTextField();
        BalanceAmount_dcfield.setBounds(220,180,145,35);
        panel2.add(BalanceAmount_dcfield); 
        
        
        // JLabel of Bank Account
        BankAccount_dc = new JLabel("Bank Account");
        BankAccount_dc.setBounds(40,240,220,35);
        BankAccount_dc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel2.add(BankAccount_dc);
        
        
        // JTextField of Bank Account
        BankAccount_dcfield = new JTextField();
        BankAccount_dcfield.setBounds(220,240,145,35);
        panel2.add(BankAccount_dcfield);
        
        
        // JLabel of Issuer Bank
        IssuerBank_dc = new JLabel("Issuer Bank");
        IssuerBank_dc.setBounds(480,120,150,35);
        IssuerBank_dc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel2.add(IssuerBank_dc);
        
        
        // JTextField of Issuer Bank
        IssuerBank_dcfield = new JTextField();
        IssuerBank_dcfield.setBounds(630,120,145,35);
        panel2.add(IssuerBank_dcfield);
        
        
        // JLabel of Client Name
        ClientName_dc = new JLabel("Client Name");
        ClientName_dc.setBounds(480,180,150,35);
        ClientName_dc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel2.add(ClientName_dc);
        
        
        // JTextField of Client Name
        ClientName_dcfield = new JTextField();
        ClientName_dcfield.setBounds(630,180,145,35);
        panel2.add(ClientName_dcfield);
        
        
        // JLabel of PIN Number
        PinNumber_dc = new JLabel("PIN Number");
        PinNumber_dc.setBounds(480,240,150,35);
        PinNumber_dc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel2.add(PinNumber_dc);
        
        
        // JTextField of PIN Number
        PinNumber_dcfield = new JTextField();
        PinNumber_dcfield.setBounds(630,240,145,35);
        panel2.add(PinNumber_dcfield);
        
        
        // JLabel of Withdrawal Amount
        WithdrawalAmount_dc = new JLabel("Withdrawal Amount");
        WithdrawalAmount_dc.setBounds(40,390,220,35);
        WithdrawalAmount_dc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel2.add(WithdrawalAmount_dc);
        
        
        // JTextField of Withdrawal Amount
        WithdrawalAmount_dcfield = new JTextField();
        WithdrawalAmount_dcfield.setBounds(220,390,145,35);
        panel2.add(WithdrawalAmount_dcfield);
        
        
        // JLabel of Date of Withdrawal
        DateOfWithdrawal_dc = new JLabel("Date of Withdrawal");
        DateOfWithdrawal_dc.setBounds(40,450,220,35);
        DateOfWithdrawal_dc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel2.add(DateOfWithdrawal_dc);
        
        
        // JComboBox of Date of Withdrawal-Day
        DateOfWithdrawal_boxdc1 = new JComboBox();
        DateOfWithdrawal_boxdc1.setBounds(220,440,150,60);
        DateOfWithdrawal_boxdc1.addItem("DAY");
        for(int i = 1; i <= 32; i++)
        {
            DateOfWithdrawal_boxdc1.addItem(i);
        }
        DateOfWithdrawal_boxdc1.setFont(new Font("Apple Casual",5,18));
        panel2.add(DateOfWithdrawal_boxdc1);
        
        
        // JComboBox of Date of Withdrawal-Months
        String[] Months = {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                            "November", "December"};
        DateOfWithdrawal_boxdc2 = new JComboBox(Months);
        DateOfWithdrawal_boxdc2.setBounds(370,440,150,60);
        DateOfWithdrawal_boxdc2.setFont(new Font("Apple Casual",5,18));
        panel2.add(DateOfWithdrawal_boxdc2);
        
        
        // JComboBox of Date of Withdrawal-Year
        DateOfWithdrawal_boxdc3 = new JComboBox();
        DateOfWithdrawal_boxdc3.setBounds(520,440,150,60);
        DateOfWithdrawal_boxdc3.addItem("YEAR");
        for(int i = 2023; i >= 2010; i--)
        {
            DateOfWithdrawal_boxdc3.addItem(i);
        }
        DateOfWithdrawal_boxdc3.setFont(new Font("Apple Casual",5,18));
        panel2.add(DateOfWithdrawal_boxdc3);
        
        
        // JButton of Add Debit Card
        AddDebitCard_dc = new JButton("Add Debit Card");
        AddDebitCard_dc.setBounds(100,310,150,40);
        AddDebitCard_dc.setFont(new Font("Apple Casual",5,18));
        panel2.add(AddDebitCard_dc);
        
        
        // JButton of Credit Card
        CreditCard_dc = new JButton("Credit Card");
        CreditCard_dc.setBounds(600,310,150,40);
        CreditCard_dc.setFont(new Font("Apple Casual",5,18));
        panel2.add(CreditCard_dc);
        
        
        // JButton of Go Back
        GoBack_dc = new JButton("Go Back");
        GoBack_dc.setBounds(700,25,130,40);
        GoBack_dc.setFont(new Font("Apple Casual",5,18));
        panel2.add(GoBack_dc);
        
        
        // JButton of Withdraw
        Withdraw_dc = new JButton("Withdraw");
        Withdraw_dc.setBounds(100,540,150,40);
        Withdraw_dc.setFont(new Font("Apple Casual",5,18));
        panel2.add(Withdraw_dc);
        
        
        // JButton of Display
        Display_dc = new JButton("Display");
        Display_dc.setBounds(350,540,150,40);
        Display_dc.setFont(new Font("Apple Casual",5,18));
        panel2.add(Display_dc);
        
        
        // JButton of Clear
        Clear_dc = new JButton("Clear");
        Clear_dc.setBounds(600,540,150,40);
        Clear_dc.setFont(new Font("Apple Casual",5,18));
        panel2.add(Clear_dc);
        
        
        // Registering all the buttons of Debit Card to ActionListener
        AddDebitCard_dc.addActionListener(this);
        CreditCard_dc.addActionListener(this);
        GoBack_dc.addActionListener(this);
        Withdraw_dc.addActionListener(this);
        Display_dc.addActionListener(this);
        Clear_dc.addActionListener(this);
        
        
        // Adding
        frame2.add(panel2);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.dispose();
 
    }
    
    
    
    public void CreditInterface() 
    {
        // JFrame of Credit Card     
        frame3 = new JFrame("Credit Card");
        frame3.setBounds(380, 150, 870, 650);
        frame3.setResizable( false);
        frame3.setLayout( null);
        
        
        // JPanel of Credit Card
        panel3 = new JPanel();
        panel3.setBounds(0, 0,870, 630);
        Color color3 = new Color (217, 175, 128);
        panel3.setBackground(color3);
        panel3.setLayout(null);
        
        
        // JLabel adding text
        title3 = new JLabel("Credit Card");
        title3.setBounds(380,20,400,35);
        title3.setFont(new Font("Eurostile", Font.BOLD,22));
        panel3.add(title3);
        

        // JLabel of Card ID
        CardID_cc = new JLabel("Card ID");
        CardID_cc.setBounds(40,100,80,35);
        CardID_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(CardID_cc);
        
        
        // JTextField of Card ID
        CardID_ccfield = new JTextField();
        CardID_ccfield.setBounds(220,100,145,35);
        panel3.add(CardID_ccfield);
        
        
        // JLabel of Balance Amount
        BalanceAmount_cc = new JLabel("Balance Amount");
        BalanceAmount_cc.setBounds(40,160,150,35);
        BalanceAmount_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(BalanceAmount_cc);
        
        
        // JTextField of Balance Amount
        BalanceAmount_ccfield = new JTextField();
        BalanceAmount_ccfield.setBounds(220,160,145,35);
        panel3.add(BalanceAmount_ccfield); 
        
        
        // JLabel of Bank Account
        BankAccount_cc = new JLabel("Bank Account");
        BankAccount_cc.setBounds(40,220,220,35);
        BankAccount_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(BankAccount_cc);
        
        
        // JTextField of Bank Account
        BankAccount_ccfield = new JTextField();
        BankAccount_ccfield.setBounds(220,220,145,35);
        panel3.add(BankAccount_ccfield);
        
        
        // JLabel of Issuer Bank
        IssuerBank_cc = new JLabel("Issuer Bank");
        IssuerBank_cc.setBounds(480,100,150,35);
        IssuerBank_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(IssuerBank_cc);
        
        
        // JTextField of Issuer Bank
        IssuerBank_ccfield = new JTextField();
        IssuerBank_ccfield.setBounds(630,100,145,35);
        panel3.add(IssuerBank_ccfield);
        
        
        // JLabel of Client Name
        ClientName_cc = new JLabel("Client Name");
        ClientName_cc.setBounds(480,160,150,35);
        ClientName_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(ClientName_cc);
        
        
        // JTextField of Client Name
        ClientName_ccfield = new JTextField();
        ClientName_ccfield.setBounds(630,160,145,35);
        panel3.add(ClientName_ccfield);
        
        
        // JLabel of CVC Number
        CvcNumber_cc = new JLabel("CVC Number");
        CvcNumber_cc.setBounds(480,220,150,35);
        CvcNumber_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(CvcNumber_cc);
        
        
        // JTextField of CVC Number
        CvcNumber_ccfield = new JTextField();
        CvcNumber_ccfield.setBounds(630,220,145,35);
        panel3.add(CvcNumber_ccfield);
        
        
        // JLabel of Interest Rate 
        InterestRate_cc = new JLabel("Interest Rate");
        InterestRate_cc.setBounds(40,280,220,35);
        InterestRate_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(InterestRate_cc);
        
        
        // JTextField of Interest Rate
        InterestRate_ccfield = new JTextField();
        InterestRate_ccfield.setBounds(220,280,145,35);
        panel3.add(InterestRate_ccfield);
        
        
        // JLabel of Grace Period
        GracePeriod_cc = new JLabel("Grace Period");
        GracePeriod_cc.setBounds(480,450,150,35);
        GracePeriod_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(GracePeriod_cc);
        
        
        // JTextField of Grace Period
        GracePeriod_ccfield = new JTextField();
        GracePeriod_ccfield.setBounds(630,450,145,35);
        panel3.add(GracePeriod_ccfield);
        
        
        // JLabel of Credit Limit
        CreditLimit_cc = new JLabel("Credit Limit");
        CreditLimit_cc.setBounds(40,450,220,35);
        CreditLimit_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(CreditLimit_cc);
        
        
        // JTextField of Credit Limit
        CreditLimit_ccfield = new JTextField();
        CreditLimit_ccfield.setBounds(220,450,145,35);
        panel3.add(CreditLimit_ccfield);
        
        
        // JLabel of Expiration Date
        ExpirationDate_cc = new JLabel("Expiration Date");
        ExpirationDate_cc.setBounds(420,280,150,35);
        ExpirationDate_cc.setFont(new Font("Cochin",Font.PLAIN,20));
        panel3.add(ExpirationDate_cc);
        
        
        // JComboBox of Expiration Date-Day
        ExpirationDate_boxcc1 = new JComboBox();
        ExpirationDate_boxcc1.setBounds(560,270,80,60);
        ExpirationDate_boxcc1.addItem("DAY");
        for(int i = 1; i <= 32; i++)
        {
            ExpirationDate_boxcc1.addItem(i);
        }
        ExpirationDate_boxcc1.setFont(new Font("Apple Casual",5,14));
        panel3.add(ExpirationDate_boxcc1);
        
        
        // JComboBox of Expiration Date-Month
        String[] Months = {"MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
                            "November", "December"};
        ExpirationDate_boxcc2 = new JComboBox(Months);
        ExpirationDate_boxcc2.setBounds(640,270,105,60);
        ExpirationDate_boxcc2.setFont(new Font("Apple Casual",5,14));
        panel3.add(ExpirationDate_boxcc2);
        
        
        // JComboBox of Expiration Date-Year
        ExpirationDate_boxcc3 = new JComboBox();
        ExpirationDate_boxcc3.setBounds(745,270,100,60);
        ExpirationDate_boxcc3.addItem("YEAR");
        for(int i = 2023; i >= 2010; i--)
        {
            ExpirationDate_boxcc3.addItem(i);
        }
        ExpirationDate_boxcc3.setFont(new Font("Apple Casual",5,14));
        panel3.add(ExpirationDate_boxcc3);
        
        
        // JButton of Add Credit Card
        AddCreditCard_cc = new JButton("Add Credit Card");
        AddCreditCard_cc.setBounds(100,360,155,40);
        AddCreditCard_cc.setFont(new Font("Apple Casual",5,18));
        panel3.add(AddCreditCard_cc);
        
        
        // JButton of Cancel Credit Card
        CancelCreditCard_cc = new JButton("Cancel Credit Card");
        CancelCreditCard_cc.setBounds(600,360,185,40);
        CancelCreditCard_cc.setFont(new Font("Apple Casual",5,18));
        panel3.add(CancelCreditCard_cc);
        
        
        // JButton of Go Back
        GoBack_cc = new JButton("Go Back");
        GoBack_cc.setBounds(700,25,130,40);
        GoBack_cc.setFont(new Font("Apple Casual",5,18));
        panel3.add(GoBack_cc);
        
        
        // JButton of Set Credit Limit
        SetCreditLimit_cc = new JButton("Set Credit Limit");
        SetCreditLimit_cc.setBounds(100,550,155,40);
        SetCreditLimit_cc.setFont(new Font("Apple Casual",5,18));
        panel3.add(SetCreditLimit_cc);
        
        
        // JButton of Change to Debit Card
        DebitCardcc = new JButton("Debit Card");
        DebitCardcc.setBounds(350,360,150,40);
        DebitCardcc.setFont(new Font("Apple Casual",5,18));
        panel3.add(DebitCardcc);
        
        
        // JButton of Display
        Display_cc = new JButton("Display");
        Display_cc.setBounds(350,550,150,40);
        Display_cc.setFont(new Font("Apple Casual",5,18));
        panel3.add(Display_cc);
        
        
        // JButton of Clear
        Clear_cc = new JButton("Clear");
        Clear_cc.setBounds(600,550,150,40);
        Clear_cc.setFont(new Font("Apple Casual",5,18));
        panel3.add(Clear_cc);
        
        
        //  Registering all the buttons of Credit Card to ActionListener
        AddCreditCard_cc.addActionListener(this);
        CancelCreditCard_cc.addActionListener(this);
        SetCreditLimit_cc.addActionListener(this);
        Clear_cc.addActionListener(this);
        Display_cc.addActionListener(this);
        GoBack_cc.addActionListener(this);
        DebitCardcc.addActionListener(this);
        
        
        // Adding in the JFrame
        frame3.add(panel3);
        frame3.setVisible(true);
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.dispose();
    }
    
    
    // Main method
    public static void main(String args[])
    {
        BankGUI obj = new BankGUI();
        obj.bank();
    }
}