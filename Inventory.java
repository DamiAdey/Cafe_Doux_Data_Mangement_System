// Oluwadamilola Adeyemo
// ID: 2021-08-0281 - Period 5

// CCA - Café Doux Inventory Class.

public class Inventory
{

   // Fields.
   
   protected String item;
   protected String quantityAvailable; 
   protected String quantityNeededPerWeek;
   protected String priceOfItem;
   
   // Constructors.

   public Inventory(String item, String quantityAvailable, String quantityNeededPerWeek, String priceOfItem)
   {
      this.item = item;
      this.quantityAvailable = quantityAvailable;
      this.quantityNeededPerWeek = quantityNeededPerWeek;
      this.priceOfItem = priceOfItem;
   }


   // Accessors.

   public String getItem()
   {
      return item;
   }

   public String getQuantityAvailable() 
   {
      return quantityAvailable;
   }

   public String getQuantityNeededPerWeek()
   {
      return quantityNeededPerWeek;
   } 
   
   public String getPriceOfItem()
   {
      return priceOfItem;
   }
   

   // Mutators.
   
   public void setItem(String item)
   {
      this.item = item;
   }

   public void setQuantityAvailable(String quantityAvailable)
   {
      this.quantityAvailable = quantityAvailable;
   }

   public void setQuantityNeededPerWeek(String quantityNeededPerWeek)
   {
      this.quantityNeededPerWeek = quantityNeededPerWeek;
   }

   public void setPriceOfItem(String priceOfItem)
   {
      this.priceOfItem = priceOfItem;
   }


}