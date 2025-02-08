package DAOs;

import DTOs.*;
import util.DatabaseHelper;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderDAO {

    public void insert(OrderDTO order) {
        String procedureCall = "{CALL InsertOrder(?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {            
            cs.setInt(1, order.getDeliveryId());
            cs.setInt(2, order.getClientId());
            cs.setInt(3, order.getRestaurantId());
            cs.setDate(4, order.getOrderDate());
            cs.setTime(5, order.getOrderTime());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLastInsertedId() {
        String procedureCall = "{CALL GetLastInsertedOrderId()}";
        int lastId = -1;

        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {

            if (rs.next()) {
                lastId = rs.getInt("last_order_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastId;
    }

    
    public OrderDTO getById(int orderId) {
    	OrderDTO order = null;
        String procedureCall = "{CALL GetOrderById(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, orderId);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                order = new OrderDTO(
                		rs.getInt("order_id"),
                        rs.getInt("delivery_id"),
                        rs.getInt("client_id"),                        
                        rs.getInt("restaurant_id"),
                        rs.getDate("order_date"),
                        rs.getTime("order_time")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public List<OrderDTO> getAll() {
        List<OrderDTO> orders = new ArrayList<>();
        String procedureCall = "{CALL GetAllOrders()}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                orders.add(new OrderDTO(
                		rs.getInt("order_id"),
                		rs.getInt("delivery_id"),
                        rs.getInt("client_id"),
                        rs.getInt("restaurant_id"),
                        rs.getDate("order_date"),
                        rs.getTime("order_time")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void update(OrderDTO order) {
        String procedureCall = "{CALL UpdateOrder(?, ?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
        	cs.setInt(1, order.getOrderId());
        	cs.setInt(2, order.getDeliveryId());
            cs.setInt(3, order.getClientId());
            cs.setInt(4, order.getRestaurantId());
            cs.setDate(5, order.getOrderDate());
            cs.setTime(6, order.getOrderTime());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int orderId) {
        String procedureCall = "{CALL DeleteOrder(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, orderId);            
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
