// Oluwadamilola Adeyemo
// ID: 2021-08-0281 - Period 5

// CCA - Café Doux Program (The Coffee Shop's Administration Program).

import java.util.Scanner;  // Needed for the Scanner class.
import java.io.*;
import java.awt.*;
import java.util.*; // String class.


public class CaféDouxProgram
{

   static final int MAXSIZE = 100;
   static int currentSizeBeverage = 0;
   static int currentSizeStaff = 0;   
   static int currentSizeSnacks = 0;  
   static int currentSizeInventory  = 0;  
   static int currentSizeCustomer  = 0;  
   static Scanner keyboard = new Scanner(System.in);

   public static void main (String[] args) throws IOException // Main Menu for Program.
   {     
   
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Variable declaration. 
      int option = 0;
      BeverageFlavours[] beverageList; 
      beverageList = createBeverageArray ();
      createBeverageAccounts (beverageList);
      
      Snacks[] snackList; 
      snackList = createSnacksArray ();
      createSnacksAccount (snackList);
      
      Inventory[]  inventoryList;
      inventoryList = createInventoryArray();
      createInventoryAccount (inventoryList);
   
      Customers[] regularCustomersList;
      regularCustomersList = createCustomerArray();
      createCustomersAccount(regularCustomersList);
   
      CaféDouxStaff[] staffList;
      staffList = createStaffArray();
      createStaffAccount(staffList);
      
   
      while (true)
      {    
         System.out.print("\n--------------------------------------------");
         System.out.print("\n\t\tWELCOME TO CAFÉ DOUX'S ADMIN MENU");
         System.out.println("\n--------------------------------------------");
      
         System.out.println("\n   Your dainty coffee shop down the block. \n  Helping to fuel the community since 1978.");
      
         // MAIN MENU: 
         System.out.println("\n\n************"); 
         System.out.println(" Main Menu:"); 
         System.out.println("************"); 
         System.out.println("\n(1) Beverages & Snacks \n(2) Regular Customers \n(3) Staff \n(4) Inventory \n(0) Exit Program");   
         System.out.print("\nPlease enter your selection ==> ");   
         option = keyboard.nextInt();
        
         if(option == 0)
         {
            writeBeverageDataToFile(beverageList);
            writeSnackDataToFile(snackList);
            writeStaffDataToFile(staffList);
            writeCustomerDataToFile(regularCustomersList);
            writeInventoryToDataFile(inventoryList);
            
            System.out.println ("\nThank you. Any changes made have been saved.");      
            break;
         }
         
         
         else if(option == 1) 
            bevAndSnack(beverageList, snackList);      
         
         else if(option == 2) 
            customers(regularCustomersList);
         
         else if(option == 3)    
            staff(staffList);
         
         else if(option == 4) 
            inventory(inventoryList);
      }  
   }   
   
   
   // SUB MENU - OPTION 1, Beverages & Snacks:
   
   private static void bevAndSnack(BeverageFlavours[] beverageList, Snacks[] snackList) throws IOException
   {
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Variable declaration. 
      int option = 0;
   
      while (true)
      {      
         System.out.println("\n\nBeverages & Snacks Sub Menu:"); 
         System.out.println ("\t\t************");
         System.out.println("\n(1) Beverages \n(2) Snacks \n(0) Go Back");   
      
         System.out.print("\nPlease enter your choice's number ==> ");
         option = keyboard.nextInt();
      
         if (option == 1) 
            beverages(beverageList);
         
         else if (option == 2) 
            snacks(snackList);
                     
         else if (option == 0)
            break;
      }
   }



   // Beverages Menu.

