package DTOs;

public class ReviewDTO {
    private int clientId;
    private int restaurantId;
    private String comment;

    public ReviewDTO() {}
    
    // Getters and Setters
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    @Override
    public String toString() {
        return "Review{" +
                "clientId=" + clientId +
                ", restaurantId='" + restaurantId + '\'' +
                ", comment='" + comment +            
                '}';
    }
}