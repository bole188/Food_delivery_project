package DTOs;


public class DeliveryDTO {
	private int deliveryId;
	private int courierId;
    private int restaurantId;
    private java.sql.Date deliveryDate;
    private java.sql.Time deliveryTime;
    
    public DeliveryDTO() {}
    
    public DeliveryDTO(int int1, int int2,int int3, java.sql.Date date, java.sql.Time time) {
    	deliveryId = int1;
		deliveryDate = date;
		deliveryTime = time;
		courierId=  int2;
		restaurantId=  int3;
	}

    public int getDeliveryId() {
    	return this.deliveryId;
    }
    
    public void setDeliveryId(int i) {
    	this.deliveryId = i;
    }
    
    public java.sql.Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(java.sql.Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    public java.sql.Time getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(java.sql.Time deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
    
    @Override
    public String toString() {
        return "Restaurant{" +
        		"deliveryId=" + deliveryId +
                "courierId=" + courierId +            
                ", restaurantId=" + restaurantId +
                ", delivery date and time=" + deliveryDate.toString() + " and time=" + deliveryTime.toString() + 
                '}';
    }
}
