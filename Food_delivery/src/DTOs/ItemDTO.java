package DTOs;

public class ItemDTO {
	private int orderId;
	private int productId;
	private String itemName;
	private int itemQuantity;
	private double itemPrice;
	
	public ItemDTO() {}
	
	public ItemDTO(int o,int p,String i, int itq,double itp) {
		this.orderId = o;
		this.productId = p;
		this.itemName = i;
		this.itemQuantity = itq;
		this.itemPrice = itp;
	}
	
	public void setOrderId(int i) {
		this.orderId = i;
	}
	
	public int getOrderId() {
		return this.orderId;
	}
	
	public void setProductId(int p) {
		this.productId = p;
	}
	
	public int getProductId() {
		return this.productId;
	}
	
	public void setItemName(String in) {
		this.itemName = in;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public void setItemQuantity(int itq) {
		this.itemQuantity = itq;
	}
	
	public int getItemQuantity() {
		return this.itemQuantity;
	}
	
	public void setItemPrice(double ip) {
		this.itemPrice = ip;
	}
	
	public double getItemPrice() {
		return this.itemPrice;
	}
	
	public String toString() {
        return "Item{" +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity='" + itemQuantity + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                '}';
	}
}
