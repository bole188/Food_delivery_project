package graphics;

import javax.swing.*;

import DTOs.ClientDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DAOs.*;
import DTOs.*;

public class ClientFrame extends JFrame {
    private int clientId;
    private JLabel idLabel, firstNameLabel, lastNameLabel, addressLabel, phoneLabel, cityLabel;
    private JButton orderButton, reviewButton;

    public ClientFrame(int clientId) {
        this.clientId = clientId;
        setTitle("Client Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // Retrieve client details
        ClientDAO clientDAO = new ClientDAO();
        ClientDTO client = clientDAO.getById(clientId); // Fetch from database

        if (client == null) {
            JOptionPane.showMessageDialog(this, "Client not found!", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        // Labels
        idLabel = new JLabel("ID: " + client.getClientId());
        firstNameLabel = new JLabel("First Name: " + client.getFirstName());
        lastNameLabel = new JLabel("Last Name: " + client.getLastName());
        addressLabel = new JLabel("Address: " + client.getAddress());
        phoneLabel = new JLabel("Phone: " + client.getPhoneNumber());
        cityLabel = new JLabel("City: " + client.getCityName());

        // Buttons
        orderButton = new JButton("Make an Order");
        reviewButton = new JButton("Leave a Review");

        // Adding components to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(idLabel, gbc);

        gbc.gridy++;
        add(firstNameLabel, gbc);

        gbc.gridy++;
        add(lastNameLabel, gbc);

        gbc.gridy++;
        add(addressLabel, gbc);

        gbc.gridy++;
        add(phoneLabel, gbc);

        gbc.gridy++;
        add(cityLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        add(orderButton, gbc);

        gbc.gridx = 1;
        add(reviewButton, gbc);

        // Button Actions
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrderFrame(clientId).setVisible(true);
                dispose();
            }
        });

        reviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReviewFrame(clientId).setVisible(true);
                dispose();
            }
        });
    }
}