   private static void beverages(BeverageFlavours[] beverageList) throws IOException
   {
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Variable declaration 
      int option, index;
     
      while (true)
      { 
         System.out.println("\n\n************"); 
         System.out.println(" Beverages:"); 
         System.out.println("************"); 
      
         System.out.println("\n(1) List of Beverages  \n(2) Remove a Beverage \n(3) Add a Beverage  \n(0) Go Back");   
      
         System.out.print("\nPlease enter your choice's number ==> ");
         option = keyboard.nextInt();
      
         if (option == 0)
            return;
         
         else if(option == 1) 
         {
            System.out.println("\nBeverages List:");
            System.out.println("**************\n"); 
            showBeverageList(beverageList);
         }
         
         else if(option == 2) 
         {
            System.out.print("Please enter the line number (location): ");
            index = keyboard.nextInt ();
            removeBeverage(beverageList, index);
         }
         
         else if(option == 3) 
            addBeverage(beverageList);
      }   
   }

   private static void createBeverageAccounts (BeverageFlavours[] beverageList) throws IOException
   {
      String inputFileLoc = "BeveragesList.txt";
      String str;
      String flavour;
      int fileSize;
    
      // Open the file.
      File file = new File(inputFileLoc);
      Scanner infile = new Scanner(file);
   
      str = infile.nextLine ();
      fileSize = Integer.parseInt (str);
   
      for (int i = 0 ; i < fileSize ; i++)
      {
         flavour = infile.nextLine();
         beverageList [currentSizeBeverage] = new BeverageFlavours (flavour);
         currentSizeBeverage++;
      }
      infile.close ();
   }

  
   private static void showBeverageList (BeverageFlavours[] beverageList)
   {
      for (int i = 0 ; i < currentSizeBeverage ; i++)
      {
         System.out.println (beverageList[i].getFlavour());
      }
   }
   
   private static void removeBeverage (BeverageFlavours[] beverageList, int index)
   {
      if (index > currentSizeBeverage)
         return;
   
      beverageList [index] = null; // Delete the item.
   
      for (int i = index ; i < currentSizeBeverage - 1 ; i++)
         beverageList [i] = beverageList [i + 1];   // Move the item 1 up.
   
      currentSizeBeverage--;
      return;
   }
   
   private static void addBeverage (BeverageFlavours[] beverageList)
   {
      String flavour;
   
      System.out.print ("Enter New Flavour Name ==> ");
      flavour = keyboard.nextLine ();
            
      beverageList [currentSizeBeverage] = new BeverageFlavours (flavour);
      currentSizeBeverage++;
   }

   private static BeverageFlavours[] createBeverageArray()
   {
      BeverageFlavours[] temp;
      temp = new BeverageFlavours [MAXSIZE];
      return temp;
   }
   

   // Method to write to file. (Option 0) 
   private static void writeBeverageDataToFile (BeverageFlavours[] beverageList) throws IOException
   {
      String outputFileLoc = "BeveragesList.txt";
      PrintWriter output;
      output = new PrintWriter (new FileWriter (outputFileLoc));
   
      output.println (currentSizeBeverage); // Total number of objects in array.
      for (int i = 0 ; i < currentSizeBeverage ; i++)
      {
         output.println (beverageList [i].getFlavour ()); // Write Flavour.
      }
      output.close (); 
   }

     
     
   // Snacks Menu.
   
   private static void snacks(Snacks[] snackList) throws IOException
   {
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Variable declaration 
      int option, index;
   
      while (true)
      {
         System.out.println("\n\n*********"); 
         System.out.println(" Snacks:"); 
         System.out.println("*********"); 
         
         System.out.println("\n(1) List of Snacks  \n(2) Remove a Snack \n(3) Add a Snack  \n(0) Go Back");   
      
         System.out.print("\nPlease enter your choice's number ==> ");
         option = keyboard.nextInt();
      
         if (option == 0)
            return;
         
         else if(option == 1) 
         {
            System.out.println("\n\nSnacks List:");
            System.out.println("***********\n"); 
            showSnacksList(snackList);
         }
         
         else if(option == 2) 
         {
            System.out.print("Please enter the line number (location): ");
            index = keyboard.nextInt ();
            removeSnack(snackList, index);
         }
         
         else if(option == 3) 
            addSnack(snackList);
         
      }
   }

      
   private static void createSnacksAccount (Snacks[] snackList) throws IOException
   {
      String inputFileLoc = "SnackList.txt";
      String str;
      String snack;
      int fileSize;
     
      // Open the file.
      File file = new File(inputFileLoc);
      Scanner infile = new Scanner(file);
   
      str = infile.nextLine ();
      fileSize = Integer.parseInt (str);
   
      for (int i = 0 ; i < fileSize ; i++)
      {
         snack = infile.nextLine();
         snackList [currentSizeSnacks] = new Snacks (snack);
         currentSizeSnacks++;
      }
      
      infile.close ();
   }

