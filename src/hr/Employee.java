package hr;
import ap.payable;
import general.ServiceClass;
import java.util.*;

public abstract class Employee implements payable
{
    //Class instance variables
    private String firstName, lastName, position, employeeStatus;
    private int empId, age;
    private Date dateOfHire;

    private double payRate, earnings;
    private int year, month, day;
    //explicit default constructor
    public Employee()
    {}
    
    
    public Employee(String firstName,String lastName,int age, 
            String position, int year,int month, int day)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        //GregorianCalendar cal = new GregorianCalendar(year, month-1, day);
        //this.dateOfHire = cal.getTime();
        //the above two lines will do the same as the one below. 
        this.dateOfHire = new GregorianCalendar(year, month-1, day).getTime();
        //call the static method of empId to get a new ID
        this.empId = ServiceClass.getEmpId();
        //add one to the static employee counter
        this.year = year;
        this.month = month;
        this.day = day;
        
    }
    
    //GET Methods that will return information about the employee
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getFullName()
    {
        return firstName + " " + lastName;
    }
    public int getAge()
    {
        return age;
    }
    public String getPosition()
    {
        return position;
    }
    public Date getDateOfHire()
    {
        return dateOfHire;
    }
    public int getEmpId()
    {
        return empId;
    }
    public int getHireYear()
    {
        return this.year;
    }
    public int getHireMonth()
    {
        return this.month;
    }
    public int getHireDay()
    {
        return this.day;
    }
    
    //overridden toString method
    @Override
    public String toString() {
        String employeeInfo = "";

        employeeInfo += "\nEmployee Type:\t" + this.getClass().getSimpleName();
        employeeInfo += "\nName:\t" + getFullName();
        employeeInfo += "\nId:\t" + getEmpId();
        employeeInfo += "\nAge:\t" + getAge();
        employeeInfo += "\nPosition:\t" + getPosition();
        employeeInfo += "\nHire-Date:\t" + getDateOfHire();
   
 
        return employeeInfo;
    }
        
    //SET methods
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setAge(int age)
    {
        //added safety check
        if(age>80 || age<10)
        {
            this.age = age;
        }
    }
    public void setPosition(String position)
    {
        this.position = position;
    }
    public void setDateOfHire(int year, int month, int day)
    {
        //create a new calendar object and chain in the method to 
        //get the time in a Date object. 
        this.dateOfHire = new GregorianCalendar(year,month,day).getTime();
    }
    public void setEmpId(int empId)
    {
        this.empId = empId;
    }
    public void calculatePay(double hours)
    {
        earnings = hours * payRate;
    }
       
//    public abstract double earnings();
    
}//end of class
