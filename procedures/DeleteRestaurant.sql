CREATE PROCEDURE DeleteRestaurant(
    IN p_restaurant_id INT
)
BEGIN
    DELETE FROM Restaurant
    WHERE restaurant_id = p_restaurant_id;
END;