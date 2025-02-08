package graphics;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import DAOs.DeliveryDAO;
import DAOs.RestaurantDAO;
import DTOs.DeliveryDTO;
import DTOs.RestaurantDTO;

public class DeliveriesFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeliveriesFrame(int courierId) {
        setTitle("Courier Deliveries");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        DeliveryDAO deliveryDAO = new DeliveryDAO();
        List<DeliveryDTO> deliveries = deliveryDAO.getByCourierId(courierId);
        RestaurantDAO rdto = new RestaurantDAO();
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        for (DeliveryDTO delivery : deliveries) {
        	try{RestaurantDTO rdt = rdto.getById(delivery.getRestaurantId());   
            textArea.append("Delivery ID: " + delivery.getDeliveryId() + ", Restaurant name:" + (rdt.getName()) + ", Time: " + delivery.getDeliveryTime() + "\n");
        	}catch(Exception e) {        		
        		e.printStackTrace();
        	}
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        add(backButton, BorderLayout.SOUTH);
        backButton.addActionListener(e -> dispose());
    }
}