   private static void showSnacksList (Snacks[] snackList)
   {
      for (int i = 0 ; i < currentSizeSnacks ; i++)
      {
         System.out.println (snackList[i].getSnack() + "\t");
      }
   }
   
   private static void removeSnack (Snacks[] snackList, int index)
   {
      if (index > currentSizeSnacks)
         return;
   
      snackList [index] = null; // Delete the item.
   
      for (int i = index ; i < currentSizeSnacks - 1 ; i++)
         snackList [i] = snackList [i + 1];   // Move the item 1 up.
   
      currentSizeSnacks--;
      return;
   }
   
   private static void addSnack (Snacks[] snackList)
   {
      String snack;
   
      System.out.print ("Enter New Snack ==> ");
      snack = keyboard.nextLine ();
        
      snackList [currentSizeSnacks] = new Snacks (snack);
      currentSizeSnacks++;
   }

   private static Snacks[] createSnacksArray()
   {
      Snacks[] temp;
      temp = new Snacks [MAXSIZE];
      return temp;
   }


   // Method to write to file. (Option 0).
   private static void writeSnackDataToFile (Snacks[] snackList) throws IOException
   {
      String outputFileLoc = "SnackList.txt";
      PrintWriter output;
      output = new PrintWriter (new FileWriter (outputFileLoc));
   
      output.println (currentSizeSnacks); // Total number of objects in array
      for (int i = 0 ; i < currentSizeSnacks ; i++)
      {
         output.println (snackList [i].getSnack ()); // Write snack.
      }
      output.close ();
   }
   


   // SUB MENU - OPTION 2, Customers:
   
   private static void customers(Customers[] regularCustomersList)
   {
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Variable declaration 
      int option, index;
   
      while (true)
      {      
         System.out.println("\n\n Customers Sub Menu:"); 
         System.out.println("**********************"); 
         System.out.println("\n(1) List of Regular Customers \n(2) Customer Discounts \n(3) Add a Regular Customer \n(4) Remove a Regular Customer \n(0) Go Back");   
      
         System.out.print("\nPlease enter your choice's number ==> ");
         option = keyboard.nextInt();
      
         if(option == 0) 
            return;
         
         else if(option == 1) 
            showCustomerList(regularCustomersList);
            
         else if(option == 2) 
            customerDiscounts(regularCustomersList);
         
         else if(option == 3) 
            addCustomer(regularCustomersList);
         
         else if(option == 4) 
         {
            System.out.print("Please enter the line number (location): ");
            index = keyboard.nextInt ();
            removeCustomer(regularCustomersList, index);
         }
         
      }
   }
   
   
   // Regular Cusomers Discounts.
   
   private static void customerDiscounts(Customers[] regularCustomersList)
   {
      System.out.println("\n** For every 8 drinks a customer buys, their next 2 drinks  are free. **");
      System.out.println("*** And for every 5 snacks a customer buys, they get a 40% discount on 2 snacks. ***");
   
      for (int i = 0 ; i < currentSizeCustomer ; i++)
      {
         System.out.println ("\n" + regularCustomersList[i].getCustomerName() + "\t");
               
         int drinks = ( regularCustomersList[i].getDrinkOrders() ) / 8;
         int drinksDiscount = drinks * 2;
         System.out.println("This customer is eligible for " + drinksDiscount + " free drinks.");
         
         int snacks = ( regularCustomersList[i].getSnackOrders() ) / 5;
         int snacksDiscount = snacks * 2;
         System.out.println("This customer has a 40% discount on: " + snacksDiscount + " snacks.");            
      }
   }

   
   // Regular Customers.
   
