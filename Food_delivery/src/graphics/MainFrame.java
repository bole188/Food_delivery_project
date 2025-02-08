package graphics;

import DTOs.*;
import DAOs.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Components
    private JCheckBox clientCheckBox;
    private JCheckBox courierCheckBox;
    private JCheckBox adminCheckBox;
    private JLabel idLabel;
    private JLabel passwordLabel;
    private JTextField idField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private ButtonGroup checkBoxGroup;

    public MainFrame() {
        // Frame settings
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null); // Center the frame

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Checkboxes
        clientCheckBox = new JCheckBox("Client");
        courierCheckBox = new JCheckBox("Courier");
        adminCheckBox = new JCheckBox("Admin");

        checkBoxGroup = new ButtonGroup();
        checkBoxGroup.add(clientCheckBox);
        checkBoxGroup.add(courierCheckBox);
        checkBoxGroup.add(adminCheckBox);

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.add(clientCheckBox);
        checkBoxPanel.add(courierCheckBox);
        checkBoxPanel.add(adminCheckBox);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(checkBoxPanel, gbc);

        // ID label and field
        idLabel = new JLabel("ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(idLabel, gbc);

        idField = new JTextField(15);
        gbc.gridx = 1;
        add(idField, gbc);

        // Password label and field
        passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        add(passwordField, gbc);

        // Submit button
        submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(submitButton, gbc);

        // Button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String idText = idField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Validate input
        if (clientCheckBox.isSelected()) {
            if (isClientValid(idText, password)) {
                new ClientFrame(Integer.parseInt(idText)).setVisible(true);
                dispose(); // Close the current frame
            } else {
                showError("Invalid Client credentials!");
            }
        } else if (courierCheckBox.isSelected()) {
            if (isCourierValid(idText, password)) {
                new CourierFrame(Integer.parseInt(idText)).setVisible(true);
                dispose(); // Close the current frame
            } else {
                showError("Invalid Courier credentials!");
            }
        } else if (adminCheckBox.isSelected()) {
            if (isAdminValid(idText, password)) {
                new AdminFrame().setVisible(true);
                dispose(); // Close the current frame
            } else {
                showError("Invalid Admin credentials!");
            }
        } else {
            showError("Please select a role!");
        }
    }

    private boolean isClientValid(String id, String password) {
        // Simulating database logic for Client
        return password.equals("client") && idExistsInDatabase(id, "client");
    }

    private boolean isCourierValid(String id, String password) {
        // Simulating database logic for Courier
        return password.equals("courier") && idExistsInDatabase(id, "courier");
    }

    private boolean isAdminValid(String id, String password) {
        // Simulating admin logic
        return id.equals("0") && password.equals("admin");
    }

    private boolean idExistsInDatabase(String id, String role) {
        // Simulate a database check (replace with actual DB logic)
        if (role.equals("client")) {
             ClientDAO cd = new ClientDAO();// Example client IDs
             if(cd.getById(Integer.parseInt(id))!=null) return true;
        } else if (role.equals("courier")) {
        	CourierDAO ce = new CourierDAO();// Example courier IDs
            if(ce.getById(Integer.parseInt(id))!=null) return true;
        }
        return false;
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}