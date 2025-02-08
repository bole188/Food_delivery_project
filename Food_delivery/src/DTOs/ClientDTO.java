package DTOs;

public class ClientDTO {
 private int clientId;
 private String firstName;
 private String lastName;
 private String address;
 private String phoneNumber;
 private String cityName;

 public ClientDTO() {}

 public ClientDTO(int clientId, String firstName, String lastName, String address, String phoneNumber, String cityName) {
     this.clientId = clientId;
     this.firstName = firstName;
     this.lastName = lastName;
     this.address = address;
     this.phoneNumber = phoneNumber;
     this.cityName =cityName;
 }

 public int getClientId() {
     return clientId;
 }

 public void setClientId(int clientId) {
     this.clientId = clientId;
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

 public String getAddress() {
     return address;
 }

 public void setAddress(String address) {
     this.address = address;
 }

 public String getPhoneNumber() {
     return phoneNumber;
 }

 public void setPhoneNumber(String phoneNumber) {
     this.phoneNumber = phoneNumber;
 }

 public String getCityName() {
     return cityName;
 }

 public void setCityName(String cityName) {
     this.cityName =cityName;
 }

 @Override
 public String toString() {
     return "Client{" +
             "clientId=" + clientId +
             ", firstName='" + firstName + '\'' +
             ", lastName='" + lastName + '\'' +
             ", address='" + address + '\'' +
             ", phoneNumber='" + phoneNumber + '\'' +
             ",cityName=" +cityName +
             '}';
 }
}

