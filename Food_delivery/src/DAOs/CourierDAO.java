package DAOs;

import DTOs.*;
import util.DatabaseHelper;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CourierDAO {

    public void insert(CourierDTO courier) {
        String procedureCall = "{CALL InsertCourier(?, ?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, courier.getCourierId());
            cs.setString(2, courier.getFirstName());
            cs.setString(3, courier.getLastName());
            cs.setString(4, courier.getPhoneNumber());
            cs.setInt(5, courier.getWalletId());
            cs.setInt(6, courier.getVehicleId());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CourierDTO getById(int courierId) {
    	CourierDTO courier = null;
        String procedureCall = "{CALL GetCourierById(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, courierId);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                courier = new CourierDTO(
                        rs.getInt("courier_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getInt("wallet_id"),
                        rs.getInt("vehicle_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courier;
    }

    public List<CourierDTO> getAll() {
        List<CourierDTO> couriers = new ArrayList<>();
        String procedureCall = "{CALL GetAllCouriers()}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                couriers.add(new CourierDTO(
                        rs.getInt("courier_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getInt("wallet_id"),
                        rs.getInt("vehicle_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return couriers;
    }

    public void update(CourierDTO courier) {
        String procedureCall = "{CALL UpdateCourier(?, ?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, courier.getCourierId());
            cs.setString(2, courier.getFirstName());
            cs.setString(3, courier.getLastName());
            cs.setString(4, courier.getPhoneNumber());
            cs.setInt(5, courier.getWalletId());
            cs.setInt(6, courier.getVehicleId());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int courierId) {
        String procedureCall = "{CALL DeleteCourier(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, courierId);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}