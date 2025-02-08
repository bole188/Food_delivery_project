
package DTOs;

public class ProductTypeDTO {
	private int productTypeId;
	private String description;
	
	public ProductTypeDTO() {}
	
	public ProductTypeDTO(int o,String i) {
		this.productTypeId = o;
		this.description = i;
	}
	
	public void setProductTypeId(int i) {
		this.productTypeId = i;
	}
	
	public int getProductTypeId() {
		return this.productTypeId;
	}
	
	public void setDesc(String in) {
		this.description = in;
	}
	
	public String getDesc() {
		return this.description;
	}
	
	
	public String toString() {
        return "ProductType{" +
                ", productTypeId='" + productTypeId + '\'' +
                ", desc='" + description + '\'' +                
                '}';
	}
}
