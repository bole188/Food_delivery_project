package DAOs;

import DTOs.*;
import util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("unused")
public class CountryDAO {

	private static final String SELECT_ALL_SQL = "SELECT * FROM COUNTRY";
    private static final String UPDATE_SQL = "UPDATE COUNTRY SET name = ? WHERE name = ?";
    private static final String DELETE_SQL = "DELETE FROM COUNTRY WHERE name = ?";
	private static final String INSERT_SQL = "INSERT INTO Country (name) VALUES (?)";
    private static final String SELECT_BY_NAME_SQL = "SELECT * FROM Country WHERE name = ?";
    
    
    public void insert(CountryDTO country) {
        try (Connection connection = DatabaseHelper.acquireConnection();
             PreparedStatement ps = DatabaseHelper.initializePreparedStatement(connection, INSERT_SQL, true,
            		 country.getCountryName())) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public CountryDTO getById(String name) {
        CountryDTO country = null;
        try (Connection connection = DatabaseHelper.acquireConnection();
             PreparedStatement ps = DatabaseHelper.initializePreparedStatement(connection, SELECT_BY_NAME_SQL, false, name);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                country = new CountryDTO();
                country.setCountryName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }
    
    public List<CountryDTO> getAll() {
        List<CountryDTO> countries = new ArrayList<>();
        try (Connection connection = DatabaseHelper.acquireConnection();
             PreparedStatement ps = DatabaseHelper.initializePreparedStatement(connection,SELECT_ALL_SQL,false);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
            	CountryDTO country = new CountryDTO();
                country.setCountryName(rs.getString("name"));           
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
    
    public void update(CountryDTO country) {
        try (Connection connection = DatabaseHelper.acquireConnection();
             PreparedStatement ps = DatabaseHelper.initializePreparedStatement(connection, UPDATE_SQL, false,
                     country.getCountryName())) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String name) {
        try (Connection connection = DatabaseHelper.acquireConnection();
             PreparedStatement ps = DatabaseHelper.initializePreparedStatement(connection, DELETE_SQL, false, name)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
