package DTOs;

public class PaymentDTO {
	private int orderId;
	private int paymentTypeId;
    private int clientId;
    private int restaurantId;
    private java.sql.Date orderDate;
    private java.sql.Time orderTime;
    private double price;

    public PaymentDTO() {}
    
    public PaymentDTO(int o, int p,int int1, int int2, double double1, java.sql.Date date, java.sql.Time time) {
    	orderId = o;
    	paymentTypeId = p;
		clientId= int1;
		this.restaurantId = int2;
		this.price = double1;
		this.orderDate = date;
		this.orderTime = time;
	}

    public int getOrderId() {
    	return orderId;
    }
    
    public void setOrderId(int o) {
    	this.orderId = o;
    }
    
    public int getPaymentTypeId() {
    	return this.paymentTypeId;
    }
    
    public void setPaymentTypeId(int p) {
    	this.paymentTypeId = p;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public java.sql.Date getOrderDate(){
    	return this.orderDate;
    }
    
    public void setOrderDate(java.sql.Date date) {
    	this.orderDate = date;
    }
    
    public java.sql.Time getOrderTime(){
    	return this.orderTime;
    }
    
    public void setOrderTime(java.sql.Time time) {
    	this.orderTime = time;
    }
    
    @Override
    public String toString() {
        return "Payment{" +
        		"orderId=" + orderId +
        		"paymentTypeId=" + paymentTypeId +
                "clientId=" + clientId +
                ", restaurantId='" + restaurantId + '\'' +
                ", order date='" + orderDate.toString() + " and time=" + orderTime.toString()  + 
                ", order price='" + price +
                "}"; 
    }
}
