package DAOs;

import DTOs.*;
import util.*;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PaymentDAO {

    public void insert(PaymentDTO payment) {
        String procedureCall = "{CALL AddPayment(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
        	cs.setInt(1, payment.getOrderId());
        	cs.setInt(2, payment.getPaymentTypeId());
            cs.setInt(3, payment.getClientId());
            cs.setInt(4, payment.getRestaurantId());            
            cs.setDate(5, payment.getOrderDate());
            cs.setTime(6, payment.getOrderTime());
            cs.setDouble(7, payment.getPrice());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PaymentDTO getById(int orderId) {
    	PaymentDTO payment = null;
        String procedureCall = "{CALL GetPaymentById(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, orderId);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                payment = new PaymentDTO(      
                		rs.getInt("order_id"),
                		rs.getInt("Payment_type_id"),
                        rs.getInt("client_id"),
                        rs.getInt("restaurant_id"),
                        rs.getDouble("price"),
                        rs.getDate("payment_date"),
                        rs.getTime("payment_time")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

    public List<PaymentDTO> getAll() {
        List<PaymentDTO> payments = new ArrayList<>();
        String procedureCall = "{CALL GetAllPayments()}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                payments.add(new PaymentDTO(                        
                		rs.getInt("order_id"),
                		rs.getInt("Payment_type_id"),
                        rs.getInt("client_id"),
                        rs.getInt("restaurant_id"),
                        rs.getDouble("price"),
                        rs.getDate("payment_date"),
                        rs.getTime("payment_time")                        
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }

    public void update(PaymentDTO payment) {
        String procedureCall = "{CALL UpdatePayment(?, ?, ?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
        	cs.setInt(1, payment.getOrderId());
        	cs.setInt(2, payment.getPaymentTypeId());
            cs.setInt(3, payment.getClientId());
            cs.setInt(4, payment.getRestaurantId());         
            cs.setDate(5, payment.getOrderDate());
            cs.setTime(6, payment.getOrderTime());
            cs.setDouble(7, payment.getPrice());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int orderId) {
        String procedureCall = "{CALL DeletePayment(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, orderId);           
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