   private static void createCustomersAccount (Customers[] regularCustomersList) throws IOException
   {
      String inputFileLoc = "RegularCustomersList.txt";
      String str;
      String customerName;
      String drinkOrders;
      String snackOrders;
      int fileSize;
   
      // Open the file.
      File file = new File(inputFileLoc);
      Scanner infile = new Scanner(file);
   
      str = infile.nextLine ();
      fileSize = Integer.parseInt (str);
   
      for (int i = 0 ; i < fileSize ; i++)
      {
         customerName = infile.nextLine();
         drinkOrders = infile.nextLine();
         snackOrders = infile.nextLine();
         int numberOfDrinkOrders = Integer.parseInt(drinkOrders);
         int numberOfSnackOrderes = Integer.parseInt(snackOrders);
         
         regularCustomersList [currentSizeCustomer] = new Customers (customerName, numberOfDrinkOrders, numberOfSnackOrderes);
         currentSizeCustomer++;
         str = infile.nextLine(); // Reads the blank line.
      }
      
      infile.close ();
   }

   private static void showCustomerList (Customers[] regularCustomersList)
   {
      for (int i = 0 ; i < currentSizeCustomer ; i++)
      {
         System.out.println ("\n" + regularCustomersList[i].getCustomerName() + "\t");
         System.out.println ("Total number of Beverage orders: " + regularCustomersList[i].getDrinkOrders() + "\t");
         System.out.println ("Total number of Snack orders: " + regularCustomersList[i].getSnackOrders() + "\t");
         System.out.println();
      }
   }
   
   private static void removeCustomer (Customers[] regularCustomersList, int index)
   {
      if (index > currentSizeCustomer)
         return;
   
      regularCustomersList [index] = null; // Delete the item.
   
      for (int i = index ; i < currentSizeCustomer - 1 ; i++)
         regularCustomersList [i] = regularCustomersList [i + 1];   // Move the item 1 up.
   
      currentSizeCustomer--;
      return;
   }
   
   private static void addCustomer (Customers[] regularCustomersList)
   {
      String customerName;
      int drinkOrders;
      int snackOrders;
   
      System.out.print ("Enter New Customer Name ==> ");
      customerName = keyboard.nextLine ();
            
      System.out.print ("Enter Number of drinks ordered ==> ");
      drinkOrders = keyboard.nextInt ();
            
      System.out.print ("Enter Numebr of snacks ordered ==> ");
      snackOrders = keyboard.nextInt ();
         
      keyboard.nextLine();
   
      regularCustomersList [currentSizeCustomer] = new Customers (customerName, drinkOrders, snackOrders);
      currentSizeCustomer++;
   }

   private static Customers[] createCustomerArray()
   {
      Customers[] temp;
      temp = new Customers [MAXSIZE];
      return temp;
   }
   

   // Method to write to file. (Option 0)
   private static void writeCustomerDataToFile (Customers[] regularCustomersList) throws IOException
   {
      String outputFileLoc = "RegularCustomersList.txt";
      PrintWriter output;
      output = new PrintWriter (new FileWriter (outputFileLoc));
   
      output.println (currentSizeCustomer); // Total number of objects in array.
      for (int i = 0 ; i < currentSizeCustomer ; i++)
      {
         output.println (regularCustomersList [i].getCustomerName ()); // Write customer's name.
         output.println (regularCustomersList [i].getDrinkOrders ()); 
         output.println (regularCustomersList [i].getSnackOrders ());
         output.println (); // Write blank line.
      }
      output.close ();
   }
   
 

