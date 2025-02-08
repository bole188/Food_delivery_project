package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import DAOs.OrderDAO;
import DAOs.ItemDAO;
import DAOs.ProductDAO;
import DAOs.RestaurantDAO;
import DTOs.OrderDTO;
import DTOs.ItemDTO;
import DTOs.ProductDTO;
import DTOs.RestaurantDTO;

public class OrderFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField restaurantIdField;
    private JTextField[] productFields = new JTextField[5];
    private JButton finishOrderButton;

    private RestaurantDAO restaurantDAO = new RestaurantDAO();
    private ProductDAO productDAO = new ProductDAO();
    private OrderDAO orderDAO = new OrderDAO();
    private ItemDAO itemDAO = new ItemDAO();

    public OrderFrame(int clientId) {
        setTitle("Order Food");
        setSize(400, 300);      
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 1));

        add(new JLabel("Enter Restaurant ID:"));
        restaurantIdField = new JTextField();
        add(restaurantIdField);

        for (int i = 0; i < 5; i++) {
            add(new JLabel("Product ID " + (i + 1) + ":"));
            productFields[i] = new JTextField();
            add(productFields[i]);
        }

        finishOrderButton = new JButton("Finish Order");
        add(finishOrderButton);

        finishOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processOrder(clientId);
            }
        });

        setVisible(true);
    }

    private void processOrder(int clientId) {
        try {
            int restaurantId = Integer.parseInt(restaurantIdField.getText());

            // Check if restaurant exists
            RestaurantDTO restaurant = restaurantDAO.getById(restaurantId);
            if (restaurant == null) {
                JOptionPane.showMessageDialog(this, "Invalid restaurant ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get entered product IDs
            int[] productIds = new int[5];
            int productCount = 0;
            for (int i = 0; i < 5; i++) {
                String text = productFields[i].getText().trim();
                if (!text.isEmpty()) {
                    productIds[productCount++] = Integer.parseInt(text);
                }
            }

            if (productCount == 0) {
                JOptionPane.showMessageDialog(this, "Enter at least one product ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Verify all products exist in the given restaurant
            List<ProductDTO> availableProducts = productDAO.getByRestaurantId(restaurantId);
            boolean allProductsValid = true;

            for (int i = 0; i < productCount; i++) {
                boolean productFound = false;
                for (ProductDTO product : availableProducts) {
                    if (product.getProductId() == productIds[i]) {
                        productFound = true;
                        break;
                    }
                }
                if (!productFound) {
                    allProductsValid = false;
                    break;
                }
            }

            if (!allProductsValid) {
                JOptionPane.showMessageDialog(this, "One or more product IDs are invalid for this restaurant!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create the order
            OrderDTO order = new OrderDTO(0, 1, clientId, restaurantId, new Date(System.currentTimeMillis()), new Time(System.currentTimeMillis()));
            orderDAO.insert(order);

            // Retrieve the created order ID
            int orderId = orderDAO.getLastInsertedId(); // Assume a helper method to get last inserted ID

            // Insert items for the order
            for (int i = 0; i < productCount; i++) {
                ItemDTO item = new ItemDTO(orderId, productIds[i], "Product " + productIds[i], 1, 10.0); // Price is a placeholder
                itemDAO.insert(item);
            }

            JOptionPane.showMessageDialog(this, "Order is made successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            int confirm = JOptionPane.showConfirmDialog(this, "Order is made successfully. Return to ClientFrame?", "Success", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
                new ClientFrame(clientId).setVisible(true);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred while processing the order.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
