package DTOs;


public class OrderDTO {
	private int orderId;
	private int deliveryId;
    private int clientId;
    private int restaurantId;
    private java.sql.Date orderDate;
    private java.sql.Time orderTime;

    public OrderDTO() {}
    
    public OrderDTO(int o,int d,int c,int r,java.sql.Date od,java.sql.Time ot) {
    	this.orderId = o;
    	this.deliveryId = d;
    	this.clientId = c;
    	this.restaurantId = r;
    	orderDate = od;
    	orderTime = ot;
    }

    public int getOrderId() {
    	return this.orderId;
    }
    
    public void setOrderId(int o) {
    	this.orderId = o;
    }
    
    public int getDeliveryId() {
    	return this.deliveryId;
    }
    
    public void setDeliveryId(int d) {
    	this.deliveryId = d;
    }
    
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public java.sql.Date getOrderDate() {
        return orderDate;
    }
    
    public java.sql.Time getOrderTime() {
        return orderTime;
    }

    public void setOrderDate(java.sql.Date orderDate) {
        this.orderDate = orderDate;
    }
    
    public void setOrderTime(java.sql.Time orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
        		"orderId=" + orderId +
        		"deliveryId=" + deliveryId +
                "clientId=" + clientId +
                ", restaurantId='" + restaurantId + '\'' +
                ", order date ='" + orderDate.toString() + " ,and time=" + orderTime.toString() +
                '}';
    }
}