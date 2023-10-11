// Oluwadamilola Adeyemo
// ID: 2021-08-0281 - Period 5

// CCA - Café Doux Staff Class.

public class CaféDouxStaff
{

   // Fields.
   
   protected String name;
   protected int idNumber;
   protected String position;
   protected int hoursOfWork;
   protected double annualSalary;
   

   // Constructors.

   public CaféDouxStaff(String name, int id, String position, int hoursOfWork, double annualSalary)
   {
      this.name = name;
      this.idNumber = id;
      this.position = position;
      this.hoursOfWork = hoursOfWork;
      this.annualSalary = annualSalary;
   }
   

   // Accessors.

   public String getName()
   {
      return name;
   }

   public int getIdNumber() 
   {
      return idNumber;
   }

   public String getPosition()
   {
      return position;
   }
   
   public int getHoursOfWork()
   {
      return hoursOfWork;
   }

   public double getAnnualSalary()
   {
      return annualSalary;
   }


   // Mutators.
   
   public void setName(String name)
   {
      this.name = name;
   }

   public void setIdNumber(int idNumber)
   {
      this.idNumber = idNumber;
   }

   public void setPosition(String position)
   {
      this.position = position;
   }

   public void setHoursOfWork(int hoursOfWork)
   {
      this.hoursOfWork = hoursOfWork;
   }

   public void setAnnualSalary(double annualSalary)
   {
      this.annualSalary = annualSalary;
   }  
   

}