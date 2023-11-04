import Abc.Customer;//whole packages importing
import java.util.*;
import java.text.*; //default packages
public class Bank
{
    Map<String,Customer> customerMap;//Maps are used for when you want to associate a key with a value and Lists are an ordered collection.
    // Map is an interface in the Java Collection Framework and a HashMap is one 
    //implementation of the Map interface. HashMap are efficient 
    //for locating a value based on a key and inserting and deleting values based on a key.
    Bank()
    {
        customerMap = new HashMap <String,Customer>();//HashMap is a Map based collection class that is used for storing Key & value pairs, it is denoted as HashMap<Key, Value> or HashMap<K, V>.
    }
    public static void main(String []args)
    {
        Scanner sc  =  new Scanner(System.in);
        Customer customer;
        String username,password;double amount;
        Bank bank  =  new Bank();
        int choice;
        while(true)
        {
            System.out.println("\n$$$$$$$$$$$$$$$$$");
            System.out.println("BANK    OF     SAIF");
            System.out.println("n$$$$$$$$$$$$$$$$$\n");
            System.out.println("1. Register account.");
            System.out.println("2. Login.");
            System.out.println("3. Update accounts.");
            System.out.println("4. Exit.");
            System.out.println("Bank management System by SAIF SHUVO");
            System.out.print("\nEnter your choice : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter address : ");
                    String address = sc.nextLine();
                    System.out.print("Enter contact number : ");
                    String phone = sc.nextLine();
                    System.out.println("Set username : ");
                    username = sc.next();
                    while(bank.customerMap.containsKey(username))//HashMap containsKey() Method in Java containsKey() method is used to check whether a particular key is being mapped into the HashMap or not. 
                    {
                        System.out.println("Username already exists. Set again : ");
                        username = sc.next();
                    }
                    System.out.println("Set a password (minimum 8 chars; minimum 1 digit, 1 lowercase, 1 uppercase, 1 special character[!@#$%^&*_]) :");
                    password = sc.next();
                    sc.nextLine();
                    while(!password.matches((("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))))
                    {
                        System.out.println("Invalid password condition. Set again :");
                        password=sc.next();
                    }
                    System.out.print("Enter initial deposit : ");
                    sc.nextLine();
                    while(!sc.hasNextDouble())
                    {
                        System.out.println("Invalid amount. Enter integer type value");
                        sc.nextLine();
                    }
                    amount=sc.nextDouble();

                    customer = new Customer(username,password,name,address,phone,amount,new Date());
                    bank.customerMap.put(username,customer);//used hashmap that enlisted string for username and class for customer
                    break;
                case 2:
                    System.out.println("Enter username : ");
                    username = sc.next();
                    sc.nextLine();
                    System.out.println("Enter password : ");
                    password = sc.next();
                    sc.nextLine();
                    if(bank.customerMap.containsKey(username))
                    {
                        customer = bank.customerMap.get(username);//checked in hashmap for the user
                        if(customer.password.equals(password))//checked that password is matched with the inserted hashmap enlisted string value 
                        {
                            while(true)
                            {
                                System.out.println("\n-------------------");
                                System.out.println("W  E  L  C  O  M  E");
                                System.out.println("-------------------\n");
                                System.out.println("1. Deposit.");
                                System.out.println("2. Transfer.");
                                System.out.println("3. Last 5 transactions.");
                                System.out.println("4. User information.");
                                System.out.println("5. withdraw.");
                                System.out.println("6. Log out.");
                                System.out.println("Bank management System by SAIF SHUVO");
                                System.out.print("\nEnter your choice : ");
                                choice = sc.nextInt();
                                sc.nextLine();
                                switch(choice)
                                {
                                    case 1:
                                        System.out.print("Enter amount : ");
                                        while(!sc.hasNextDouble())//checked that value is integer or not
                                        {
                                            System.out.println("Invalid amount. Enter again :");
                                            sc.nextLine();
                                        }
                                        amount = sc.nextDouble();
                                        sc.nextLine();
                                        customer.deposit(amount,new Date());//amount and date is new in everytime
                                        break;
                                    case 2:
                                        System.out.print("Enter payee username : ");
                                        username = sc.next();
                                        sc.nextLine();
                                        System.out.println("Enter amount : ");
                                        while(!sc.hasNextDouble())
                                        {
                                            System.out.println("Invalid amount. Enter again :");
                                            sc.nextLine();
                                        }
                                        amount = sc.nextDouble();
                                        sc.nextLine();
                                        if(amount > 300000)
                                        {
                                            System.out.println("Transfer limit exceeded. Contact bank manager.");
                                            break;
                                        }
                                        if(bank.customerMap.containsKey(username))
                                        {
                                            Customer payee = bank.customerMap.get(username);
                                            payee.deposit(amount,new Date());
                                            customer.withdraw(amount,new Date());
                                        }
                                        else
                                        {
                                            System.out.println("Username doesn't exist.");
                                        }
                                        break;
                                    case 3:
                                        for(String transactions : customer.transactions)
                                        {
                                            System.out.println(transactions);
                                        }
                                        break;
                                    case 4:
                                        System.out.println("Accountholder name : "+customer.name);
                                        System.out.println("Accountholder address : "+customer.address);
                                        System.out.println("Accountholder contact : "+customer.phone);
                                        break;
                                        case 5: 
                                        System.out.print("Enter amount : ");
                                        while(!sc.hasNextDouble()){
                                            System.out.println("Invalid amount. Enter again:");
                                            sc.nextLine();
                                        }
                                        amount=sc.nextDouble();
                                        sc.nextLine();
                                        customer.withdraw(amount,new Date());
                                        break;


                                    default:
                                        System.out.println("Wrong choice !");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Wrong username/password.");
                        }
                    }
                    else
                    {
                        System.out.println("Wrong username/password.");
                    }
                    break;
                case 3:
                    System.out.println("Enter username : ");
                    username = sc.next();
                    if(bank.customerMap.containsKey(username)) {
                        bank.customerMap.get(username).update(new Date());
                    }
                    else
                    {
                        System.out.println("Username doesn't exist.");
                    }
                    break;
                case 4:
                    System.out.println("\nThank you for choosing Bank Of Java.");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Wrong choice !");
            }
        }
    }
}
