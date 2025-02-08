package DTOs;

public class CityDTO {
 private String cityName;
 private String countryName;

 public CityDTO() {}

 public CityDTO(String cityName, String countryName) {
     this.cityName = cityName;
     this.countryName = countryName;
 }

 public String getCityName() {
     return cityName;
 }

 public void setCityName(String cityName) {
     this.cityName = cityName;
 }

 public String getCountryName() {
     return countryName;
 }

 public void setCountryName(String countryName) {
     this.countryName = countryName;
 }

 @Override
 public String toString() {
     return "City{" +
             "city_name=" + cityName +
             ", countryName='" + countryName + '\'' +
             '}';
 }
}

