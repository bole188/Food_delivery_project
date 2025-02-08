CREATE PROCEDURE GetRestaurantById(
    IN p_restaurant_id INT
)
BEGIN
    SELECT restaurant_id, name, address
    FROM Restaurant
    WHERE restaurant_id = p_restaurant_id;
END;