  // SUB MENU - OPTION 3, Staff:
   
   private static void staff(CaféDouxStaff[]staffList) throws IOException
   {
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Variable declaration
      int option, index;
          
      while (true)
      {      
         System.out.println("\n\n****************"); 
         System.out.println(" Staff Sub Menu:"); 
         System.out.println("****************"); 
         System.out.println("\n(1) Staff List  \n(2) Add new staff  \n(3) Remove staff \n(4) Calculate Weekly & Monthly wage \n(0) Go Back");   
      
         System.out.print("\nPlease enter your choice's number ==> ");
         option = keyboard.nextInt();
      
         if(option == 0) 
            break;
         
         else if(option == 1) 
         {
            System.out.println("\n\n***************"); 
            System.out.println(" Staff List:");
            System.out.println("***************\n"); 
         
            showStaffList(staffList);
         }
         
         else if(option == 2) 
            addStaff(staffList);
         
         else if(option == 3) 
         {
            System.out.print("Please enter the line number (location) :");
            index = keyboard.nextInt ();
            removeStaff(staffList, index);
         }
         
         else if(option == 4) 
            staffWage(staffList);
      }
   }
    
   // Calculation for any Staff's monthly pay. 
   private static void staffWage (CaféDouxStaff[] staffList) throws IOException
   {
      double weeklyPay;
      double hourlyRate;
      double monthlyWage;
      int hours;
   
      System.out.print("What is this staff's hourly rate? $");
      hourlyRate = keyboard.nextInt();
   
      System.out.print("How many hours has this staff worked this week? ");
      hours = keyboard.nextInt();
      
      weeklyPay = hourlyRate * hours;
      monthlyWage = weeklyPay * 12;
      System.out.printf ("\n\nThe weekly wage for this staff is is $%.2f .", weeklyPay);
      System.out.printf ("\nThe monthly wage for this staff is $%.2f .\n\n", monthlyWage);
   }

   private static void createStaffAccount (CaféDouxStaff[] staffList) throws IOException
   {
      String inputFileLoc = "StaffList.txt";
      String str;
      String name;
      int id;
      String position;
      int hoursOfWork;
      double monthlyWage;
      int fileSize;
     
      // Open the file.
      File file = new File(inputFileLoc);
      Scanner infile = new Scanner(file);
   
      str = infile.nextLine ();
      fileSize = Integer.parseInt (str);
   
      for (int i = 0 ; i < fileSize ; i++)
      {
         name = infile.nextLine();
        
         String idNumber = infile.nextLine();
         id = Integer.parseInt(idNumber);
         
         position = infile.nextLine();
         
         String hours = infile.nextLine();
         hoursOfWork = Integer.parseInt (hours);
         
         String wage = infile.nextLine();
         monthlyWage = Double.parseDouble (wage);
      
         staffList [currentSizeStaff] = new CaféDouxStaff (name, id, position, hoursOfWork, monthlyWage);
         currentSizeStaff++;
      
         str = infile.nextLine(); // Reads the blank line.
      }
      infile.close ();
   }

   private static void showStaffList(CaféDouxStaff[] staffList)
   {
      System.out.println("*Hours of work per week.\n");
   
      String heading1 = "Name";
      String heading2 = "ID Number";
      String heading3 = "Position";
      String heading4 = "Hours of Work";
      String heading5 = "Annual Salary";
      
      System.out.printf("\n%-23s %-15s %-23s %-18s %-15s\n", heading1, heading2, heading3, heading4, heading5);
      System.out.println("--------------------------------------------------------------------------------------------------\n");
   
      for (int i = 0 ; i < currentSizeStaff ; i++)
      {
         System.out.printf("%-25s",staffList[i].getName());
         System.out.printf("%-15s",staffList[i].getIdNumber());
         System.out.printf("%-28s",staffList[i].getPosition());
         System.out.printf("%-18s",staffList[i].getHoursOfWork());
         System.out.printf("$%-15s",staffList[i].getAnnualSalary());
         System.out.println();
      }
   }
   
