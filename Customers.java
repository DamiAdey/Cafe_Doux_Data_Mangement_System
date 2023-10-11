// Oluwadamilola Adeyemo
// ID: 2021-08-0281 - Period 5

// CCA - Café Doux Customers Class.

public class Customers
{

   // Fields.
   
   protected String customerName;
   protected int drinkOrders;
   protected int snackOrders;

   
   // Constructors.

   public Customers(String customerName, int drinkOrders, int snackOrders)
   {
      this.customerName = customerName;
      this.drinkOrders = drinkOrders;
      this.snackOrders = snackOrders;
   }

   
   // Accessors.

   public String getCustomerName()
   {
      return (customerName);
   }

   public int getDrinkOrders()
   {
      return (drinkOrders);
   }

   public int getSnackOrders()
   {
      return (snackOrders);
   }


   // Mutators.
   
   public void setCustomerName(String customerName)
   {
      this.customerName = customerName;
   } 
   
   public void setDrinkOrders(int drinkOrders)
   {
      this.drinkOrders = drinkOrders;
   } 
   
   public void setSnackOrders(int snackOrders)
   {
      this.snackOrders = snackOrders;
   }

   
}