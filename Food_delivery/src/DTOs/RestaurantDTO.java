package DTOs;

//Restaurant.java
public class RestaurantDTO {
 private int restaurantId;
 private String name;
 private String address;

 public RestaurantDTO() {}

 public RestaurantDTO(int restaurantId, String name, String address) {
     this.restaurantId = restaurantId;
     this.name = name;
     this.address = address;
 }

 public int getRestaurantId() {
     return restaurantId;
 }

 public void setRestaurantId(int restaurantId) {
     this.restaurantId = restaurantId;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getAddress() {
     return address;
 }

 public void setAddress(String address) {
     this.address = address;
 }


 @Override
 public String toString() {
     return "Restaurant{" +
             "restaurantId=" + restaurantId +
             ", name='" + name + '\'' +
             ", address='" + address + '\'' +             
             '}';
 }
}

