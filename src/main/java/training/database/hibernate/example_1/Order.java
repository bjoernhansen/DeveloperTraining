package training.database.hibernate.example_1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;
    
    @Column(name = "customer_id")
    private Integer customerId;
    
    @Column(name = "order_date")
    private LocalDate orderDate;
    
    private Integer status;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    Customer customer;
    
    
    public Order()
    {
    }
    
    public Order(Integer orderId, Integer customerId, LocalDate orderDate, Integer status)
    {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
    }
    
    public Integer getOrderId()
    {
        return orderId;
    }
    
    public void setOrderId(Integer orderId)
    {
        this.orderId = orderId;
    }
    
    public Integer getCustomerId()
    {
        return customerId;
    }
    
    public void setCustomerId(Integer customerId)
    {
        this.customerId = customerId;
    }
    
    public LocalDate getOrderDate()
    {
        return orderDate;
    }
    
    public void setOrderDate(LocalDate orderDate)
    {
        this.orderDate = orderDate;
    }
    
    public Integer getStatus()
    {
        return status;
    }
    
    public void setStatus(Integer status)
    {
        this.status = status;
    }
    
    @Override
    public String toString()
    {
        return "Order{orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate + ", status=" + status + '}';
    }
}
