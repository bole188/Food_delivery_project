package DTOs;

public class ProductDTO {
    private int productId;
    private String name;
    private double price;
    private int restaurantId;
    private int productTypeId;

    public ProductDTO() {}
    
    
    
    public ProductDTO(int int1, String string, double double1, int int2, int pti) {
		name = string;
		productId=  int1;
		price = double1;
		restaurantId=  int2;
		this.productTypeId = pti;
	}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                "productTypeId=" + productTypeId +
                ", restaurantId='" + restaurantId + '\'' +
                ", name='" + name +
                ", price='" + price +
                '}';
    }
}

