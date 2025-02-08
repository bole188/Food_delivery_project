package app;

import graphics.*;
import DAOs.*;
import DTOs.*;
import util.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DatabaseHelper.acquireConnection();
            if (connection != null) {
                System.out.println("Uspješno povezivanje na bazu podataka.");
            } else {
                System.out.println("Neuspješno povezivanje na bazu podataka.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseHelper.releaseConnection(connection);
        }
        ClientDAO cl = new ClientDAO();       
        List<ClientDTO> l = cl.getAll();
        for(ClientDTO c : l) {
        	System.out.println(c.getFirstName());
        }
        LogDAO a = new LogDAO();
        List<LogDTO> list = a.getAll();
        
        for(LogDTO ccc : list) {
        	System.out.println(ccc.getJob());
        }
        RestaurantDAO rd = new RestaurantDAO();
        /*RestaurantDTO rdto = new RestaurantDTO(111,"LeCoq","Stepe Stepanovica 198");
        
        rd.insert(rdto);*/
        
        /*ProductDTO pdto = new ProductDTO(123,"Leskovacki ustipci 15ka",8.50,2,1);
        ProductDAO pd = new ProductDAO();
        pd.insert(pdto);*/
        
        /*CourierDTO cdto = new CourierDTO(8,"Joohn","Dooe","387199",113,210);
        CourierDAO cd = new CourierDAO();
        cd.insert(cdto);*/
        MainFrame.main(args);
        
        
    }
}