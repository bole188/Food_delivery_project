package DAOs;

import DTOs.*;
import util.DatabaseHelper;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// RestaurantDAO using Stored Procedures
public class RestaurantDAO {

    public void insert(RestaurantDTO restaurant) {
        String procedureCall = "{CALL InsertRestaurant(?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, restaurant.getRestaurantId());
            cs.setString(2, restaurant.getName());
            cs.setString(3, restaurant.getAddress());            
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RestaurantDTO getById(int restaurantId) {
    	RestaurantDTO restaurant = null;
        String procedureCall = "{CALL GetRestaurantById(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, restaurantId);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                restaurant = new RestaurantDTO(
                        rs.getInt("restaurant_id"),
                        rs.getString("name"),
                        rs.getString("address")                        
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    public List<RestaurantDTO> getAll() {
        List<RestaurantDTO> restaurants = new ArrayList<>();
        String procedureCall = "{CALL GetAllRestaurants()}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                restaurants.add(new RestaurantDTO(
                        rs.getInt("restaurant_id"),
                        rs.getString("name"),
                        rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public void update(RestaurantDTO restaurant) {
        String procedureCall = "{CALL UpdateRestaurant(?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, restaurant.getRestaurantId());
            cs.setString(2, restaurant.getName());
            cs.setString(3, restaurant.getAddress());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int restaurantId) {
        String procedureCall = "{CALL DeleteRestaurant(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, restaurantId);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
