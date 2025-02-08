package DAOs;

import DTOs.*;
import util.DatabaseHelper;


import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DeliveryDAO using Stored Procedures
public class DeliveryDAO {

    public void insert(DeliveryDTO delivery) {
        String procedureCall = "{CALL InsertDelivery(?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
        	cs.setInt(1, delivery.getDeliveryId());
            cs.setInt(2, delivery.getCourierId());
            cs.setInt(3, delivery.getRestaurantId());
            cs.setDate(4, delivery.getDeliveryDate());
            cs.setTime(5, delivery.getDeliveryTime());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DeliveryDTO getById(int deliveryId) {
    	DeliveryDTO delivery = null;
        String procedureCall = "{CALL GetDeliveryById(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, deliveryId);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                delivery = new DeliveryDTO(                        
                        rs.getInt("delivery_id"),
                        rs.getInt("courier_id"),
                        rs.getInt("restaurant_id"),
                        rs.getDate("delivery_date"),
                        rs.getTime("delivery_time")                        
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delivery;
    }

    public List<DeliveryDTO> getAll() {
        List<DeliveryDTO> deliveries = new ArrayList<>();
        String procedureCall = "{CALL GetAllDeliveries()}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                deliveries.add(new DeliveryDTO(                        
                        rs.getInt("delivery_id"),
                        rs.getInt("courier_id"),
                        rs.getInt("restaurant_id"),
                        rs.getDate("delivery_date"),
                        rs.getTime("delivery_time")                        
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }

    public void update(DeliveryDTO delivery) {
        String procedureCall = "{CALL UpdateDelivery(?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {            
            cs.setInt(1, delivery.getDeliveryId());
            cs.setInt(2, delivery.getCourierId());
            cs.setInt(3, delivery.getRestaurantId());
            cs.setDate(4, delivery.getDeliveryDate());
            cs.setTime(5, delivery.getDeliveryTime());        
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int deliveryId) {
        String procedureCall = "{CALL DeleteDelivery(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, deliveryId);            
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<DeliveryDTO> getByCourierId(int courierId) {
        List<DeliveryDTO> deliveries = new ArrayList<>();
        String procedureCall = "{CALL GetDeliveryByCourierId(?)}";

        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {

            cs.setInt(1, courierId);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                deliveries.add(new DeliveryDTO(                        
                        rs.getInt("delivery_id"),
                        rs.getInt("courier_id"),
                        rs.getInt("restaurant_id"),
                        rs.getDate("delivery_date"),
                        rs.getTime("delivery_time")                        
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }
}