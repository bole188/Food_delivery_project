
package DTOs;

public class PaymentTypeDTO {
	private int paymentTypeId;
	private String typeName;
	
	public PaymentTypeDTO() {}
	
	public PaymentTypeDTO(int o,String i) {
		this.paymentTypeId = o;
		this.typeName = i;
	}
	
	public void setPaymentTypeId(int i) {
		this.paymentTypeId = i;
	}
	
	public int getPaymentTypeId() {
		return this.paymentTypeId;
	}
	
	public void setPaymentTypeName(String in) {
		this.typeName = in;
	}
	
	public String getPaymentTypeName() {
		return this.typeName;
	}
	
	
	public String toString() {
        return "PaymentType{" +
                ", paymentTypeId='" + paymentTypeId + '\'' +
                ", typeName='" + typeName + '\'' +                
                '}';
	}
}
