package DTOs;

public class VehicleDTO {
	private int vehicleId;
	private int vehicleTypeId;
	
	public VehicleDTO() {}
	
	public VehicleDTO(int vi,int vti) {
		this.vehicleId = vi;
		this.vehicleTypeId = vti;
	}
	
	public void setVehicleId(int i) {
		this.vehicleId = i;
	}
	
	public int getVehicleid() {
		return this.vehicleId;
	}
	
	public int getVehicleTypeId() {
		return this.vehicleTypeId;
	}
	
	public void setVehicleTypeId(int i) {
		this.vehicleTypeId = i;
	}
	
	public String toString() {
		return "Vehicle{" +
                ", vehicleTypeId='" + vehicleTypeId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +                
                '}';
	}
}
