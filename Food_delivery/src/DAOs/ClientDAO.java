package DAOs;

import DTOs.*;
import util.DatabaseHelper;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public void insert(ClientDTO client) {
        String procedureCall = "{CALL InsertClient(?, ?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, client.getClientId());
            cs.setString(2, client.getFirstName());
            cs.setString(3, client.getLastName());
            cs.setString(4, client.getAddress());
            cs.setString(5, client.getPhoneNumber());
            cs.setString(6, client.getCityName());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ClientDTO getById(int clientId) {
    	ClientDTO client = null;
        String procedureCall = "{CALL GetClientById(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, clientId);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                client = new ClientDTO(
                        rs.getInt("client_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("city_name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    public List<ClientDTO> getAll() {
        List<ClientDTO> clients = new ArrayList<>();
        String procedureCall = "{CALL GetAllClients()}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                clients.add(new ClientDTO(
                        rs.getInt("client_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getString("city_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void update(ClientDTO client) {
        String procedureCall = "{CALL UpdateClient(?, ?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, client.getClientId());
            cs.setString(2, client.getFirstName());
            cs.setString(3, client.getLastName());
            cs.setString(4, client.getAddress());
            cs.setString(5, client.getPhoneNumber());
            cs.setString(6, client.getCityName());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int clientId) {
        String procedureCall = "{CALL DeleteClient(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, clientId);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}