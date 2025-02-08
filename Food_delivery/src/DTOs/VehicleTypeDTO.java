
package DTOs;

public class VehicleTypeDTO {
	private int vehicleTypeId;
	private String description;
	
	public VehicleTypeDTO() {}
	
	public VehicleTypeDTO(int o,String i) {
		this.vehicleTypeId = o;
		this.description = i;
	}
	
	public void setVehicleTypeId(int i) {
		this.vehicleTypeId = i;
	}
	
	public int getVehicleTypeId() {
		return this.vehicleTypeId;
	}
	
	public void setDesc(String in) {
		this.description = in;
	}
	
	public String getDesc() {
		return this.description;
	}
	
	
	public String toString() {
        return "VehicleType{" +
                ", vehicleTypeId='" + vehicleTypeId + '\'' +
                ", desc='" + description + '\'' +                
                '}';
	}
}
