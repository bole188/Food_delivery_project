package graphics;

import DAOs.CourierDAO;
import DAOs.DeliveryDAO;
import DAOs.LogDAO;
import DAOs.ClientDAO;
import DTOs.CourierDTO;
import DTOs.DeliveryDTO;
import DTOs.LogDTO;
import DTOs.ClientDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdminFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminFrame() {
        setTitle("Admin Panel");
        setSize(400, 500);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JButton showLogsButton = new JButton("Show Logs");
        JButton createCourierButton = new JButton("Create Courier");
        JButton createDeliveryButton = new JButton("Create Delivery");
        JButton updateClientButton = new JButton("Update Courier");
        JButton listCouriersButton = new JButton("List Couriers");

        add(showLogsButton);
        add(createCourierButton);
        add(createDeliveryButton);
        add(updateClientButton);
        add(listCouriersButton);

        showLogsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLogs();
            }
        });

        createCourierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCourier();
            }
        });

        createDeliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDelivery();
            }
        });

        updateClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClient();
            }
        });
        
        listCouriersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listCouriers();
            }
        });
    }

    private void showLogs() {
        LogDAO logDAO = new LogDAO();
        List<LogDTO> logs = logDAO.getAll();
        StringBuilder logText = new StringBuilder("Logs:\n");
        for (LogDTO log : logs) {
            logText.append(log.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, logText.toString(), "System Logs", JOptionPane.INFORMATION_MESSAGE);
    }

    private void createCourier() {
        JTextField idField = new JTextField();
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField walletField = new JTextField();
        JTextField vehicleField = new JTextField();

        Object[] message = {
                "Courier ID:", idField,
                "First Name:", firstNameField,
                "Last Name:", lastNameField,
                "Phone Number:", phoneField,
                "Wallet ID:", walletField,
                "Vehicle ID:", vehicleField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Create Courier", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            CourierDAO courierDAO = new CourierDAO();
            CourierDTO newCourier = new CourierDTO(
                    Integer.parseInt(idField.getText()),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    phoneField.getText(),
                    Integer.parseInt(walletField.getText()),
                    Integer.parseInt(vehicleField.getText())
            );
            try{courierDAO.insert(newCourier);
            
            }catch(Exception e) {
            	JOptionPane.showMessageDialog(this, "Failed to create courier.", "Failure", JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Courier created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void createDelivery() {
        JTextField courierIdField = new JTextField();
        JTextField restaurantIdField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField timeField = new JTextField();

        Object[] message = {
                "Courier ID:", courierIdField,
                "Restaurant ID:", restaurantIdField,
                "Delivery Date (YYYY-MM-DD):", dateField,
                "Delivery Time (HH:MM:SS):", timeField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Create Delivery", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            DeliveryDAO deliveryDAO = new DeliveryDAO();
            DeliveryDTO newDelivery = new DeliveryDTO(  
                    0,  
                    Integer.parseInt(courierIdField.getText()),
                    Integer.parseInt(restaurantIdField.getText()),
                    java.sql.Date.valueOf(dateField.getText()),
                    java.sql.Time.valueOf(timeField.getText())
            );
            
            try{deliveryDAO.insert(newDelivery);            
            }catch(Exception e) {
            	JOptionPane.showMessageDialog(this, "Failed to create delivery.", "Failure", JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Delivery created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateClient() {
        JTextField courierIdField = new JTextField();
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField walletID = new JTextField();
        JTextField vehicleId = new JTextField();

        Object[] message = {
                "Courier ID:", courierIdField,
                "First Name:", firstNameField,
                "Last Name:", lastNameField,
                "Address:", addressField,
                "Phone Number:", phoneField,
                "WalletID:", walletID,
                "VehicleID:", vehicleId
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Update Courier", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            CourierDAO courierDAO = new CourierDAO();
            CourierDTO updatedCourier = new CourierDTO(
                    Integer.parseInt(courierIdField.getText()),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    addressField.getText(),                    
                    Integer.parseInt(walletID.getText()),
                    Integer.parseInt(vehicleId.getText())
            );
            try {
            courierDAO.update(updatedCourier);
            }
            catch(Exception e) {
            	JOptionPane.showMessageDialog(this, "Failed to update courier.", "Failure", JOptionPane.INFORMATION_MESSAGE);
            }
            JOptionPane.showMessageDialog(this, "Courier updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void listCouriers() {
        CourierDAO courierDAO = new CourierDAO();
        List<CourierDTO> couriers = courierDAO.getAll();
        StringBuilder courierList = new StringBuilder("Couriers:\n");
        for (CourierDTO courier : couriers) {
            courierList.append("ID: ").append(courier.getCourierId())
                       .append(", Name: ").append(courier.getFirstName()).append(" ").append(courier.getLastName())
                       .append("\n");
        }
        JOptionPane.showMessageDialog(this, courierList.toString(), "Courier List", JOptionPane.INFORMATION_MESSAGE);
    }
}
