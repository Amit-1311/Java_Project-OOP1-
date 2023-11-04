package Abc;
import Interface.SavingsAccount;
import java.util.*;
import java.text.*;
public class Customer implements SavingsAccount
{

    public String username,password,name,address,phone;
    public double balance;
    public ArrayList<String> transactions;
    public Customer(String username,String password,String name,String address,String phone,double balance,Date date)//method constructor
    {
        this.username = username;//encapsulation in java that have no getter or setter method
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
        transactions  =  new ArrayList<String>(5);
        addTransaction(String.format("Initial deposit - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));//The getCurrencyInstance(Locale inLocale) method is a built-in method of the java.text.NumberFormat returns a currency format for any specifies locale.
    }
    public void update(Date date)//The java string format() method returns the formatted string by given locale, format and arguments.

//If you don't specify the locale in String.format() method, it uses default locale by calling Locale.getDefault() method.

//The format() method of java language is like sprintf() function in c language and printf() method of java language.


    {
        if(balance>= 10000)//balance jodi 10000 theke boro ba shoman hoy taile balance er sathe rate gun hoye balance variable memory te joma hocche
        {
            balance += rate*balance;
        }
        else
        {
            balance -= (int)(balance/100.0); // ar jodi tar che kom hoy taile 9000/100=90 tk balance thaika minus hote thakbe
        }
        addTransaction(String.format("Account updated. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));//%1$tD this is for date and another is for time
    }
    @Override//eta SavingsAccount interface theke override hocche
    public void deposit(double amount,Date date) //deposit amount ta override kora hocche + all time date update kora hocche
    {
        balance += amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)/*ekhane amount ba .format(balance) thakle shei balance tai temporary memory te kaj kore*/+" credited to your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
    }
    @Override//eta SavingsAccount interface theke override hocche
    public void withdraw(double amount,Date date)
    {
        if(amount>(balance-200))
        {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        addTransaction(String.format(NumberFormat.getCurrencyInstance().format(amount)+" debited from your account. Balance - " +NumberFormat.getCurrencyInstance().format(balance)+" as on " + "%1$tD"+" at "+"%1$tT.",date));
    }
    private void addTransaction(String message)
    {
        transactions.add(0,message);
        if(transactions.size()>5)
        {
            transactions.remove(5);//this is for remove or delete element 
            transactions.trimToSize();/*The trimToSize() method of ArrayList in Java trims the capacity of an ArrayList instance to be the list’s current size. This method is used to trim an ArrayList instance to the number of elements it contains.

Syntax:

trimToSize()
Parameter: It does not accepts any parameter.

Return Value: It does not returns any value. It trims the capacity of this ArrayList instance to the number of the element it contains.*/
        }
    }
}
