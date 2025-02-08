package DTOs;

public class PayoutDTO {
    private int courierId;
    private int restaurantId;
    private double amount;

    public PayoutDTO() {}
    
    public PayoutDTO(int int1, int int2, double double1) {
		courierId=  int1;
		restaurantId = int2;
		amount = double1;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return "Payout{" +
                "courierId=" + courierId +
                ", restaurantId='" + restaurantId + '\'' +         
                ", amount='" + amount +
                '}';
    }
}
