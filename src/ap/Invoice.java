package ap;

/**
 *
 * @author Mansi
 */
public class Invoice implements payable  
{
    private final String partNumber, partDescription;
    private int quantity;
    private double pricePerItem;
    
    public Invoice(String partNumber, String partDescription, int quantity,
                    double pricePerItem)
    {
        //validate quantity and prices
        if(quantity < 0)
            throw new IllegalArgumentException(
                    "Quantity must be greater than 0");
        if(pricePerItem < 0.0)
            throw new IllegalArgumentException(
                    "Price per item must be greater than 0.0");
        
        //initialize field members    
        this.quantity = quantity;
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.pricePerItem = pricePerItem;
    }
    
    public String getPartNumber()
    {
        return this.partNumber;
    }
    
    public String getPartDescription()
    {
        return this.partDescription;
    }
    
    public void setQuantity(int quantity)
    {
        if(quantity < 0)
            throw new IllegalArgumentException(
            "Quantity must be greater than 0");
        this.quantity = quantity;
    }
    
    public int getQuantity()
    {
        return this.quantity;
    }
    
    public void setPricePerItem(double pricePerItem)
    {
        if(pricePerItem < 0.0)
            throw new IllegalArgumentException(
                    "Price per item must be greater than 0.0");
        
        this.pricePerItem = pricePerItem;
    }
    
    public double getPricePerItem()
    {
        return this.pricePerItem;
    }
    
    @Override
    public double getPaymentAmount()
    {
        return this.getPricePerItem()*this.getQuantity();
    }
    
    
    @Override
    public String toString()
    {
        return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
                "invoice", "part number", getPartNumber(), getPartDescription(),
                "quantity", getQuantity(), "price per item", getPricePerItem());
    }
    
    
}
