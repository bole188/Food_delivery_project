package DAOs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTOs.ItemDTO;
import util.DatabaseHelper;

public class ItemDAO {
	public void insert(ItemDTO item) {
        String procedureCall = "{CALL InsertItem(?, ?, ?, ?, ?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)) {
        	cs.setInt(1, item.getOrderId());
            cs.setInt(2, item.getProductId());
            cs.setString(3, item.getItemName());
            cs.setDouble(4, item.getItemQuantity());
            cs.setDouble(5, item.getItemPrice());            
            cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ItemDTO> getAllbyOrderId(int orderId) {
        List<ItemDTO> items = new ArrayList<>();
        String procedureCall = "{CALL GetAllItemsByOrderId(?)}";
        try (Connection connection = DatabaseHelper.acquireConnection();
             CallableStatement cs = connection.prepareCall(procedureCall)){
        	cs.setInt(1, orderId);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                items.add(new ItemDTO(
                		rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getString("item_name"),
                        rs.getInt("item_quantity"),
                        rs.getDouble("item_price")                                              
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
