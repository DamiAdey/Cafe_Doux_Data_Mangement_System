// Oluwadamilola Adeyemo
// ID: 2021-08-0281 - Period 5

// CCA - Café Doux Customers Class.

public class CaféDouxCustomers
{

 // Fields.
   
   protected String name;
   protected int totalNumberOrders;
   protected int numberOfVisits;
  
  
   // Constructors.

   public CaféDouxCustomers(String name, int totalNumberOrders, int numberOfVisits)
   {
      this.name = name;
      this.totalNumberOrders = totalNumberOrders;
      this.numberOfVisits = numberOfVisits;
   }


   // Accessors.

   public String getName()
   {
      return name;
   }

   public int getTotalNumberOrders() 
   {
      return totalNumberOrders;
   }

   public int getNumberOfVisits()
   {
      return numberOfVisits;
   }
   

   // Mutators.
   
   public void setName(String name)
   {
      this.name = name;
   }

   public void setTotalNumberOrders(int totalNumberOrders)
   {
      this.totalNumberOrders = totalNumberOrders;
   }

   public void setnumberOfVisits(int numberOfVisits)
   {
      this.numberOfVisits = numberOfVisits;
   }

  


}