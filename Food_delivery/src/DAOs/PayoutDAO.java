package DAOs;

import DTOs.*;
import util.*;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// PayoutDAO using Stored Procedures
public class PayoutDAO {

    public void insert(PayoutDTO payout) {
        String procedureCall = "{CALL AddPayout(?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {          
            cs.setInt(1, payout.getCourierId());
            cs.setInt(2, payout.getRestaurantId());
            cs.setDouble(3, payout.getAmount());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PayoutDTO getById(int payoutId) {
    	PayoutDTO payout = null;
        String procedureCall = "{CALL GetPayoutById(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, payoutId);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                payout = new PayoutDTO(                        
                        rs.getInt("courier_id"),
                        rs.getInt("restaurant_id"),
                        rs.getDouble("amount")                        
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payout;
    }

    public List<PayoutDTO> getAll() {
        List<PayoutDTO> payouts = new ArrayList<>();
        String procedureCall = "{CALL GetAllPayouts()}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                payouts.add(new PayoutDTO(                        
                        rs.getInt("courier_id"),
                        rs.getInt("restaurant_id"),
                        rs.getDouble("amount")                        
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payouts;
    }

    public void update(PayoutDTO payout) {
        String procedureCall = "{CALL UpdatePayout(?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {        
            cs.setInt(1, payout.getCourierId());
            cs.setInt(2, payout.getRestaurantId());
            cs.setDouble(3, payout.getAmount());          
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int courierId, int restaurantId) {
        String procedureCall = "{CALL DeletePayout(?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, courierId);
            cs.setInt(2, restaurantId);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