   private static void addStaff(CaféDouxStaff[] staffList)
   {
      String name;
      int id;
      String position;
      int hoursOfWork;
      double monthlyWage;
         
      System.out.println("\nEnter the New staff's information: ");
      
      System.out.print("\nEnter New staff's name ==> ");
      name = keyboard.nextLine ();
                     
      System.out.print ("Enter " + name + "'s id number  ==> ");
      id = keyboard.nextInt ();
         
      keyboard.nextLine();
            
      System.out.print ("Enter " + name + "'s position title  ==> ");
      position = keyboard.nextLine ();
               
      System.out.print ("Enter " + name + "'s hours of work per week ==> ");
      hoursOfWork = keyboard.nextInt ();
         
      keyboard.nextLine();
      
      System.out.print ("Enter " + name + "'s monthly wage  ==> $");
      monthlyWage = keyboard.nextDouble ();
         
      keyboard.nextLine();
      
      staffList [currentSizeStaff] = new CaféDouxStaff (name, id, position, hoursOfWork, monthlyWage);
      currentSizeStaff++; 
   }
   
   private static void removeStaff(CaféDouxStaff[] staffList, int index)
   { 
      if (index > currentSizeStaff)
         return;
   
      staffList [index] = null; // Delete the item.
   
      for (int i = index ; i < currentSizeStaff - 1 ; i++)
         staffList [i] = staffList [i + 1];   // Move the item 1 up.
   
      currentSizeStaff--;
      return;
   }
   
   private static CaféDouxStaff[] createStaffArray()
   {
      CaféDouxStaff[] temp;
      temp = new CaféDouxStaff [MAXSIZE];
      return temp;
   }


   // Method to write to file. (Option 0)
   private static void writeStaffDataToFile (CaféDouxStaff[] staffList) throws IOException
   {
      String outputFileLoc = "StaffList.txt";
      PrintWriter output;
      output = new PrintWriter (new FileWriter (outputFileLoc));
   
      output.println (currentSizeStaff); // Total number of objects in array.
      for (int i = 0 ; i < currentSizeStaff ; i++)
      {
         output.println (staffList [i].getName ()); // Write Staff Name.
         output.println (staffList [i].getIdNumber ()); // Write ID number.
         output.println (staffList [i].getPosition ()); // Write postion.
         output.println (staffList [i].getHoursOfWork ()); // Write hours of work per week.
         output.println (staffList [i].getAnnualSalary ()); 
         output.println (); // Write blank line.
      }
      output.close ();
   }


   
  // SUB MENU - OPTION 4, Inventory:
   
   private static void inventory(Inventory[] inventoryList)
   {
      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Variable declaration 
      int option, index;
   
      while (true)
      {      
         System.out.println("\n\n*********************"); 
         System.out.println(" Inventory Sub Menu:"); 
         System.out.println("*********************"); 
         System.out.println("\n(1) Inventory List \n(2) Remove from inventory \n(3) Add to inventory \n(0) Go Back");   
      
         System.out.print("\nPlease enter your choice's number ==> ");
         option = keyboard.nextInt();
         
         if(option == 0) 
            return;
         
         else if(option == 1) 
         {
            System.out.println("\nInventory List:");
            System.out.println("****************\n"); 
            showInventoryList(inventoryList);
         }
         
         else if(option == 2) 
         {
            System.out.print("Please enter the line number (location): ");
            index = keyboard.nextInt ();
            removeInventoryItem(inventoryList, index);
         }
         
         else if (option == 3) 
            addInventoryItem(inventoryList);
                                     
      }
   }
   
