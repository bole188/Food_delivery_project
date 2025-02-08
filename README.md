# Food Delivery Management System

## Project Overview
This application is a **Food Delivery Management System** designed to facilitate interactions between **clients, couriers, and administrators**. The system allows clients to place orders, couriers to manage deliveries, and administrators to oversee operations. It serves as a pilot application and requires further improvements, but it provides a solid foundation for future similar projects.

## **Technology Stack**
- **Java (Swing)** – Core programming language used for building the application.
- **MySQL** – Relational database management system used to store and manage data.
- **JDBC** – Java Database Connectivity API for interacting with MySQL.
- **DAO Pattern** – A structured approach to managing data access and business logic.
- **Stored Procedures** – SQL procedures to enhance efficiency and maintainability.

## **Application Architecture**
The application follows a layered architecture, which consists of:

### **1. DTO (Data Transfer Object)**
DTOs are plain Java objects used for transferring data between different layers of the application. They do not contain business logic but only hold attributes that represent database entities. Examples include:
- `ClientDTO`
- `OrderDTO`
- `DeliveryDTO`

### **2. DAO (Data Access Object)**
DAOs are responsible for database interaction. Each entity has its own DAO class that performs CRUD operations using JDBC and stored procedures. Examples include:
- `ClientDAO` – Handles database operations for clients.
- `OrderDAO` – Manages orders.
- `CourierDAO` – Handles courier-related operations.

### **3. UTIL (Utilities)**
The `util` package contains helper classes that support database connections and system functionality. Notable components:
- `DatabaseHelper.java` – Manages database connection pooling and access.
- `ConnectionPool.java` – Ensures efficient database connections.

### **4. GUI (Graphical User Interface)**
The GUI package contains Swing-based Java classes for user interaction. It includes:
- `MainFrame.java` – The main entry point where users select their role (Client, Courier, Admin).
- `ClientFrame.java` – Displays client details and provides order/review options.
- `CourierFrame.java` – Allows couriers to manage deliveries.
- `AdminFrame.java` – Enables administrators to manage couriers, deliveries, and logs.

## **Conclusion**
This application is a **pilot project** that serves as a functional prototype for a food delivery system. While improvements are needed, the structured design, use of stored procedures, and separation of concerns make it a strong foundation for future development.
