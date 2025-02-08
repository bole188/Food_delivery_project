USE mydb;

-- Test Data for Restaurant Table
INSERT INTO Restaurant (restaurant_id, name, address) VALUES 
(1, 'Pizza Paradise', '123 Main Street'),
(2, 'Burger Haven', '456 Elm Street'),
(3, 'Sushi World', '789 Maple Avenue'),
(4, 'Pasta Corner', '321 Oak Boulevard'),
(5, 'Taco Fiesta', '654 Cedar Lane');

-- Test Data for Wallet Table
INSERT INTO Wallet (wallet_id, wallet_limit, wallet_amount) VALUES 
(101, 1000, 500),
(102, 1500, 750),
(103, 2000, 1200),
(104, 2500, 1800),
(105, 3000, 2900);

-- Test Data for Country Table
INSERT INTO Country (country_name) VALUES 
('United States'),
('Canada'),
('United Kingdom'),
('Australia'),
('Germany');

-- Test Data for City Table
INSERT INTO City (city_name, country_name) VALUES 
('New York', 'United States'),
('Los Angeles', 'United States'),
('Toronto', 'Canada'),
('London', 'United Kingdom'),
('Sydney', 'Australia'),
('Berlin', 'Germany'),
('Chicago', 'United States'),
('Vancouver', 'Canada'),
('Manchester', 'United Kingdom'),
('Melbourne', 'Australia');

-- Test Data for Client Table
INSERT INTO Client (client_id, first_name, last_name, address, phone_number, city_name) VALUES 
(1, 'John', 'Doe', '111 Pine Street', '123-456-7890', 'New York'),
(2, 'Jane', 'Smith', '222 Oak Lane', '987-654-3210', 'Los Angeles'),
(3, 'Bob', 'Brown', '333 Maple Drive', '555-666-7777', 'Chicago'),
(4, 'Alice', 'Johnson', '444 Elm Way', '444-555-6666', 'Berlin'),
(5, 'Eve', 'Davis', '555 Birch Avenue', '999-888-7777', 'Melbourne');

-- Test Data for Product_type Table
INSERT INTO Product_type (product_type_id, description) VALUES 
(1, 'Various types of pizzas'),
(2, 'Different kinds of burgers'),
(3, 'Fresh sushi rolls and sashimi'),
(4, 'Italian pasta dishes'),
(5, 'Mexican tacos');

-- Test Data for Vehicle_type Table
INSERT INTO Vehicle_type (vehicle_type_id, description) VALUES 
(1, 'Bike: Small and fast'),
(2, 'Car: Suitable for medium distance'),
(3, 'Van: Large vehicle for bulk');

-- Test Data for Payment_type Table
INSERT INTO Payment_type (payment_type_id, type_name) VALUES 
(1, 'Credit Card'),
(2, 'Debit Card'),
(3, 'PayPal'),
(4, 'Cash'),
(5, 'Mobile Payment');

-- Test Data for Product Table
INSERT INTO Product (product_id, name, price, restaurant_id, product_type_id) VALUES 
(1, 'Pepperoni Pizza', 12.99, 1, 1),
(2, 'Cheeseburger', 9.99, 2, 2),
(3, 'California Roll', 8.99, 3, 3),
(4, 'Spaghetti Bolognese', 10.99, 4, 4),
(5, 'Chicken Tacos', 7.99, 5, 5),
(6, 'Veggie Pizza', 11.49, 1, 1),
(7, 'Double Burger', 12.49, 2, 2),
(8, 'Salmon Roll', 10.49, 3, 3),
(9, 'Penne Alfredo', 11.99, 4, 4),
(10, 'Beef Tacos', 8.49, 5, 5);

-- Test Data for Vehicle Table
INSERT INTO Vehicle (vehicle_id, vehicle_type_id) VALUES 
(201, 1), -- 1 could represent a bike
(202, 2), -- 2 could represent a car
(203, 3), -- 3 could represent a van
(204, 1),
(205, 2);

-- Test Data for Courier Table
INSERT INTO Courier (courier_id, first_name, last_name, phone_number, wallet_id, vehicle_id) VALUES 
(1, 'Tom', 'Harris', '111-222-3333', 101, 201),
(2, 'Emma', 'Wilson', '222-333-4444', 102, 202),
(3, 'Mike', 'Brown', '333-444-5555', 103, 203),
(4, 'Sophia', 'Taylor', '444-555-6666', 104, 204),
(5, 'Lucas', 'Johnson', '555-666-7777', 105, 205);

-- Test Data for Delivery Table
INSERT INTO Delivery (delivery_id, courier_id, restaurant_id, delivery_date, delivery_time) VALUES 
(1, 1, 1, '2025-01-28', '12:45:00'),
(2, 2, 2, '2025-01-28', '13:30:00'),
(3, 3, 3, '2025-01-28', '14:45:00'),
(4, 4, 4, '2025-01-28', '15:30:00'),
(5, 5, 5, '2025-01-28', '16:50:00');

-- Test Data for Order Table
INSERT INTO `Order` (order_id, order_date, order_time, client_id, restaurant_id, delivery_id) VALUES 
(1, '2025-01-28', '12:30:00', 1, 1, 1),
(2, '2025-01-28', '13:00:00', 2, 2, 2),
(3, '2025-01-28', '14:15:00', 3, 3, 3),
(4, '2025-01-28', '15:00:00', 4, 4, 4),
(5, '2025-01-28', '16:45:00', 5, 5, 5);

-- Test Data for Item Table
INSERT INTO Item (order_id, product_id, item_name, item_quantity, item_price) VALUES 
(1, 1, 'Margarita Pizza', 2, 12),
(2, 2, 'Cheeseburger', 1, 8),
(3, 3, 'California Roll', 3, 15),
(4, 4, 'Spaghetti Bolognese', 1, 10),
(5, 5, 'Chicken Tacos', 4, 7);

-- Test Data for Payment Table
INSERT INTO Payment (order_id, price, client_id, restaurant_id, order_date, order_time, payment_type_id) VALUES 
(1, 45.98, 1, 1, '2025-01-28', '12:45:00', 1),
(2, 8.49, 2, 2, '2025-01-28', '13:15:00', 2),
(3, 47.97, 3, 3, '2025-01-28', '14:30:00', 3),
(4, 10.49, 4, 4, '2025-01-28', '15:15:00', 4),
(5, 31.96, 5, 5, '2025-01-28', '16:55:00', 5);

-- Test Data for Payout Table
INSERT INTO Payout (courier_id, restaurant_id, amount) VALUES 
(1, 1, 12.50),
(2, 2, 8.00),
(3, 3, 15.00),
(4, 4, 10.00),
(5, 5, 18.50);

-- Test Data for Review Table
INSERT INTO Review (client_id, restaurant_id, comment) VALUES 
(1, 1, 'Dobar'),
(2, 2, 'Los'),
(3, 3, 'Zao'),
(4, 4, 'Ok'),
(5, 5, 'Fuj');