   private static void createInventoryAccount (Inventory[] inventoryList) throws IOException
   {
      String inputFileLoc = "InventoryList.txt";
      String str;
      String item;
      String quantityAvailable;
      String quantityNeededPerWeek;
      String priceOfItem;
      int fileSize;
   
   
      // Open the file.
      File file = new File(inputFileLoc);
      Scanner infile = new Scanner(file);
   
      str = infile.nextLine ();
      fileSize = Integer.parseInt (str);
   
      for (int i = 0 ; i < fileSize ; i++)
      {
         item = infile.nextLine();
         quantityAvailable = infile.nextLine();
         quantityNeededPerWeek = infile.nextLine();
         priceOfItem = infile.nextLine();
         
         inventoryList [currentSizeInventory] = new Inventory (item, quantityAvailable, quantityNeededPerWeek, priceOfItem);
         currentSizeInventory++;
         str = infile.nextLine(); // Reads the blank line.
      }
      infile.close ();
   }

   private static void showInventoryList (Inventory[] inventoryList)
   {
      String heading1 = "Item";
      String heading2 = "Qty Available";
      String heading3 = "Qty needed / week";
      String heading4 = "Price of Item";
      
      System.out.printf("\n%-19s %-19s %-22s %-18s \n", heading1, heading2, heading3, heading4);
      System.out.println("-------------------------------------------------------------------------------\n");
   
      for (int i = 0 ; i < currentSizeInventory ; i++)
      {
         System.out.printf ("%-22s", inventoryList[i].getItem());
         System.out.printf ("%-20s", inventoryList[i].getQuantityAvailable());
         System.out.printf ("%-20s", inventoryList[i].getQuantityNeededPerWeek());
         System.out.printf ("%-20s", inventoryList[i].getPriceOfItem());
         System.out.println();
      }
   }
   
   private static void removeInventoryItem (Inventory[] inventoryList, int index)
   {
      if (index > currentSizeInventory)
         return;
   
      inventoryList [index] = null; // Delete the item.
   
      for (int i = index ; i < currentSizeInventory - 1 ; i++)
         inventoryList [i] = inventoryList [i + 1];   // Move the item 1 up.
   
      currentSizeInventory--;
      return;
   }
   
   private static void addInventoryItem (Inventory[] inventoryList)
   {
      String item;
      String quantityAvailable;
      String quantityNeededPerWeek;
      String priceOfItem;
   
      System.out.print ("Enter New Inventory item information. ");
      
      System.out.print ("Enter Inventory item's name ==> ");     
      item = keyboard.nextLine ();
         
      keyboard.nextLine();
   
      System.out.print ("Enter quantity currently available for Inventory item ==> ");
      quantityAvailable = keyboard.nextLine ();
   
      System.out.print ("Enter quantity needed every week for Invewntory item ==> ");
      quantityNeededPerWeek = keyboard.nextLine ();
   
      System.out.print ("Enter price of Inventory item ==> ");
      priceOfItem = keyboard.nextLine ();
         
      keyboard.nextLine();
   
      inventoryList [currentSizeInventory] = new Inventory (item, quantityAvailable, quantityNeededPerWeek, priceOfItem);
      currentSizeInventory++;
   }

   private static Inventory[] createInventoryArray()
   {
      Inventory[] temp;
      temp = new Inventory [MAXSIZE];
      return temp;
   }
   

   // Method to write to file. (Option 0)
   private static void writeInventoryToDataFile (Inventory[] inventoryList) throws IOException
   {
      String outputFileLoc = "InventoryList.txt";
      PrintWriter output;
      output = new PrintWriter (new FileWriter (outputFileLoc));
   
      output.println (currentSizeInventory); // Total number of objects in array.
      for (int i = 0 ; i < currentSizeInventory ; i++)
      {
         output.println (inventoryList [i].getItem ()); // Write Item.
         output.println (inventoryList [i].getQuantityAvailable ()); // Write quantity available of item.
         output.println (inventoryList [i].getQuantityNeededPerWeek ()); // Write quantity needed per week for items.
         output.println (inventoryList [i].getPriceOfItem ()); // Write price of item.
         output.println (); // Write blank line.
      }
      output.close (); 
   }

        
}