CREATE PROCEDURE UpdateRestaurant(
    IN p_restaurant_id INT,
    IN p_name VARCHAR(255),
    IN p_address VARCHAR(255)
)
BEGIN
    UPDATE Restaurant
    SET name = p_name,
        address = p_address
    WHERE restaurant_id = p_restaurant_id;
END;