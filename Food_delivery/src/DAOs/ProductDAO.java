package DAOs;

import DTOs.*;
import util.DatabaseHelper;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void insert(ProductDTO product) {
        String procedureCall = "{CALL InsertProduct(?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, product.getProductId());
            cs.setString(2, product.getName());
            cs.setDouble(3, product.getPrice());
            cs.setInt(4, product.getRestaurantId());
            cs.setInt(5, product.getProductTypeId());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ProductDTO getById(int productId) {
    	ProductDTO product = null;
        String procedureCall = "{CALL GetProductById(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, productId);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                product = new ProductDTO(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("restaurant_id"),
                        rs.getInt("Product_type_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<ProductDTO> getByRestaurantId(int restaurantId) {
        List<ProductDTO> products = new ArrayList<>();
        String procedureCall = "{CALL GetProductsByRestaurantId(?)}";

        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {

            cs.setInt(1, restaurantId);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                products.add(new ProductDTO(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("restaurant_id"),
                        rs.getInt("product_type_id")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
    
    public List<ProductDTO> getAll() {
        List<ProductDTO> products = new ArrayList<>();
        String procedureCall = "{CALL GetAllProducts()}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                products.add(new ProductDTO(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("restaurant_id"),
                        rs.getInt("Product_type_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void update(ProductDTO product) {
        String procedureCall = "{CALL UpdateProduct(?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, product.getProductId());
            cs.setString(2, product.getName());
            cs.setDouble(3, product.getPrice());
            cs.setInt(4, product.getRestaurantId());
            cs.setInt(5, product.getProductTypeId());
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int productId) {
        String procedureCall = "{CALL DeleteProduct(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
            cs.setInt(1, productId);
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


