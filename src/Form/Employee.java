
package Form;
//The template for the Employees

import java.io.Serializable;
import java.util.ArrayList;

//Employee object template
public class Employee implements Serializable {
    
    //The database for the current empoyees
    public static ArrayList<Employee> employee = new ArrayList<>();
    
    //for the employee count database compatibility;
    public static final long serialVersionUID = 1L;
    
    //Attributes
    private String Name;
    private String ID;
    private String Position;
    private String Contact;
    private double DaysWorked;
    private double RatePerDay;
    private double RegularTotalAmount;
    
    //Overtime
    private double HoursWorked;
    private double RatePerHour;
    private double OvertimeTotalAmount;
    
    //Total Amount for te Worker
    private double TotalAmount;
    
    
    //Default Constructor
    public Employee(){}
    
    //Constructor
    public Employee(String Name, String ID, String Position, String Contact,double DaysWorked, double RatePerDay,
            double HoursWorked, double RatePerHour){
        this.Name = Name;
        this.ID = ID;
        this.Position = Position;
        this.Contact = Contact;
        this.DaysWorked = DaysWorked;
        this.RatePerDay = RatePerDay;
        this.HoursWorked = HoursWorked;
        this.RatePerHour = RatePerHour;
    }
    
    
    //Computations
    public double computeRegularPay(){
        return DaysWorked*RatePerDay;
    }
    
    public double computeOvertimePay(){
        return HoursWorked*RatePerHour;
    }
    
    public double computeTotalAmount(){
        return computeRegularPay()+computeOvertimePay();
    }
   
    public double computeDeductions(){
        return computeRegularPay()*0.1;//for tax (Changeable)
    }
    
    public double computeNetPay(){
        return computeRegularPay() - computeDeductions();
    }
    
    
    
    //Setters
    public void setName(String Name){
        this.Name = Name;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
    
    public void setPosition(String Position){
        this.Position = Position;
    }
    
    public void setContact(String Contact){
        this.Contact = Contact;
    }
    
    public void setDaysWorked(double DaysWorked){
        this.DaysWorked = DaysWorked;
    }
    
    public void setRatePerDay(double RatePerDay){
        this.RatePerDay = RatePerDay;
    }
    
    public void setRegularTotalAmount(double RegularTotalAmount){
        this.RegularTotalAmount = RegularTotalAmount;
    }
       
    public void setHoursWorked(double HoursWorked){
        this.HoursWorked = HoursWorked;
    }
    
    public void setRatePerHour(double RatePerHour){
        this.RatePerHour = RatePerHour;
    }
    
    public void setOvertimeTotalAmount(double OvertimeTotalAmount){
        this.OvertimeTotalAmount = OvertimeTotalAmount;
    }
    
    public void setTotalAmount(double TotalAmount){
       this.TotalAmount = TotalAmount;
    }
      
    
    
    //Getters
    public String getName(){
        return Name;
    }
    
    public String getID(){
        return ID;
    }
    
    public String getPosition(){
        return Position;
    }
    
    public String getContact(){
       return Contact;
    }
    
    public double getDaysWorked(){
        return DaysWorked;
    }
    
    public double getRatePerDay(){
        return RatePerDay;
    }
    
    public double getRegularTotalAmount(){
       return  RegularTotalAmount;
    }
    
    
    public double getHoursWorked(){
        return HoursWorked;
    }
    
    public double getRatePerHour(){
        return RatePerHour;
    }
    
    public double getOvertimeTotalAmount(){
        return OvertimeTotalAmount;
    }
    
    public double getTotalAmount(){
        return TotalAmount;
    }
}
