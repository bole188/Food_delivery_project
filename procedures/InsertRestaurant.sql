CREATE PROCEDURE InsertRestaurant(
    IN p_restaurant_id INT,
    IN p_name VARCHAR(255),
    IN p_address VARCHAR(255)
)
BEGIN
    INSERT INTO Restaurant (restaurant_id, name, address)
    VALUES (p_restaurant_id, p_name, p_address);
END;