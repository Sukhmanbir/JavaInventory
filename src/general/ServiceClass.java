/**
 * This class ServiceClass defines/models the static members.
 * 
 * @author Sukhmanbir Kaur
 */

package general;

public class ServiceClass {
    public static int empId = 1000;
    public static int productId = 1;
    
    public ServiceClass(){
    }
    
    public static int getEmpId(){
        return empId++;
    }
    
    public static int getProductId(){
        return productId++;
    }
}
