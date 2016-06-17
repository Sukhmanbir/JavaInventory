package inventory;


public class Manufacturer 
{
   private String manufacturerName;
   private String address;
   private String phoneNumber;
   private String contact;
   
   public Manufacturer(String manufacturerName, String address, 
           String phoneNumber, String contact)
   {
       this.manufacturerName = manufacturerName;
       this.address = address;
       this.phoneNumber = phoneNumber;
       this.contact = contact;
   }

    //GET methods
   public String getManufacturerName()
   {
       return this.manufacturerName;
   }
   public String getAddress()
   {
       return this.address;
   }
   public String getPhoneNumber()
   {
       return this.phoneNumber;
   }
   public String getContact()
   {
       return this.contact;
   }
    //SET methods
   public void setManufacturerName(String manufacturerName)
   {
       this.manufacturerName = manufacturerName;
   }
   public void setAddress(String address)
   {
       this.address = address;
   }
   public void setPhoneNumber(String phoneNumber)
   {
       this.phoneNumber = phoneNumber;
   }
   public void setContact(String contact)
   {
       this.contact = contact;
   }
}
