package entity;

import java.sql.Date;

public class CustomEntity {

    private String orderId;
    private String customerName;
    private Date orderDate;
    private String cusromerId;
    private double total;


    public CustomEntity() {
    }

    public CustomEntity(String orderId, String customerName, Date orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public CustomEntity(String orderId, String customerName, String cusromerId) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.cusromerId = cusromerId;
    }

    public CustomEntity(String orderId, String customerName, Date orderDate, String cusromerId, double total) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.cusromerId = cusromerId;
        this.total = total;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCusromerId() {
        return cusromerId;
    }

    public void setCusromerId(String cusromerId) {
        this.cusromerId = cusromerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
