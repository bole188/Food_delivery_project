package DTOs;

public class CourierDTO {
    private int courierId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int walletId;
    private int vehicleId;

    public CourierDTO() {}

    public CourierDTO(int courierId, String firstName, String lastName, String phoneNumber, int walletId, int vehicleId) {
        this.courierId = courierId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.walletId = walletId;
        this.vehicleId = vehicleId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "courierId=" + courierId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", walletId=" + walletId +
                ", vehicleId=" + vehicleId +
                '}';
    }
}
