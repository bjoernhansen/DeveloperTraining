package training.database.mybatis;


public class OrderItem
{
    // Bezeichner angepasst in der OrderItemsMapper.xml
    private int orderIdentification;
    private int productId;
    private int quantity;
    private double unitPrice;
    
    public int getOrderIdentification()
    {
        return orderIdentification;
    }
    
    public void setOrderIdentification(int orderIdentification)
    {
        this.orderIdentification = orderIdentification;
    }
    
    public int getProductId()
    {
        return productId;
    }
    
    public void setProductId(int productId)
    {
        this.productId = productId;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public double getUnitPrice()
    {
        return unitPrice;
    }
    
    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }
    
    @Override
    public String toString()
    {
        return "OrderItems{" +
            "orderId=" + orderIdentification +
            ", productId=" + productId +
            ", quantity=" + quantity +
            ", unitPrice=" + unitPrice + '}';
    }
}
