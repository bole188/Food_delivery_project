package graphics;

import DAOs.CourierDAO;
import DAOs.DeliveryDAO;
import DTOs.CourierDTO;
import DTOs.DeliveryDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CourierFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int courierId;
    private JLabel idLabel, nameLabel, phoneLabel, walletLabel;
    private JButton listDeliveriesButton;
    
    public CourierFrame(int courierId) {
        this.courierId = courierId;
        setTitle("Courier Info");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1));
        
        CourierDAO courierDAO = new CourierDAO();
        CourierDTO courier = courierDAO.getById(courierId);
        
        if (courier != null) {
            idLabel = new JLabel("Courier ID: " + courier.getCourierId());
            nameLabel = new JLabel("Name: " + courier.getFirstName() + " " + courier.getLastName());
            phoneLabel = new JLabel("Phone: " + courier.getPhoneNumber());
            walletLabel = new JLabel("Wallet ID: " + courier.getWalletId());
        } else {
            idLabel = new JLabel("Courier not found.");
        }
        
        add(idLabel);
        add(nameLabel);
        add(phoneLabel);
        add(walletLabel);
        
        listDeliveriesButton = new JButton("List Deliveries");
        add(listDeliveriesButton);
        
        listDeliveriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeliveriesFrame(courierId).setVisible(true);
            }
        });
    }
}

